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

    public static void main(String[] args) throws IOException {

        LinkedList<Pagla> list = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("1...add\n2...display\n3...insert beginning\n4...Search\n5...delete\nOther...exit");
            int ch = Integer.parseInt(br.readLine());
            if (ch == 1) {
                System.out.print("Enter roll: ");
                Integer data = Integer.parseInt(br.readLine());
                System.out.print("Enter name: ");
                String name = br.readLine();

                Pagla obj = new Pagla(data, name);

                list.insert(obj);

            } else if (ch == 2) {
                list.display();
            } else if (ch == 3) {
                System.out.print("Enter roll: ");
                Integer data = Integer.parseInt(br.readLine());
                System.out.print("Enter name: ");
                String name = br.readLine();

                Pagla obj = new Pagla(data, name);

                list.insert(obj);

            } else if (ch == 4) {
                System.out.print("Enter data: ");
                Integer data = Integer.parseInt(br.readLine());

                // if (list.search(data))
                // System.out.println("Found");
                // else
                // System.out.println("not found");
            } else if (ch == 5) {
                // System.out.print("Enter data: ");
                // Integer data = Integer.parseInt(br.readLine());
                // list.delete(data);
            } else {
                return;

            }
        }

    }

}

class Pagla {
    int roll;
    String name;

    public Pagla(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pagla [name=" + name + ", roll=" + roll + "]";
    }

}