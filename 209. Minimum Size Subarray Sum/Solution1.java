class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int res = nums.length;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum >= s){
                    res = Math.min(res, j - i + 1);
                    break;
                }
                if(i == 0 && j == nums.length - 1)
                    return 0;
            }
        }
        return res;
    }
}