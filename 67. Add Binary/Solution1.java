class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b ==null || b.length()==0 ) return a;
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int digitA = 0, digitB=0;
        for (int i = a.length()-1, j = b.length()-1; i >= 0 || j >= 0; i--, j--){
            digitA = (i>-1)? a.charAt(i)- '0': 0;
            digitB = (j>-1)? b.charAt(j) -'0': 0;
            sb.append((carry + digitA + digitB ) % 2);
            carry = (carry + digitA + digitB) /2;             
        }
        if (carry == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}