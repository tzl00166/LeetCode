class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null)
            return 0;
        
        return haystack.indexOf(needle);
    }
}