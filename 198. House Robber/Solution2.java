class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        if(nums.length == 1)
            return nums[0];
        
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        sum[1] = nums[1] > nums[0] ? nums[1] : nums[0];
        int premax = 0;
        
        for(int i = 2; i < nums.length; i++){
            premax = Math.max(premax, sum[i - 2]);
            sum[i] = nums[i] + premax;
        }
        
        return Math.max(sum[sum.length - 1], sum[sum.length - 2]);
    }
}