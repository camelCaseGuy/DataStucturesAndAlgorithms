package BST;

public class BinarySearchTree {
	class Node {
		int val;
		Node left, right;

		public Node(int data) {
			val = data;
			left = right = null;
		}
	}

	Node root;

	BinarySearchTree() {
		root = null;
	}

	public Node insertNode(Node node, int val) {
		if (node == null) {
			node = new Node(val);
			return node;
		}
		if (val < node.val) {
			node.left = insertNode(node.left, val);
		} else if (val > node.val) {
			node.right = insertNode(node.right, val);
		}
		return node;
	}

	Node search(Node node, int val) {
		if (node == null || node.val == val) {
			return node;
		}

		if (node.val < val) {
			return search(node.right, val);
		}

		return search(node.left, val);
	}

	void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.printf("%s ", node.val);
		inOrder(node.right);
	}

	Node delete(Node node, int val) {
		// the base case
		if (node == null) {
			return node;
		}

		// get through ancestry of tree
		if (node.val > val) {
			node.left = delete(node.left, val);
			return node;
		} else if (node.val < val) {
			node.right = delete(node.right, val);
			return node;
		}

		// node found

		// one child is empty
		if (node.left == null) {
			Node temp = node.right;
			return temp;
		} else if (node.right == null) {
			Node temp = node.left;
			return temp;
		}

		// two child nodes
		else {
			Node replacementParent = node;

			// find the replacement
			Node replacement = node.right;
			while (replacement.left != null) {
				replacementParent = replacement;
				replacement = replacement.left;
			}

			// delete
			if (replacementParent != node)
				replacementParent.left = replacement.right;
			else
				replacementParent.right = replacement.right;

			// copy val
			node.val = replacement.val;

			// Delete replacement and return node
			return node;
		}
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
// 40, 60, 20, 80, 50, 10, 30, 15, 5, 35, 25, 45, 55, 70, 90, 32, 33, 48, 46
		tree.root = tree.insertNode(tree.root, 40);
		tree.insertNode(tree.root, 60);
		tree.insertNode(tree.root, 20);
		tree.insertNode(tree.root, 80);
		tree.insertNode(tree.root, 50);
		tree.insertNode(tree.root, 10);
		tree.insertNode(tree.root, 30);
		tree.insertNode(tree.root, 15);
		tree.insertNode(tree.root, 5);
		tree.insertNode(tree.root, 35);
		tree.insertNode(tree.root, 25);
		tree.insertNode(tree.root, 45);
		tree.insertNode(tree.root, 55);
		tree.insertNode(tree.root, 70);
		tree.insertNode(tree.root, 90);
		tree.insertNode(tree.root, 32);
		tree.insertNode(tree.root, 33);
		tree.insertNode(tree.root, 48);
		tree.insertNode(tree.root, 46);

		tree.inOrder(tree.root);

		tree.delete(tree.root, 40);
		
		System.out.println("\n===============");
		
		tree.inOrder(tree.root);
		
		System.out.println("\n===============");
		
		tree.delete(tree.root, 20);
		
		tree.inOrder(tree.root);
		
	}
}
