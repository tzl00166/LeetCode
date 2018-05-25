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
        List<Integer> inorder = new ArrayList<>();
        inOrder(root, inorder);
        
        for(int i = 1; i < inorder.size(); i++){
            if(inorder.get(i) <= inorder.get(i - 1))
                return false;
        }
        
        return true;
    }
    
    private void inOrder(TreeNode node, List<Integer> inorder){
        if(node == null)
            return;
        
        inOrder(node.left, inorder);
        inorder.add(node.val);
        inOrder(node.right, inorder);
    }
}