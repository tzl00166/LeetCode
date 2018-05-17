class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if(nums1.length == 0 || nums2.length == 0)
            return new int[]{};
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> al = new ArrayList<>();
        
        int point2 = 0;
        
        for(int i = 0; i < nums1.length; i++){ 
            while(nums1[i] > nums2[point2] && point2 < nums2.length - 1){
                point2++;
            }
            if(nums1[i] == nums2[point2]){
                al.add(nums1[i]);
                point2++;
                if(point2 >= nums2.length)
                    break;
                else
                    continue;
            }
            else if(nums1[i] < nums2[point2]){
                continue;
            }   
        }
        
        int[] result = new int[al.size()];
        for(int i = 0; i < result.length; i++)
            result[i] = al.get(i);
        
        return result;
            
    }
}