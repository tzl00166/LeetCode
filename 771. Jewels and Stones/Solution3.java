class Solution {
    public int numJewelsInStones(String J, String S) {
        int jewelTot = 0;
        for(char stone : S.toCharArray()){
            if(J.indexOf(stone) != -1) jewelTot++;
        }
        return jewelTot;
    }
}