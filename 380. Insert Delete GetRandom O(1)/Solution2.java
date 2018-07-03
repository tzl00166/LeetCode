class RandomizedSet {
    
    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> a;
    private Random rnd;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        a = new ArrayList<>();
        rnd = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        
        if (map.containsKey(val))
            return false;
    
        map.put(val, a.size());
        a.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int loc = map.get(val);
            int lastElem = a.get(a.size()-1);
            swap(a, loc, a.size()-1);
            map.put(lastElem, loc);
            a.remove(a.size()-1);
            map.remove(val);
            return true;
        }
        return false;
    }
    
    private void swap(ArrayList<Integer> a, int i, int j) {
        int temp1 = a.get(i);
        int temp2 = a.get(j);
        a.set(i, temp2);
        a.set(j, temp1);
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int idx = rnd.nextInt(a.size());
        return a.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */