class MyHashSet {
    
    private TreeNode[] buckets;
    private final static int num = 10000;

    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = new TreeNode[num];
    }
    
    public void add(int key) {
        int index = key % num;
        buckets[index] = addToBucket(buckets[index], key);
    }
    
    public void remove(int key) {
        int index = key % num;
        buckets[index] = removeFromBucket(buckets[index], key);
    }
    
    /** Returns true if this set did not already contain the specified element */
    public boolean contains(int key) {
        int index = key % num;
        return containsInBucket(buckets[index], key);
    }
    
    private TreeNode addToBucket(TreeNode node, int key){
        if(node == null)
            return new TreeNode(key);
        
        if(node.val == key)
            return node;
        else if(node.val < key)
            node.right = addToBucket(node.right, key);
        else
            node.left = addToBucket(node.left, key);
        
        return node;
    }
    
    private TreeNode removeFromBucket(TreeNode node, int key){
        if(node == null)
            return node;
        
        if(node.val == key){
            if(node.left == null)
                return node.right;
            if(node.right == null)
                return node.left;
            int successor = findSuccessor(node);
            node.val = successor;
            node.right = removeFromBucket(node.right, successor);
        }
        else if(node.val < key)
            node.right = removeFromBucket(node.right, key);
        else
            node.left = removeFromBucket(node.left, key);
        
        return node;
    }
    
    private int findSuccessor(TreeNode node){
        TreeNode current = node.right;
        while(current != null && current.left != null)
            current = current.left;
        
        return current.val;
    }
    
    private boolean containsInBucket(TreeNode node, int key){
        TreeNode current = node;
        while(current != null){
            if(current.val == key)
                return true;
            else if(current.val < key)
                current = current.right;
            else 
                current = current.left;
        }
        
        return false;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */