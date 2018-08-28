class Solution {
    public int maxSubArray(int[] A) {
        if(A == null || A.length == 0) return 0;
        int max = A[0];
        int[] dp = new int[A.length];
        dp[0] = A[0];
        
        for(int i = 1; i <= A.length-1; i++) {
            dp[i] = Math.max(A[i], dp[i-1]+A[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}