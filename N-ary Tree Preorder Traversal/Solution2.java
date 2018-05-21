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

// Recursive Solution.
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }
    
    private void preorderHelper(Node node, List<Integer> result){
        if(node == null)
            return;
        
        result.add(node.val);
        for(Node child : node.children)
            preorderHelper(child, result);
    }
}