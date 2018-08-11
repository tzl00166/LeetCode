class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        
        if(s.length() == 0)
            return true;
        
        char[] array = s.toCharArray();
        int right = 0;
        for(int i = 0; i < array.length; i++)
            if(Character.isLetterOrDigit(array[i]))
                array[right++] = Character.toLowerCase(array[i]);
        right--;
        
        int left = 0;
        while(left < right){
            if(array[left] != array[right])
                return false;
            left++;
            right--;
        }
        return true;
    }
}