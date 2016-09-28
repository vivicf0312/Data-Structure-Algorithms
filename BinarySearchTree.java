public class BinarySearchTree {

	public BSTNode root;

	public void insertNode(int value) {
		BSTNode node = new BSTNode(value);

		if (root == null) {
			root = node;
			System.out.println("Root added : " + root.value);
			return;
		}
		insertRec(root, node);
	}

	public void insertRec(BSTNode latestRoot, BSTNode node) {

		if (latestRoot.value > node.value) {
			if (latestRoot.leftChild == null) {
				latestRoot.leftChild = node;
				System.out.println("Child " + latestRoot.leftChild.value
						+ " added to the left of " + latestRoot.value);
				return;
			} else {
				insertRec(latestRoot.leftChild, node);
			}
		} else {
			if (latestRoot.rightChild == null) {
				latestRoot.rightChild = node;
				System.out.println("Child " + latestRoot.rightChild.value
						+ " added to the right of " + latestRoot.value);
				return;
			} else {
				insertRec(latestRoot.rightChild, node);
			}
		}
	}

	public int findMin() {
		if (root == null) {
			return 0;
		} else {
			BSTNode currNode = root;
			while (currNode.leftChild != null) {
				currNode = currNode.leftChild;
			}
			System.out.println("The minimun value is: " + currNode.value);
			return currNode.value;
		}
	}

	public int findMax() {
		if (root == null) {
			return 0;
		} else {
			BSTNode currNode = root;
			while (currNode.rightChild != null) {
				currNode = currNode.rightChild;
			}
			System.out.println("The maximun value is: " + currNode.value);
			return currNode.value;
		}
	}
	/**
	 * Printing the contents of the tree in an inorder way.
	 */
	public void printInorder(){
	  System.out.println("The result of the inOrder way is: ");
	  printInOrderRec(root);
	  System.out.println("");
	}

	/**
	 * Helper method to recursively print the contents in an inorder way
	 */
	private void printInOrderRec(BSTNode currRoot){
	  if ( currRoot == null ){
	    return;
	  }
	  printInOrderRec(currRoot.leftChild);
	  System.out.print(currRoot.value + ",");
	  printInOrderRec(currRoot.rightChild);
	}
	/**
	 * Printing the contents of the tree in a Preorder way.
	 */
	public void printPreorder() {
	   System.out.println("The result of the preOrder way is: ");
	   printPreOrderRec(root);
	   System.out.println("");
	}

	/**
	 * Helper method to recursively print the contents in a Preorder way
	 */
	private void printPreOrderRec(BSTNode currRoot) {
	  if (currRoot == null) {
	    return;
	  }
	  System.out.print(currRoot.value + ", ");
	  printPreOrderRec(currRoot.leftChild);
	  printPreOrderRec(currRoot.rightChild);
	}
	/**
	 * Printing the contents of the tree in a Postorder way.
	 */
	public void printPostorder() {
	  System.out.println("The result of the postOrder way is: ");
	  printPostOrderRec(root);
	  System.out.println("");
	}

	/**
	 * Helper method to recursively print the contents in a Postorder way
	 */
	private void printPostOrderRec(BSTNode currRoot) {
	  if (currRoot == null) {
	    return;
	  }
	  printPostOrderRec(currRoot.leftChild);
	  printPostOrderRec(currRoot.rightChild);
	  System.out.print(currRoot.value + ", ");

	}
	
	public static void main(String[] args) {
		BinarySearchTree BST = new BinarySearchTree();
		BST.insertNode(40);
		BST.insertNode(25);
		BST.insertNode(78);
		BST.insertNode(10);
		BST.insertNode(32);
		BST.insertNode(50);
		BST.insertNode(93);
		BST.insertNode(3);
		BST.insertNode(17);
		BST.insertNode(30);
		BST.insertNode(38);
		BST.findMin();
		BST.findMax();
		BST.printInorder();
		BST.printPreorder();
		BST.printPostorder();
	}

}

class BSTNode {
	public int value;
	public BSTNode leftChild;
	public BSTNode rightChild;

	public BSTNode(int value) {
		this.value = value;
	}

}
