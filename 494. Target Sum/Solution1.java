class Solution {
    
    int res = 0;
    
    public int findTargetSumWays(int[] nums, int S) {
        find(nums, S, 0, 0);
        return res;
    }
    
    private void find(int[] nums, int S, int start, int sum){
        
        if(start == nums.length){
            if(S == sum)
                res++;
            return;
        }
        
        find(nums, S, start + 1, sum + nums[start]);
        find(nums, S, start + 1, sum - nums[start]);
    }
}