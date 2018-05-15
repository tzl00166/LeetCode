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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> results = new ArrayList<>();    
        if (root == null)
            return results;
        
        
        Queue<TreeNode> queue = new LinkedList<>();     
        queue.add(root);
        
        while (!queue.isEmpty()){
            List<Integer> result = new ArrayList<>();
            int level_cnt = queue.size();
            for (int i = 0; i < level_cnt; i++){
                TreeNode node = queue.poll();
                result.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            
            results.add(result);
        }
        
        return results;
    }
}