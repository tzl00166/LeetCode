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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode current = root;
        
        while(current != null){
            if(current.val < val){
                if(current.right == null){
                    current.right = new TreeNode(val);
                    break;
                }   
                current = current.right;
            }
            else{
                if(current.left == null){
                    current.left = new TreeNode(val);
                    break;
                }
                current = current.left;
            }           
        }
        
        return root;
    }
}