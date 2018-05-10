class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = searchLeft(nums, target);
        if(left == -1)
            return new int[]{-1,-1};
        int[] result = new int[2];
        result[0] = left;
        // pass in the leftedge, no need to search the left part for rightedge
        result[1] = searchRight(nums, target, left);
        
        return result;
    }
    
    private int searchLeft(int[] nums, int target){
        int result = -1;
        if(nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length - 1;
        
        while(left + 1 < right){
            int mid = left + (right - left)/2;
            if(nums[mid] >= target)
                right = mid;
            else
                left = mid;
        }
        if(nums[right] == target)
            result = right;
        if(nums[left] == target)
            result = left;
        
        return result;
    }
    
    private int searchRight(int[] nums, int target, int left){
        int result = -1;
        int right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left)/2;
            // there is no way that nums[mid] < target
            if(nums[mid] == target)
                left = mid;
            else
                right = mid;
        }
        
        if(nums[left] == target)
            result = left;
        if(nums[right] == target)
            result = right;
        
        return result;
    }
}