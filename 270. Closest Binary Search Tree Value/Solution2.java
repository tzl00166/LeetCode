/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// BST (Binary Search Tree): root.left.val < root.val < root.right.val 
class Solution {
    public int closestValue(TreeNode root, double target) {
        int result = root.val;
        
        while(root != null){
            if(Math.abs(root.val - target) < Math.abs(result - target))
                result = root.val;
            if(target > root.val)
                root = root.right;
            else
                root = root.left;
        }
        
        return result;
    }
}