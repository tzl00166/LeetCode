class MapSum {

    private TrieNode root;
    private Set<String> keys;
    
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode(0);
        keys = new HashSet<>();
    }
    
    public void insert(String key, int val) {
        TrieNode current = root;
        if(keys.contains(key)){
            for(int i = 0; i < key.length(); i++){
                char c = key.charAt(i);
                current = current.map.get(c);
                current.value = val;
            }
        }
        else{
            keys.add(key);
            for(int i = 0; i < key.length(); i++){  
                char c = key.charAt(i);
                if(current.map.get(c) == null){
                    current.map.put(c, new TrieNode(val));
                    current = current.map.get(c);
                }
                else{
                    current = current.map.get(c);
                    current.value += val;
                }
            }
        }
        
    }
    
    public int sum(String prefix) {
        TrieNode current = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(current.map.get(c) == null)
                return 0;
            current = current.map.get(c);
        }
        
        return current.value;
    }
}

class TrieNode{
    Map<Character, TrieNode> map;
    int value;
    
    public TrieNode(int value){
        map = new HashMap<>();
        this.value = value;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */