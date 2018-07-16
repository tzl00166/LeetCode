class Solution {
    private TrieNode root;
    private boolean nullString = false;
    public String longestCommonPrefix(String[] strs) {
        root = new TrieNode();
        for(String str : strs)
            buildTrie(str);
        
        if(nullString)
            return "";
        
        StringBuilder sb = new StringBuilder();
        TrieNode current = root;
        while(current != null){
            if(current.children.size() != 1 || current.isWord == true)
                break;
            List<Character> temp = new ArrayList(current.children.keySet());
            sb.append(temp.get(0));
            current = current.children.get(temp.get(0));
        }
        
        return sb.toString();
    }
    
    private void buildTrie(String str){
        if(str == null || str.length() == 0)
            nullString = true;
        TrieNode current = root;
        for(char c : str.toCharArray()){
            if(!current.children.containsKey(c))
                current.children.put(c, new TrieNode());
            current = current.children.get(c);
        }
        current.isWord = true;
    }
}

class TrieNode{
    Map<Character, TrieNode> children;
    boolean isWord;
    public TrieNode(){
        children = new HashMap<>();
        isWord = false;
    }
}