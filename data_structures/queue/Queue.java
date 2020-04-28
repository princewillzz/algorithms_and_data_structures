package queue;

import java.util.Scanner;

public class Queue {
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    Node front = null, rear = null;
    Node newNode(int data) {
        Node temp = new Node(data);
        return temp;
    }

    public void add(int data) {
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

    public void dequeue() {
        if(front == null) return;
        System.out.print("Before deletion: "); display();
        front = front.next;
        if(front == null) rear = null;
        System.out.print("After deletion : "); display();
    }

    /*public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Queue q = new Queue();
        q.add(90);q.add(80);q.add(70);q.add(60);q.add(50);q.add(40);q.add(90);
        
        while(true) {    
            int data, ch;
            System.out.print("1...add\n2...display\n3...dequeue\nEnter your choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter the data to be inserted: ");
                    data = sc.nextInt();
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