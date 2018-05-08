class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right){
            int mid = left + (right - left)/2;
			// if the rest is sorted, then pick the left value
            if(nums[left] <= nums[mid] && nums[mid] <= nums[right])
                return nums[left];
			// if the rest is not sorted, means smallest value in the unsorted half
			// if left part is sorted, then pick the right half, exclude mid since it cannot smallest
            if(nums[left] <= nums[mid]){
                left = mid + 1;
            }
			// if right part is sorted, then pick the left half, include the mid since it could be smallest
            else 
                right = mid;
        }
        
        return nums[left];
    }
}