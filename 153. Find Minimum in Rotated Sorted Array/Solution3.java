class Solution {
    public int findMin(int[] nums) {
        
        // why the hell need I do this even for sure I know it is rotated?
        if(nums[nums.length - 1] >= nums[0])
            return nums[0];
        
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left + 1 < right){
            int mid = left + (right - left)/2;
            if(nums[mid] < nums[left])
                right = mid;
            else
                left = mid;
        }
        
        return nums[right];
    }
}