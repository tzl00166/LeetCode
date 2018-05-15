/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Top-down
class Solution {
    public int maxDepth(TreeNode root) {
        int result = 0;
        result = TopDown(root, result);
        return result;
        
    }
    
    public int TopDown(TreeNode node, int depth){
        if (node == null)
            return depth;
        if (node.left == null && node.right == null)
            return depth + 1;
        int left_max = TopDown(node.left, depth + 1);
        int right_max = TopDown(node.right, depth + 1);
        return Math.max(left_max, right_max);
    }
}