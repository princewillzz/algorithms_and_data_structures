import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class LinkedList<T> {

    private Node root;

    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            next = null;
        }
    }

    public void insert(T data) {
        Node node = new Node(data);

        if (this.root == null) {
            this.root = node;
        } else {
            Node temp = root;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = node;

        }

    }

    public void display() {
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void insertBegin(T data) {
        Node node = new Node(data);

        node.next = root;
        root = node;

    }

    public boolean search(T data) {

        Node temp = root;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    public void delete(T data) {
        if (root == null)
            return;

        if (root.data.equals(data)) {
            root = root.next;
            return;
        }

        // Simple or main logical part

        Node temp = root;

        while (temp.next != null && temp.next.data.equals(data)) {
            temp = temp.next;
        }

        if (temp.next != null)
            temp.next = temp.next.next;

    }

    

    

}
