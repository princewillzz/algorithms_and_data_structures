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
    public Node head = null;
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
    // Hash Map Implementation
    int loop_detector() {
        int ans = 0, count = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        Node temp = head;
        while(temp != null) {
            count++;
            int data = temp.data;
            if(!hmap.containsKey(data)) {
                hmap.put(data, count);
            } else {
                ans = count - hmap.get(data) + 1;
                break;
            }
            temp = temp.next;
        }

        return ans;
    }
    // Floyd's cycle Algorithm
    boolean detectLoop() {
        Node slow_p = head, fast_p = head;
        while(slow_p!=null && fast_p!=null && slow_p.next!=null && fast_p.next.next!=null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if(slow_p.data == fast_p.data) {
                return true;
            }
        }
        return false;
    }
    /*public static void main(String args[]) {

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
    }*/
}

class SinglyLinkedList {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        ll.add_last(10);
        ll.add_last(20);
        ll.add_last(30);
        ll.add_last(40);
        //ll.add_last(40);
        //ll.head.next.next.next.next.next = ll.head.next.next.next;
        while(true) {
            System.out.println("1...add\n2...display\n3...Loop Detector\n4...exit");
            int ch = sc.nextInt();
            if(ch == 1) {
                System.out.print("Enter data: ");
                int data = sc.nextInt();
                ll.add_last(data);
            } else if(ch == 2) {
                ll.display();
            } else if(ch == 3) {
                System.out.println(ll.detectLoop());
            }
            else {
                return;
            }
        }
    }
}