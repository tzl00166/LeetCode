class WordDictionary {

    HashMap<Integer, HashSet<String>> map;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        map = new HashMap<>();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(!map.containsKey(word.length())) map.put(word.length(), new HashSet<>());
        map.get(word.length()).add(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(!map.containsKey(word.length())) return false;
        if(word.indexOf('.') != -1){
            for(String str : map.get(word.length())){
                if(equal(str, word)) return true;
            }
            return false;
        }
        else{
            return map.get(word.length()).contains(word);
        }
    }
    
    boolean equal(String a, String b){
        for(int i = 0; i < b.length(); i++){
            if(b.charAt(i) == '.') continue;
            if(b.charAt(i) != a.charAt(i)) return false;
        }
        return true;
    }
}