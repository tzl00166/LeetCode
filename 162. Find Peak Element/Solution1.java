class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right){
            int mid = left + (right - left)/2;
            //since left must be smaller than right, so this "mid+1" would never throw a overflow
            if(nums[mid] <= nums[mid + 1])
                left = mid + 1;
            else
                right = mid;
        }
        
        return left;
    }
}