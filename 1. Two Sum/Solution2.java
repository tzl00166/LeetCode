class Solution {
    public int[] twoSum(int[] nums, int target) {
        
		// They key is value, the value is the key
        Map<Integer, Integer> map = new HashMap<>();
        
        int result[] = new int[2];
        
        for (int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if (map.containsKey(temp)){
                result[0] = map.get(temp);
                result[1] = i;
                return result;
            }
            else
                map.put(nums[i], i);
        }
        
        return result;
    }
}