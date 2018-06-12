class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode();
        for(String s : dict)
            buildRootDictionary(root, s);
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            findRoot(root, word, sb);
            sb.append(' ');
        }
        
        String temp = sb.toString();
        return temp.substring(0, temp.length() - 1);
    }
    
    private void buildRootDictionary(TrieNode root, String s){
        TrieNode current = root;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(current.children[c - 'a'] == null)
                current.children[c - 'a'] = new TrieNode();
            current = current.children[c - 'a'];
        }
		// mark the end of the root
        current.flag = true;
    }
    
    private void findRoot(TrieNode root, String word, StringBuilder sb){
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
			// if there is no match, append the whole word
            if(current.children[c - 'a'] == null){
                sb.append(word.substring(i, word.length()));
                break;
            }
            current = current.children[c - 'a'];
            sb.append(c);
			// if reaches the shortest root, stop
            if(current.flag)
                break;
        }
    }
}

class TrieNode{
    public static final int num = 26;
    public TrieNode[] children;
    public boolean flag;
    
    public TrieNode(){
        children = new TrieNode[num];
        flag = false;
    }
}