class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
       Set<Integer> set1 = new HashSet<>();
		Set<Integer> set = new HashSet<>();
		for(int i:nums1) {
			set1.add(i);
		}
		for(int j = 0 ; j<nums2.length;j++) {
			int target = nums2[j];
			if(set1.contains(target)) {set.add(target);}
		}
		int num1[] = new int[set.size()];
		int k = 0;
		for(int m:set) {
			num1[k++] = m ;
			}
		 return num1;
    }
}