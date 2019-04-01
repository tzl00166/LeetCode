/*
Bit Manipulation [Accepted]
We can harness the fact that XOR is its own inverse to find the missing element in linear time.
*/

class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for(int i = 0; i < nums.length; i++){
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}