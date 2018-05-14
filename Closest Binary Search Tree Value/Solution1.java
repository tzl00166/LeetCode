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
    public int closestValue(TreeNode root, double target) {
        List<Integer> values = new ArrayList<>();
        buildTreeValues(root, values);
        Collections.sort(values);
        
        int left = 0;
        int right = values.size() - 1;
        
        while(left + 1 < right){
            int mid = left + (right - left)/2;
            if(values.get(mid) < target)
                left = mid;
            else
                right = mid;
        }
        
        return (target - values.get(left)) < (values.get(right) - target) ? values.get(left) : values.get(right);
    }
    
    private void buildTreeValues(TreeNode node, List<Integer> values){
        if(node == null)
            return;
        values.add(node.val);
        buildTreeValues(node.left, values);
        buildTreeValues(node.right, values);
    }
}