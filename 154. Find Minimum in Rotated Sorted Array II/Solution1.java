// Would allow duplicates affect the run-time complexity? How and why?
// yes, the run-time complexity differences will be more along with the duplicates orrcu
// the most extreme case would be an array of the same elements, then the run time would be O(n) instead of O(log N);

class Solution {
    public int findMin(int[] nums) {
        if(nums[0] < nums[nums.length - 1])
            return nums[0];
        
        int left = 0;
        int right = nums.length - 1;
                
        while(left + 1 < right){
            // needs to redo this judge to see if it is sorted or not
            // since if it is the case "else left++", it is not a step from binary search
            // it is a reset for another binary search, so needs to check if it is sorted from the beginning
            if(nums[left] < nums[right])
                return nums[left];
            
            int mid = left + (right - left)/2;
            if(nums[mid] < nums[left])
                right = mid;
            else if(nums[mid] > nums[left])
                left = mid;
            else
                // if mid == left, get rid of left and take reset as a new one start binary search
                left++;
        }
        
        return nums[right];
    }
}