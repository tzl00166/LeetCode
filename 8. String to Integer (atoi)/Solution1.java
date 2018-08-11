/*
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.
*/

class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0)
            return 0;
        
        boolean negative = false;
        int start = 0;
        int end = 0;
        while(start < str.length() && str.charAt(start) == ' ')
            start++;
        
        if(start >= str.length())
            return 0;
        
        if(str.charAt(start) == '-'){
            negative = true;
            if(!(start < str.length() - 1 && isNum(str.charAt(start + 1))))
                return 0;
        }
        
        else if(str.charAt(start) == '+'){
            if(!(start < str.length() - 1 && isNum(str.charAt(start + 1))))
                return 0;
        }
        
        else if(!isNum(str.charAt(start)))
            return 0;
        
        end = start + 1;
        while(end < str.length() && isNum(str.charAt(end)))
              end++;
              
        String num = str.substring(start, end);
        
        int res = 0;
        try{
            res = Integer.valueOf(num);
        }
        catch(Exception e){
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
            
        return res;
    }
    
    private boolean isNum(char c){
        if(c - '0' >= 0 && c - '0' <= 9)
            return true;
        else
            return false;
    }
}