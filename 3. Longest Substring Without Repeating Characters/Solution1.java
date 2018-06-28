class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        Set<Character> set = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                if(!set.add(s.charAt(j))){
                    result = Math.max(result, set.size());
                    set.clear();
                    break;
                }
            }
        }
        
        return Math.max(result, set.size());
    }
}