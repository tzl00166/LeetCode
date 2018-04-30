/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

// Iterative solution: level order traversal
public class Solution {
    public void connect(TreeLinkNode root) {
        
        while (root != null){
            TreeLinkNode level_start = new TreeLinkNode(0); // records the 1st node of each level
            TreeLinkNode currentChild = level_start;
            while (root != null){                           // here the root is each node of this level
                if (root.left != null){
                    currentChild.next = root.left;
                    currentChild = currentChild.next;
                }
                if (root.right != null){
                    currentChild.next = root.right;
                    currentChild = currentChild.next;
                }
                
                root = root.next;                           // point root to the next node of this level
            }
            root = level_start.next;                        // point root to the first node of next level
        }
    }
}