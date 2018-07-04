class Solution {
    public int dominantIndex(int[] nums) {
        if(nums.length == 1)
            return 0;
        
        int first, second;
        if(nums[1] > nums[0]){
            first = 1;
            second = 0;
        }
        else{
            first = 0;
            second = 1;
        }
                   
        for(int i = 2; i < nums.length; i++){
            if(nums[i] > nums[first]){
                second = first;
                first = i;
            }
            else if(nums[i] > nums[second])
                second = i;
        }
        
        if(nums[first] >= 2 * nums[second])
            return first;
        else
            return -1;
    }
}