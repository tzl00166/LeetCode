class Solution {
    public int firstUniqChar(String s) {
        int result = s.length();
        if(result == 0)
            return -1;
        
        for(char c = 'a'; c <= 'z'; c++){
            int index = s.indexOf(c);
            if(index != -1 && s.lastIndexOf(c) == index)
                result = Math.min(result, index);
        }
        
        return result == s.length() ? -1 : result;
    }
}