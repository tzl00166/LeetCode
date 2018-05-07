class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while(left <=right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target)
                return mid;
            // if the rotate point is in right half, left half is still sorted
            if(nums[left] <= nums[mid]){
                // if target is within left half range, search left
                if(nums[mid] > target && nums[left] <= target)
                    right = mid - 1;
                // search right
                else
                    left = mid + 1;
            }
            // if the roate point is in left half, right half is still sorted
            else{
                // if target is within right half range, search right
                if(nums[mid] < target && nums[right] >= target)
                    left = mid + 1;
                // search left
                else
                    right = mid - 1;
            }            
        }
        
        return -1;
    }
}