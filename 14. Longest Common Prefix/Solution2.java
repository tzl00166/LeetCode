class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        
        StringBuilder sb = new StringBuilder();
        String str1 = strs[0];
        if(str1 == null || str1.length() == 0)
            return "";
        
        for(int i = 0; i < str1.length(); i++){
            char c = str1.charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(i > strs[j].length() - 1 || strs[j].charAt(i) != c)
                    return sb.toString();
            }
            sb.append(c);
        }
        return sb.toString();
    }
}