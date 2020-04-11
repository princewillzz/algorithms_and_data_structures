import java.util.*;
class LinkedList {
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    Node head = null;
    Node newNode(int data) {
        Node temp = new Node(data);
        return temp;
    }
    void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
            System.out.println();
        }
    }
    void add_last(int data) {
        Node temp = head;
        if(head == null) {
            head = newNode(data);
            return;
        }
        while(temp.next != null) temp = temp.next;
        temp.next = newNode(data);
    }
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        while(true) {
            System.out.println("1...add\n2...display\n3...exit");
            int ch = sc.nextInt();
            if(ch == 1) {
                System.out.print("Enter data: ");
                int data = sc.nextInt();
                ll.add_last(data);
            } else if(ch == 2) {
                ll.display();
            } else {
                return;
            }
        }
    }
}

class SinglyLinkedList {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        while(true) {
            System.out.println("1...add\n2...display\n3...exit");
            int ch = sc.nextInt();
            if(ch == 1) {
                System.out.print("Enter data: ");
                int data = sc.nextInt();
                ll.add_last(data);
            } else if(ch == 2) {
                ll.display();
            } else {
                return;
            }
        }
    }
}