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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        
        if(root.val == key){
            if(root.left == null && root.right == null)
                root = null;
            else if(root.left == null)
                root = root.right;
            else if(root.right == null)
                root = root.left;
            else{
                TreeNode successor = findSuccessor(root);
                root.val = successor.val;
                root.right = deleteNode(root.right, successor.val);
            }
        }
        else if(root.val < key)
            root.right = deleteNode(root.right, key);
        else
            root.left = deleteNode(root.left, key);
        
        return root;
    }
    
    private TreeNode findSuccessor(TreeNode node){
        TreeNode result = node.right;
        
        while(result != null && result.left != null)
            result = result.left;
        
        return result;
    }
}