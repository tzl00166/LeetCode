/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 
// Iterative Solution.
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        
        Queue<TreeLinkNode> stack = new LinkedList<>();
        stack.add(root);
        
        while (!stack.isEmpty()){
            int level_count = stack.size();
            for (int i = 0; i < level_count; i++){
                TreeLinkNode node = stack.poll();
                if (i != level_count - 1)
                    node.next = stack.peek();
                if (node.left != null)
                    stack.add(node.left);
                if (node.right != null)
                    stack.add(node.right);
            }           
        }
    }
}