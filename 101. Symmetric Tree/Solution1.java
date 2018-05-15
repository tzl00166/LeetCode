/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Iterative Solution
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        
        Deque<TreeNode> stack = new LinkedList<>();
        stack.add(root.left);
        stack.add(root.right);
        
        while (!stack.isEmpty()){
            TreeNode leftest = stack.pollFirst();
            TreeNode rightest = stack.pollLast();
            
            if (leftest != null && rightest != null){
                if (leftest.val != rightest.val)
                    return false;
                stack.push(leftest.right);
                stack.push(leftest.left);
                stack.add(rightest.left);
                stack.add(rightest.right);
            }
            else if (leftest == null && rightest == null)
                ;
            else
                return false;         
        }
        
        return true;
    }
}