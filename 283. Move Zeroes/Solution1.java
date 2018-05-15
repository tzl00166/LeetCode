class Solution {
    public void moveZeroes(int[] nums) {
        // non-zero position
        int cnt = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                nums[cnt] = nums[i];
                cnt++;
            }
        }
        
		// cnt becomes the first 0's position
        for (int i = cnt; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}