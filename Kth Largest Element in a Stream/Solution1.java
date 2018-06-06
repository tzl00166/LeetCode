
class KthLargest {
    // insert a node into the BST
	// build the BST, create or update according to the inserting
    private Node insertNode(Node root, int num) {
        if (root == null) {
            return new Node(num, 1);
        }
        if (root.val < num) {
            root.right = insertNode(root.right, num);
        } else {
            root.left = insertNode(root.left, num);
        }
        root.cnt++;
        return root;
    }

    private int searchKth(Node root, int k) {
        // m = the size of right subtree
        int m = root.right != null ? root.right.cnt : 0;
        // root is the m+1 largest node in the BST
		// if right child has k - 1 nodes, then this root is the kth largest
        if (k == m + 1) {
            return root.val;
        }
		// if right child has >=k nodes, search in the right child for kth largest
        if (k <= m) {
            // find kth largest in the right subtree
            return searchKth(root.right, k);
        } 
		// if right child has < k - 1, seach in the left child for (k - (cnt + 1))th largest
		else {
            // find (k-m-1)th largest in the left subtree
            return searchKth(root.left, k - m - 1);
        }
    } 
    
    private Node root;
    private int m_k;

    public KthLargest(int k, int[] nums) {
        root = null;
        for (int i = 0; i < nums.length; ++i) {
            root = insertNode(root, nums[i]);
        }
        m_k = k;
    }
    
    public int add(int val) {
        root = insertNode(root, val);
        return searchKth(root, m_k);
    }
}

// build the TreeNode class and store the count 
class Node {    // the structure for the tree node
    Node left;
    Node right;
    int val;
    int cnt;    // the size of the subtree rooted at the node
    public Node (int v, int c) {
        left = null;
        right = null;
        val = v;
        cnt = c;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */