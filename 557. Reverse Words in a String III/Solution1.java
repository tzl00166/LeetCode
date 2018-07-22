class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = 0;
        while(start < s.length() && end < s.length()){
            while(end < s.length() && s.charAt(end) != ' ')
                end++;
            sb.append(reverse(s.substring(start, end))).append(" ");
            while(end < s.length() && s.charAt(end) == ' ')
                end++;
            start = end;
        }
        return sb.toString().trim();
    }
    
    private String reverse(String word){
        char[] res = new char[word.length()];
        int left = 0;
        int right = word.length() - 1;
        while(left <= right){
            res[left] = word.charAt(right);
            res[right] = word.charAt(left);
            left++;
            right--;
        }
        return new String(res);
    }
}