class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(N < 0 && x != 0){
            x = 1/x;
            N = -N;
        }
        
        return myPowHelper(x, N);
    }
    
    private double myPowHelper(double x, long n){
        if(n == 0)
            return 1;
        
        double half = myPowHelper(x, n/2);
        double result = 0;
        
        if(n % 2 == 1)
            result = half * half * x;
        else
            result = half * half;
                 
        return result;
    }
}