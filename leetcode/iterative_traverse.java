import java.util.*;

public class postorder {
	public List<Integer> postorderTraverse (TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();

		while (!stack.empty() || root != null) {
			if (root != null) {
				stack.push(root);
				result.add(root.val);
				root = root.right;
			} else {
				root = stack.pop().left;
			}
		}
	}
}

public class inorder {
	public List<Integer> inorderTraverse (TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Deque<TreeNdoe> stack = new ArrayDeque<TreeNode>();

		TreeNode curr = root;

		while (!stack.empty() || curr != null) {
			if (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			TreeNode temp = stack.pop();
			result.add(temp.val);
			curr = temp.right;
		}
		return result;
	}
}

public class preorder {
	
}