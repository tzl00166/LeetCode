class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> ns = new HashSet<>();
        List<Integer> re = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++){
            ns.add(nums1[i]);
        }
        for(Integer j : nums2){
            if(ns.contains(j)){
                ns.remove(j);
                re.add(j);
            }
        }
        int[] res = new int[re.size()];
        for(int k = 0; k < res.length; k++){
            res[k] = re.get(k);
        }
        return res;
    }
}