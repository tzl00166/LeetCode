class Solution {
    public int missingNumber(int[] nums) {
        int total = 0;
        for(int i : nums){
            total =total+i;
        }
        
        return ((nums.length+1)*(nums.length)/2)- total;
    }
}