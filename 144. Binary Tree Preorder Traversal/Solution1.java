import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		root2.left = root3;
		root1.right = root2;	
		List<Integer> result = preorderTraversal(root1);
		System.out.print(result);
	}
	
	public static List<Integer> preorderTraversal(TreeNode root) {
	    List<Integer> result = new LinkedList<>();
	    Deque<TreeNode> stack = new LinkedList<>();
	    stack.push(root);
	    while (!stack.isEmpty()) {
	        TreeNode node = stack.pop();
	        if (node != null) {
	            result.add(node.val);
	            stack.push(node.right);
	            stack.push(node.left);
	        }
	    }
	    return result;
	}
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
