class Solution {
    public int myAtoi(String str) {
        long result = 0;
        boolean minus = false;
        boolean hasNum = false;
        int i = 0;
        while (i < str.length()) {            
            char currentChar = str.charAt(i++);
            if (currentChar == '-' ) {
                if (!hasNum) {
                    hasNum = true;
                    minus = true;
                }
                else {
                    break;
                }
            }
            else if (currentChar == '+' ) {
                if (!hasNum) {
                    hasNum = true;
                    minus = false;
                }
                else {
                    break;
                }
            }
            else if (currentChar >= '0' && currentChar <= '9') {
                hasNum = true;
                if (!minus) {
                    result = result * 10 + currentChar-'0';
                    if (result > Integer.MAX_VALUE){
                        result = Integer.MAX_VALUE;
                        break;
                    }
                }
                else {
                    result = result * 10 - currentChar + '0';
                    if (result < Integer.MIN_VALUE) {
                        result = Integer.MIN_VALUE;
                        break;
                    }
                }
            }
            else if (currentChar == ' ') {
                if (!hasNum)
                {
                    continue;
                }
                else {
                    break;
                }
            }
            else {
                break;
            }
        }
        
        return (int)(result);
    }
}