/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    Map<Integer, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        
        if(map.containsKey(node.val))
            return map.get(node.val);
        
        Node clonedNode = new Node(node.val, new ArrayList<Node>());
        map.put(clonedNode.val, clonedNode);

        for(Node neighbor : node.neighbors)
            clonedNode.neighbors.add(cloneGraph(neighbor));

        return clonedNode;
    }
}