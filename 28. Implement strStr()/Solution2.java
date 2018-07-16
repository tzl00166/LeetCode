class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0)
            return 0;
        
        int key = needle.length();
        int stack = haystack.length();
        if(key > stack)
            return -1;
        
        for(int i = 0; i <= stack - key; i++){
            for(int j = i; j < i + key; j++){
                char c1 = haystack.charAt(j);
                char c2 = needle.charAt(j - i);
                if(c1 != c2)
                    break;
                
                if(j == i + key - 1)
                    return i;
            }
        }
        
        return -1;
    }
}