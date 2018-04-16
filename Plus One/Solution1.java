class Solution {
    public int[] plusOne(int[] digits) {
        long num = 0;
        
        for (int i = 0; i < digits.length -1; i++){
            num = (num + digits[i]) * 10;
        }
        
        num += digits[digits.length -1] + 1;
        
        ArrayList<Integer> rev = new ArrayList<Integer>();
        while (num > 0){
            rev.add((int)(num % 10));
            num /= 10;
        }
        
        int[] result = new int[rev.size()];
        for (int i = 0; i < result.length; i++){
            result[i] = rev.get(rev.size() - i -1);
        }
        
        return result;
    }
}