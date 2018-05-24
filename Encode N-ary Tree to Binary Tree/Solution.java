/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    // Encodes an n-ary tree to a binary tree.
    public static TreeNode encode(Node root) {
        return encodeHelper(root, null);
    }
    
    private static TreeNode encodeHelper(Node root, List<Node> siblings){
        if(root == null)
            return null;
        
        TreeNode node = new TreeNode(root.val);
        if(siblings != null && !siblings.isEmpty()){
            Node root_left = siblings.get(0);
            siblings.remove(0);
            node.left = encodeHelper(root_left, siblings);
        }
        if(root.children != null && !root.children.isEmpty()){
            Node root_right = root.children.get(0);
            root.children.remove(0);
            node.right = encodeHelper(root_right, root.children);
        }
        
        return node;
    }

    // Decodes your binary tree to an n-ary tree.
    public static Node decode(TreeNode root) {
        if(root == null)
            return null;
        
        Node node = new Node(root.val, new ArrayList<Node>());
        
        if(decode(root.right) != null) {
        	node.children.add(decode(root.right));
        	if(decode(root.right.left) != null)
                node.children.add(decode(root.right.left));
        }
    
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));