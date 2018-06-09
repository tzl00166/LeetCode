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
    
    private boolean flag = true;
    
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        
        int depth = getDepth(root);
        return flag;
    }
    
    private int getDepth(TreeNode node){
        if(node == null)
            return 0;
        
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        if(Math.abs(left - right) > 1)
            flag = false;
        
        int max = Math.max(left, right);
        return max + 1;
    }
}