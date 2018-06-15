class MyHashMap {
    
    private TreeNode[] buckets;
    private final static int num = 10000;

    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = new TreeNode[num];
    }
    
    /** value will always be positive. */
    public void put(int key, int value) {
        int index = key % num;
        buckets[index] = addToBucket(buckets[index], key, value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % num;
        return getInBucket(buckets[index], key);
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key % num;
        buckets[index] = removeFromBucket(buckets[index], key);
    }
    
    private TreeNode addToBucket(TreeNode node, int key, int value){
        if(node == null){
            node = new TreeNode(key);
            node.val = value;
        }
        else{
            if(node.key == key)
                node.val = value;
            else if(node.key < key)
                node.right = addToBucket(node.right, key, value);
            else
                node.left = addToBucket(node.left, key, value); 
            }       
        return node;
    }
    
    private TreeNode removeFromBucket(TreeNode node, int key){
        if(node == null)
            return node;
        
        if(node.key == key){
            if(node.left == null)
                return node.right;
            if(node.right == null)
                return node.left;
            int successor = findSuccessor(node);
            node.key = successor;
            node.right = removeFromBucket(node.right, successor);
        }
        else if(node.key < key)
            node.right = removeFromBucket(node.right, key);
        else
            node.left = removeFromBucket(node.left, key);
        
        return node;
    }
    
    private int findSuccessor(TreeNode node){
        TreeNode current = node.right;
        while(current != null && current.left != null)
            current = current.left;
        
        return current.key;
    }
    
    private int getInBucket(TreeNode node, int key){
        TreeNode current = node;
        while(current != null){
            if(current.key == key)
                return current.val;
            else if(current.key < key)
                current = current.right;
            else 
                current = current.left;
        }
        
        return -1;
    }
}

class TreeNode{
    int key;
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int key){
        this.key = key;
        left = null;
        right = null;
        val = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */