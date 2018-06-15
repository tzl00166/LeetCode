class MyHashSet {
    private final int MAX_LEN = 100000; // the amount of buckets
    private List<Integer>[] set;      // hash set implemented by list
    
    /** Returns the corresponding bucket index. */
    private int getIndex(int key) {
        return key % MAX_LEN;
    }
    
    /** Search the key in a specific bucket. Returns -1 if the key does not existed. */
    private int find(int index, int key) {
        // Each bucket contains a list.
        List<Integer> temp = set[index];
        if (temp == null) {
            return -1;
        }
        // Iterate all the elements in the bucket to find the target key.
        for (int i = 0; i < temp.size(); ++i) {
            if (temp.get(i) == key) {
                return i;
            }
        }
        return -1;
    }
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        set = (List<Integer>[])new ArrayList[MAX_LEN];
    }
    
    public boolean add(int key) {
        int index = getIndex(key);
        int i = find(index, key);
        if (i < 0) {
            if (set[index] == null) {
                set[index] = new ArrayList<Integer>();
            }
            set[index].add(key);
            return true;
        } else {
            return false;
        }
    }
    
    /** Returns true if this set did not already contain the specified element */
    public boolean contains(int key) {
        int index = getIndex(key);
        return find(index, key) >= 0;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * boolean param_1 = obj.add(key);
 * boolean param_2 = obj.contains(key);
 */