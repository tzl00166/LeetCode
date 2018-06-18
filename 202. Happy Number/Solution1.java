/*
The idea is to use one hash set to record sum of every digit square of every number occurred. Once the current sum cannot be added to set, return false; once the current sum equals 1, return true.
*/

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        
        while(set.add(n)){
            int sum = 0;
            while(n != 0){
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            if(sum == 1)
                return true;
            n = sum;
        }
        
        return false;
    }
}