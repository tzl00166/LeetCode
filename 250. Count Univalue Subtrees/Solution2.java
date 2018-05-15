class Solution {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        isUnival(root);
        return count;        
    }
    private boolean isUnival(TreeNode root) {
        if (root == null) return true;
        boolean left = isUnival(root.left);
        boolean right = isUnival(root.right);
        if (left && right) {
            if ((root.left == null || root.left.val == root.val) && (root.right == null || root.right.val == root.val)) {
                count++;
                return true;
            }            
        }
        return false;
    }
}