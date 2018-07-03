class ValidWordAbbr {
    
    private Map<String, List<String>> map;

    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for(String word : dictionary){
            String abbr = word;
            if(word.length() > 2)
                abbr = getAbbreviation(word);
            if(!map.containsKey(abbr))
                map.put(abbr, new ArrayList<String>());
            if(!map.get(abbr).contains(word))
                map.get(abbr).add(word);
        }
    }
    
    public boolean isUnique(String word) {
        String abbr = word;
        if(word.length() > 2)
                abbr = getAbbreviation(word);
        if(map.get(abbr) == null || (map.get(abbr).size() == 1 && map.get(abbr).contains(word)))
            return true;
        else
            return false;
    }
    
    private String getAbbreviation(String word){
        return word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */