class Solution {
    public void rotate(int[] nums, int k) {
        
        if (nums.length == 1)
            return;
        
        int i = 1;
        int n = 0;
        int j = 0;
        while (i <= k){
            n = nums.length - 1;
            j = nums[n];
            while (n > 0){
                nums[n] = nums[n-1];
                n--;
            }
            nums[0] = j;
            i++;
        }
    }
}