class Solution {
    public String reverseString(String s) {
        char[] res = new char[s.length()];
        int start = 0;
        int end = s.length() - 1;
        
        while(start <= end){
            res[start] = s.charAt(end);
            res[end] = s.charAt(start);
            start++;
            end--;
        }
        return new String(res);
    }
}