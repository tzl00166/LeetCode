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
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if(Math.abs(left - right) <= 1)
            return isBalanced(root.left) && isBalanced(root.right);
        else
            return false;
    }
    
    private int getDepth(TreeNode node){
        if(node == null)
            return 0;
        
        int max = Math.max(getDepth(node.left), getDepth(node.right));
        return max + 1;
    }
}