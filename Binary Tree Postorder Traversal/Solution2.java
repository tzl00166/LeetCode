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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        postorderHelper(root, result);
        
        return result;
    }
    
    public void postorderHelper(TreeNode node, List<Integer> result){
        if (node == null)
            return;
        
        if(node.left != null || node.right != null){
            postorderHelper(node.left, result);
            postorderHelper(node.right, result);
            result.add(node.val);
        }
        else
            result.add(node.val);
    }
}