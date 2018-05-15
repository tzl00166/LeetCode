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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
       
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            
            if (node != null){
                if (node.left != null){
                    TreeNode temp = new TreeNode(node.val);
                    stack.push(node.right);
                    stack.push(temp);
                    stack.push(node.left);
                }
                else{
                    result.add(node.val);
                    stack.push(node.right);
                } 
            }                  
        }     
        return result;
    }
}