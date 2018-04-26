/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 
 The the basic idea is to take the last element in postorder array as the root, find the position of the root in the inorder array; then locate the range for left sub-tree and right sub-tree and do recursion. Use a HashMap to record the index of root in the inorder array.
 
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0)
            return null;
        
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            maps.put(inorder[i], i);
        
        return buildTreeHelper(inorder, postorder, 0, 0, postorder.length, maps);
    }
    
    public TreeNode buildTreeHelper(int[] inorder, int[] postorder, int instart, int poststart, int length, Map<Integer, Integer> maps){
        if (length == 0)
            return null;
        TreeNode node = new TreeNode(postorder[poststart + length - 1]);
        int index = maps.get(postorder[poststart + length - 1]);
        node.left = buildTreeHelper(inorder, postorder, instart, poststart, index - instart, maps);
        node.right = buildTreeHelper(inorder, postorder, index + 1, poststart + index - instart, length - 1 - (index - instart), maps);
        return node;
    }
}