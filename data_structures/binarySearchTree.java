import java.util.*;

public class binarySearchTree {

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root = null;

    Node newNode(int data) {
        return new Node(data);
    }

    Node helper(int data, Node temp) {
        if (temp == null) {
            temp = newNode(data);
            return temp;
        }
        if (data < temp.data) {
            temp.left = helper(data, temp.left);
        } else {
            temp.right = helper(data, temp.right);
        }
        return temp;
    }

    void insert(int data) {
        if (root == null) {
            root = newNode(data);
            return;
        }
        Node temp = root;
        temp = helper(data, temp);
    }

    void inorder() {
        Node temp = root;
        inorder_helper(temp);

    }

    void inorder_helper(Node temp) {
        if (temp == null)
            return;

        inorder_helper(temp.left);
        System.out.print(temp.data + " ");
        inorder_helper(temp.right);

    }

    public static void main(String argv[]) {
        Scanner sc = new Scanner(System.in);
        binarySearchTree bst = new binarySearchTree();
        while(true) {
            System.out.println("\n1...add\n2...display\n3...exit");
            int ch = sc.nextInt();
            if(ch == 1) {
                System.out.print("Enter data: ");
                int data = sc.nextInt();
                bst.insert(data);
            } else if(ch == 2) {
                bst.inorder();
            } else {
                return;
            }
        }
        

    }
    

}