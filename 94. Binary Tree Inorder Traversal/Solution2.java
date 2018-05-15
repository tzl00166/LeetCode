/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
// Recursive Solution
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
		RecursiveHelper(result, root);
        return result;
    }
	
	public void RecursiveHelper(List<Integer> result, TreeNode node){
		if (node == null)
			return;
		
		if (node.left == null){
			result.add(node.val);
			RecursiveHelper(result, node.right);
		}
		else{
			RecursiveHelper(result, node.left);
            result.add(node.val);
			RecursiveHelper(result, node.right);
		}
	}
}