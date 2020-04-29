package queue;

//import java.util.Scanner;

public class Queue<T> {
    class Node {
        T data;
        Node next;
        Node(T data) {
            this.data = data;
            next = null;
        }
    }
    Node front = null, rear = null;
    Node newNode(T data) {
        Node temp = new Node(data);
        return temp;
    }

    public void add(T data) {
        Node temp = newNode(data);
        if(rear == null) {
            front = temp;
            rear = temp;
            return;
        }
        rear.next = temp;
        rear = rear.next;
    }
    public void display() {
        if(front == null) return;
        Node temp = front;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        if(front == null) return true;
        return false;
    }

    public T dequeue() {
        if(front == null) return null;
        //System.out.print("Before deletion: "); 
        Node temp = front;
        front = front.next;
        if(front == null) rear = null;
        return temp.data;
        //System.out.print("After deletion : "); 
    }

    /*public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Queue<Float> q = new Queue<Float>();
        q.add(9.8f);//q.add("harsh");q.add("Tiwaei");q.add("boy");q.add("is");//q.add(50);q.add(40);q.add(90);
        
        while(true) {    
            int ch;
            System.out.print("1...add\n2...display\n3...dequeue\nEnter your choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter the data to be inserted: ");
                    float data = sc.nextFloat();
                    q.add(data);
                    break;
                case 2:
                    q.display();
                    break;
                case 3: 
                    q.dequeue();
                    break;
                default:
                    return;
            }
           
        }
    }*/
}