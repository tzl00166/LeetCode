import java.lang.StringBuilder;

public class Solution {
    public String reverseWords(String s) {
        
      StringBuilder sb = new StringBuilder();
        int end = s.length() - 1;
        int start = end;
        while(end >= 0 && start >= 0) {
            while(start >= 0 && s.charAt(start) != ' ') {
                start--;
            }
            sb.append(s.substring(start + 1, end + 1));
            sb.append(" ");
            while(start >= 0 && s.charAt(start) == ' ') {
                start--;
            }
            end = start;
        }
        return sb.toString().trim(); 
    
}
}