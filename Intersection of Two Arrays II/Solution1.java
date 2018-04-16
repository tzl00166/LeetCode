class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        ArrayList<Integer> sum = new ArrayList<Integer>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ){
            if (nums1[i] < nums2[j])
                i++;
            else if(nums1[i] == nums2[j]){
                sum.add(nums1[i]);
                i++;
                j++;
            }
            else
                j++;
        }
        
        int[] result = new int[sum.size()];
        for (int i = 0; i < sum.size(); i++){
            result[i] = sum.get(i);
        }
        
        return result;
    }
}