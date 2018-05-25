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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<Integer> li = new ArrayList<>();
        inorderTraverse(root, li);
        int index = li.indexOf(p.val);
        if(index == li.size() - 1)
            return null;
        return fetch(root, li.get(index + 1));
    }
    
    private void inorderTraverse(TreeNode node, List<Integer> li){
        if(node == null)
            return;
        
        inorderTraverse(node.left, li);
        li.add(node.val);
        inorderTraverse(node.right, li);
    }
    
    private TreeNode fetch(TreeNode root, int target){
        while(root != null){
            if(root.val == target)
                return root;
            else if(root.val < target)
                root = root.right;
            else
                root = root.left;
        }
        
        return root;
    }
    
}