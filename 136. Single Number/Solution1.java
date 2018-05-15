class Solution {
    public int singleNumber(int[] nums) {
        
        // Stupidest way, loops in loops
        int i = 0;
        int j = 0;
        while (i < nums.length){
            j = 0;
            while (j < nums.length){
                if ((nums[i] == nums[j]) && (i != j))
                    break;
                j++;
            }
            if ((j == nums.length) && (nums[i] != nums[j-1])){
                return nums[i];
            }
            i++;
        }
        
        return nums[i-1];
    }
}