class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int buy = Integer.MAX_VALUE;
        
        for(int i = 0; i < prices.length; i++){
            res = Math.max(res, prices[i] - buy);
            if(prices[i] < buy)
                buy = prices[i];
        }
        
        return res;
    }
}