class Solution {
    public boolean containsDuplicate(int[] nums) {
    	// sort the array first, why is this faster than 1st?
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] == nums[i+1])
                return true;            
        }
        return false;
    }
}