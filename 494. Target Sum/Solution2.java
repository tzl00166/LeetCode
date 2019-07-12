class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        
        for(int num : nums)
            sum += num;
        
        if((S + sum) % 2 > 0 || sum < S)
            return 0;
        
        int target = (S + sum) / 2;
        
        int[] res = new int[target + 1];
        res[0] = 1;
        
        for(int i = 0; i < nums.length; i++){
            for(int j = target; j >= nums[i]; j--){
                res[j] += res[j - nums[i]];
            }
        }
        
        return res[target];
    }
}