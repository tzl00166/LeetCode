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
class Solution {
    public int maxDepth(Node root) {
        int result = 0;
        return maxDepthHelper(root, result);
    }
    
    private int maxDepthHelper(Node node, int result){
        if(node == null)
            return result;
        
        if(node.children.size() == 0)
            return result + 1;
        else if(node.children.size() == 1)
            return maxDepthHelper(node.children.get(0), result + 1);
        else if(node.children.size() == 2)
            return Math.max(maxDepthHelper(node.children.get(0), result + 1), maxDepthHelper(node.children.get(1), result + 1));
        else
            return Math.max(Math.max(maxDepthHelper(node.children.get(0), result + 1), maxDepthHelper(node.children.get(1), result + 1)), 
                            maxDepthHelper(node.children.get(2), result + 1));
            
    }
}