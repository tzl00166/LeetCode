class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        
        int res = 0;
        
        for(; res < nums.length; res++){
            int left = 0;
            int right = 0;
            for(int i = 0; i < res; i++)
                left += nums[i];
            for(int j = nums.length - 1; j > res; j--)
                right += nums[j];
            if(left == right)
                return res;
        }
        return -1;
    }
}