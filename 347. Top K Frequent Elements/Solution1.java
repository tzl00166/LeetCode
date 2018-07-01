class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        List<Integer> times = new ArrayList<Integer>(map.values());
        Collections.sort(times);
        int thresh = times.get(times.size() - k);
        for(int i : map.keySet()){
            if(map.get(i) >= thresh)
                result.add(i);
        }
        return result;
    }
}