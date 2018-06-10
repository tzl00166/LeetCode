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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        
        int mid = (nums.length - 1)/2;
        int[] left = new int[mid];
        int[] right = new int[nums.length - 1 - mid];
        for(int i = 0; i < mid; i++)
            left[i] = nums[i];
        
        int count = 0;
        for(int i = mid + 1; i < nums.length; i++)
            right[count++] = nums[i];
        
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(left);
        node.right = sortedArrayToBST(right);
        
        return node;
    }
}