class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int old = nums[0];
        int point = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != old){
                nums[point++] = nums[i];
                old = nums[i];
            }
        }
        return point;
    }
}