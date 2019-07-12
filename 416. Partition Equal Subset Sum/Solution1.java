class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums)
            sum += num;
        if(sum % 2 > 0)
            return false;
        
        int n = sum / 2;
        boolean[] res = new boolean[n + 1];
        res[0] = true;
        
        for(int num : nums){
            for(int i = n; i - num >= 0; i--){
                res[i] = res[i] || res[i - num];
            }
        }
        
        return res[n];

    }
}