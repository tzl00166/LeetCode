class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(!set.add(num))
                set.remove(num);
        }
        
        int result = 0;
        for(int num : set)
            result = num;
        
        return result;
    }
}