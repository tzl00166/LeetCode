class Solution {
    public boolean isPerfectSquare(int num) {
        
        if(num == 1)
            return true;
        
        int left = 1;
        // start from 4, sqrt(x) must be smaller than x / 2
        int right = num / 2;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            if(mid == num / mid && num % mid == 0)
                return true;
            if(mid  < num / mid)
                left = mid + 1;
            // else has 2 cases
            // 1) mid > num / mid;
            // 2) mid == num / mid && num % mid != 0
            else
                right = mid - 1;
        }
        
        return false;
    }
}