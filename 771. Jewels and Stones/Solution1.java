class Solution {
    public int numJewelsInStones(String J, String S) {
        int[] dict = new int[58];
        int result = 0;
        for(char c : J.toCharArray())
            dict[c - 'A'] = 1;
        
        for(char c : S.toCharArray())
            if(dict[c - 'A'] == 1)
                result++;
        return result;
    }
}