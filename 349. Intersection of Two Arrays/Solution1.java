class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        if(nums1.length == 0 || nums2.length == 0 || nums1 == null || nums2 == null)
            return new int[]{};
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> re = new ArrayList<>();
        
        int current = nums1[0];
        
        for(int i = 0; i < nums1.length; i++){
            // if it is a duplicate item, skip it
            if(i != 0 && nums1[i] == current)
                continue;
            else{
                int left = 0;
                int right = nums2.length - 1;
                while(left <= right){
                    int mid = left + (right - left)/2;
                    if(nums2[mid] == nums1[i]){
                        re.add(nums2[mid]);
                        break;
                    }
                    else if(nums2[mid] < nums1[i])
                        left = mid + 1;
                    else
                        right = mid - 1;
                }               
                current = nums1[i];
            }
        }
        
        int[] result = new int[re.size()];
        for(int i = 0; i < re.size(); i++){
            result[i] = re.get(i);
        }
        
        return result;
    }
}