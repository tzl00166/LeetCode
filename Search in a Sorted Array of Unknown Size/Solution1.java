class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 19999;
        
        while(left + 1 < right){
            int mid = left + (right - left)/2;
            if(reader.get(mid) == 2147483647)
                right = mid;
            else
                left = mid;
        }
        
        int rightEdge = reader.get(right) == 2147483647 ? left : right;
        
        left = 0;
        right = rightEdge;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(reader.get(mid) == target)
                return mid;
            else if(reader.get(mid) > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        
        return -1;
    }
}