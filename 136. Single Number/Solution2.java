class Solution {
    
    /*
     from https://www.tutorialspoint.com/java/java_basic_operators.htm
     ^ (bitwise XOR)
     Binary XOR Operator copies the bit if it is set in one operand but not both.
     */
    public int singleNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum ^= nums[i];
        }
        return sum;
    }
}