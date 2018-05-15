class Solution {
    public boolean containsDuplicate(int[] nums) {
    	// Hash map dictionary
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            if (!set.add (num))
                return true;
        }
        return false;
    }
}