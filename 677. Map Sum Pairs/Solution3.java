class MapSum {
    
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode node = root;
        for(char c : key.toCharArray()){
            if(node.children.get(c) == null){
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.val = val;
    }
    
    public int sum(String prefix) {
        TrieNode node = root;
        for(char c : prefix.toCharArray()){
            if(node.children.get(c) == null){
                return 0;
            }
            node = node.children.get(c);
        }
        return dfs(node);
    }
    
    private int dfs(TrieNode node){
        if(node == null)
            return 0;
        int total = node.val;
        for(Character c : node.children.keySet()){
            total += dfs(node.children.get(c));
        }
        return total;
    }
}

class TrieNode{
        int val;
        Map<Character, TrieNode> children;
    
        public TrieNode(){
            children = new HashMap<>();
            val = 0;
        }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */