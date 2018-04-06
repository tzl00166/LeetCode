class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2)
		return nums.length;
 
    	int j = 1;
	    int i = 0;
 
	    while (i < nums.length -1) {
		    if (nums[i] != nums[i+1]) {
                nums[j] = nums[i+1];
               j++; 
            }	    		
            i++;
        }
        return j;
    }
}