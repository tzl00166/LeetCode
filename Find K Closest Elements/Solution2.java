class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        // make sure that in the case left = right - 1, mid's max value is arr.length - k -1,
        // then max value of mid + k = arr.length - 1, overflow will not happen 
        int right = arr.length - k;
        
        while(left < right){
            int mid = left + (right - left)/2;
            if(x - arr[mid] <= arr[mid + k] - x)
                right = mid;
            else
                left = mid + 1;
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < k; i++)
            result.add(arr[left + i]);
        
        return result;
    }
}