/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 
 
  The the basic idea is to take the first element in preorder array as the root, find the position of the root in the inorder array; then locate the range for left sub-tree and right sub-tree and do recursion. Use a HashMap to record the index of root in the inorder array.
 
 */
 
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0 || preorder.length ==0)
            return null;
        
        Map<Integer, Integer> map = new HashMap<>();        
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return buildTreeHelper(inorder.length, 0, 0, preorder, inorder, map);
    }
    
    public TreeNode buildTreeHelper(int length, int prestart, int instart, int[] preorder, int[] inorder, Map<Integer, Integer> map){
        if (length == 0)
            return null;
        
        TreeNode node = new TreeNode(preorder[prestart]);
        
        int index = map.get(preorder[prestart]);
        
        node.left = buildTreeHelper(index - instart, prestart + 1, instart, preorder, inorder, map);
        node.right = buildTreeHelper((length - 1) - (index - instart), (prestart + 1) + (index - instart), index + 1, preorder, inorder, map);
        
        return node;
    }
}