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
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean helper(TreeNode node, long min, long max){
        if (node == null)
            return true;
        if (node.val <= min || node.val >= max)
            return false;
        else {
            return helper(node.left,min,node.val)&&helper(node.right,node.val,max);
        }
    }
}