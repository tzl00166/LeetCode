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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        return check(root, sum);
    }
    
    public boolean check(TreeNode node, int remain){     
        if (node.left == null && node.right == null){
            if (remain == node.val)
                return true;
            else
                return false;
        }
        else if(node.left == null && node.right != null)
            return check(node.right, remain - node.val);
        else if(node.left != null && node.right == null)
            return check(node.left, remain - node.val);
        else 
            return (check(node.left, remain - node.val) || check (node.right, remain - node.val));
    }
}