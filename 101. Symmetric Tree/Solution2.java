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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isReserse(root.left, root.right);
    }
    
    public boolean isReserse(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return ((root1.val == root2.val) && 
            isReserse(root1.left, root2.right) && 
            isReserse(root1.right, root2.left));
    }
}