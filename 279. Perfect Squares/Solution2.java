public int numSquares(int n) {
        
        int numLen = 1;
        while(numLen*numLen < n) numLen++;
        
        if(numLen*numLen > n) numLen--;
        
        int[] nums = new int[numLen];
        
       // Fill it like [25,16,9,4,1] to avoid sorting.
        for(int i = numLen - 1; i >= 0; i--){
            nums[numLen - i - 1] = (i+1)*(i+1);
        }
        
        Map<Integer, Integer> ways = new HashMap<>();
        ways.put(1, 1); // 1 = 1
        ways.put(0, 0);// 0 means you need 0 number to get 0.
        
        return numSquares(ways, nums, n);
    }
    
    public int numSquares(Map<Integer, Integer> ways, int[] nums, int n){
        if(ways.containsKey(n)) return ways.get(n); // we already knew the ways to add up to n.
        
        int min = Integer.MAX_VALUE, way = 0;
        for(int i = 0; i < nums.length; i++){
            if(n - nums[i] >= 0){// as long as you can use 1 of the num
                way = numSquares(ways, nums, n-nums[i]);// solve the rest
                min = Math.min(min, way); // only get the min out of all possible solutions.
            }
        }
        
        min++;// you used at least one coin.
        ways.put(n, min);// n previoiusly does not exist in ways and is guranteed to be the min.
        
        return min;
    }