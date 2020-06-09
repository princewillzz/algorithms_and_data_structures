import java.util.Scanner;
import queue.Queue;

public class BinaryTree<T> {

	class Node {
		T data;
		Node left, right;
		Node(T data) {
			this.data = data;
			left = right = null;
		}
	} Node root = null;

	Node newNode(T data) {
		Node temp = new Node(data);
		return temp;
	}

	void insert(T data) {
		if(root == null) {
			root = newNode(data);
			return;
		}
		
		Queue<Node> q = new Queue<Node>();
		q.add(root);
		while(!q.isEmpty()) {
			Node node = q.dequeue();
			if(node.left == null) {
				node.left = newNode(data);
				return;
			} else q.add(node.left);
			if(node.right == null) {
				node.right = newNode(data);
				return;
			} else q.add(node.right);

		}

	}

	void levelOrder() {
        
        Node temp = root;
        Queue<Node> q = new Queue<Node>();
        q.add(temp);
        while(!q.isEmpty()) {
            Node item = q.dequeue();
            System.out.print(item.data + " ");
            if(item.left != null) q.add(item.left);
            if(item.right != null) q.add(item.right);
        }
		System.out.println();
	}
	
	void inorder() {
		Node temp = root;
		inorder_helper(temp);
		System.out.println();
	}
	void inorder_helper(Node temp) {
		if(temp == null) return;
		inorder_helper(temp.left);
		System.out.print(temp.data + " ");
		inorder_helper(temp.right);
	}
	

    public static void main(String argv[]) {
        Scanner sc = new Scanner(System.in);
		BinaryTree<harsh> bt = new BinaryTree<harsh>();
		harsh har = new harsh("harsh");harsh nis = new harsh("nishi");
											bt.insert(har); 
						bt.insert(nis); 									bt.insert(nis);
		 bt.insert(nis); 					bt.insert(har);			bt.insert(nis);			bt.insert(nis);
	bt.insert(har);  

		bt.levelOrder();
		bt.inorder();
					bt.insert(har);
								bt.insert(nis);
		bt.levelOrder();
		bt.inorder();

		sc.close();
    }

}

class harsh {
	String name;
	@Override
	public String toString() {
		return name;
	}
	harsh(String name) {
		this.name = name;
	}
}
