class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        int count = 0;
        for(String str : strs){
            String sorted = sortString(str);
            if(!map.containsKey(sorted)){
                List<String> li = new ArrayList<>();
                li.add(str);
                result.add(li);
                map.put(sorted, count++);
            }
            else{
                List<String> li = result.get(map.get(sorted));
                li.add(str);
            }
        }
        
        return result;
    }
    
    private String sortString(String str){
        char[] tempCharArray = str.toCharArray();
        Arrays.sort(tempCharArray);
        return new String(tempCharArray);
    }
}