class WordDictionary {
    
    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode current = root;
        for(char c : word.toCharArray()){
            if(current.children[c - 'a'] == null)
                current.children[c - 'a'] = new TrieNode();
            current = current.children[c - 'a'];
        }
        current.flag = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchWord(word, root);
    }
    
    private boolean searchWord(String word, TrieNode node){
        if(node == null)
            return false;
        
        TrieNode current = node;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(c == '.'){
                boolean result = false;
                for(TrieNode child : current.children)
                    result = result || searchWord(word.substring(i + 1, word.length()), child);
                return result;
            }
            
            if(current.children[c - 'a'] == null)
                return false;
            else
                current = current.children[c - 'a'];
        }
        
        return current.flag;
    }
}

class TrieNode{
    private final static int num = 26;
    TrieNode[] children;
    boolean flag;
    public TrieNode(){
        children = new TrieNode[num];
        flag = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */