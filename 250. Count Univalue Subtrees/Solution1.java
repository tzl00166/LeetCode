/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null)
            return 0;
        
        int count = 0;
        
        count = countNode(root) ? 1 : 0;
        
        return count + countUnivalSubtrees(root.right) + countUnivalSubtrees(root.left);
        
    }
    
    public boolean countNode(TreeNode node){
        
        boolean result = true;
        
        if (node.left != null)
            result &= ((node.val == node.left.val) && countNode(node.left));
        if (node.right != null)
            result &= ((node.val == node.right.val) && countNode(node.right));
        
        return result;
    }
}