/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
/* 
Question:
If you do not know the height of the BST h but you are given the total number of nodes N of the BST, can you express the time complexity and space complexity using N instead of h?

Hint:
What's the difference of the relationship between N and h in the best case and the relationship in the worst case?

Answer: Best case is O(LogN), worst case is N.
*/
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null){
            if(root.val == val)
                return root;
            if(root.val < val)
                root = root.right;
            else
                root = root.left;
        }
        
        return null;
    }
}