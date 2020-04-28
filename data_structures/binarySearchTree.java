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

    void delete(int data) {
        System.out.print("Before Deletion: ");inorder();
        Node temp = root;
        temp = delete_helper(temp, data);
        System.out.print("After Deletion: "); inorder();
    }
    Node delete_helper(Node temp, int data) {
        if(temp == null) return null;
        if(data < temp.data) temp.left = delete_helper(temp.left, data);
        else if(data > temp.data) temp.right = delete_helper(temp.right, data);
        else {
            if(temp.left == null && temp.right == null) return null;
            if(temp.left == null || temp.right == null) {
                if(temp.left == null) return temp.right;
                return temp.left;
            }

            int smallest_value_in_right = find_smallest_in_right(temp.right);
            temp.data = smallest_value_in_right;
            temp.right = delete_helper(temp.right, smallest_value_in_right);
        }

        return temp;
    } 

    int find_smallest_in_right(Node temp) {
        if(temp.left == null) return temp.data;
        temp = temp.left;
        return temp.data;
    }
 
    public static void main(String argv[]) {
        Scanner sc = new Scanner(System.in);
        binarySearchTree bst = new binarySearchTree();
        bst.insert(50);bst.insert(30);bst.insert(10);bst.insert(20);bst.insert(100);bst.insert(150);bst.insert(80);
        while(true) {
            System.out.print("\n1...add\n2...display\n3...delete\n4...exit\nEnter your choice: ");
            int ch = sc.nextInt();
            if(ch == 1) {
                System.out.print("Enter data: ");
                int data = sc.nextInt();
                bst.insert(data);
            } else if(ch == 2) {
                bst.inorder();
            } else if(ch == 3) {
                System.out.print("Enter data to be deleted: ");
                int data = sc.nextInt();
                bst.delete(data);
            }
            else {
                return;
            }
        }
        

    }
    

}