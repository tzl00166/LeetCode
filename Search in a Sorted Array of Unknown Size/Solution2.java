class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        
        if(reader.get(1) == 2147483647){
            if(reader.get(0)==target){
                return 0;
            }
        }
        
        // use increase binary search to get the range
        while(reader.get(high) < target){
            low = high;
            high = 2*high;
        }
        
        // use decrease binary search to get the value
        while(low<=high){
            int mid =low + (high-low)/2;
            
            if(reader.get(mid)==target){
                return mid;
            }else{
                if(reader.get(mid) < target){
                    low = mid+1;
                }else{
                    high = mid -1;
                }
                
            }
        }
        
        return -1;      
    }
}