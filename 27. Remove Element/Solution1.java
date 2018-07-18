/*
Confused why the returned value is an integer but your answer is an array?
Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeElement(nums, val);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
*/
class Solution {
    public int removeElement(int[] nums, int val) {
        int move = 0;
        for(int i = 0; i < nums.length; i++)
            if(nums[i] != val)
                nums[move++] = nums[i];
        return move;
    }
}