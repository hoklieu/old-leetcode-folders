private static class Node {
	private int key;
	private double value;
	private Node left, right;

	Node(int k, double v) {
		key = k;
		value = v;
		left = null;
		right = null;
	}
}

public class BSTree {
	public boolean find (int key) {
		//empty
		if (root == null) {
			return false;
		}
		Node curr = root;
		while (curr.key != key) {
			if (curr.key > key) {//go to left
				curr = curr.left;
			} else {
				curr = curr.right;
			}
			if (curr == null) {
				return false;
			}
		}
		return true;
	}
	public void insert (int key, double value) {
		//empty
		Node newNode = new Node(key, value);
		if (root == null) {
			root = newNode;
			return;
		}
		Node curr = root;
		Node parent = root;

		while (true) {
			if (curr.key == key) {
				return;
			}
			parent = curr;
			if (curr.key > key) {
				curr = curr.left;
				if (curr == null) {
					parent.left = newNode;
					return;
				}
			} else {
				curr = curr.right;
				if (curr == null) {
					parent.right = newNode;
					return;
				}
			}

		}
	}
	public void delete (int key) {
		Node parent = root; //keep track of the parent
		Node curr = root; //keep track of the current
		//four cases:
		if (root == null) {
			return;
		}
		boolean isLC = true;
		//not found, in the loop
		while (curr.key != key) {
			//remember to keep track of the parent!!!
			parent = curr;
			if (curr.key < key) {
				isLC = false;
				curr = curr.right;
			} else {
				isLC = right;
				curr = curr.left;
			}
			//case 1: not found
			if (curr == null) {
				return;
			}
		}
		//found, three cases:
		//case 2: is a leaf
		if (curr.left == null && curr.right == null) {
			if (curr == root) {
				root = null;
			} else if (isLC) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if (curr.left == null) {
		//case 3: only have one child, just need to update its child to this hole
			if (curr == root) {
				root = curr.right;
			} else if (isLC) {
				parent.left = curr.right;
			} else {
				parent.right = curr.right;
			}
		} else if (curr.right == null) {
			if (curr == root) {
				root = curr.left;
			} else if (isLC) {
				parent.left = curr.left;
			} else {
				parent.right = curr.left;
			}
		} else {
			//case 4: has two children
			Node successor = getSuccessor(curr);
			if (curr == root) {
				root = successor;
			} else if (isLC) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}
			//not done yet!
			successor.left = curr.left;
		}
		
	}
	private Node getSuccessor (Node toDelete) {
		Node sp = toDelete;
		Node suc = toDelete;
		Node curr = toDelete.right;

		while (curr != null) {
			sp = suc;
			suc = curr;
			curr = curr.left;
		}
		//need to do: suc.right given to 
		if (suc != toDelete.right) {//have at least one lc
			sp.left = suc.right;
			suc.right = toDelete.right;
		}
		return suc;
	}
}