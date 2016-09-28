import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearchTree {

	public void levelOrderQueue(BFSNode root) {
		Queue<BFSNode> q = new LinkedList<BFSNode>();
		if (root == null)
			return;
		q.add(root);
		while (!q.isEmpty()) {
			BFSNode n = (BFSNode) q.remove();
			System.out.print(" " + n.data);
			if (n.left != null)
				q.add(n.left);
			if (n.right != null)
				q.add(n.right);
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		BFSNode root = new BFSNode(5);
		root.left = new BFSNode(10);
		root.right = new BFSNode(15);
		root.left.left = new BFSNode(20);
		root.left.right = new BFSNode(25);
		root.right.left = new BFSNode(30);
		root.right.right = new BFSNode(35);

		BreadthFirstSearchTree i = new BreadthFirstSearchTree();
		System.out.println("Breadth First Search : ");
		i.levelOrderQueue(root);
	}
}

class BFSNode {
	int data;
	BFSNode left;
	BFSNode right;

	public BFSNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	public String toString(){
		return " " + data;
	}
}