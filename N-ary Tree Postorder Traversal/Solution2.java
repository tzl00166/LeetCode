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

// Iterative Solution
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        Deque<Node> set = new LinkedList<>();
        set.push(root);
        while(!set.isEmpty()){
            Node node = set.poll();
            if(node != null){
                if(node.children == null)
                    result.add(node.val);
                else{
                    Node header = new Node(node.val);
                    set.push(header);
                    int i = node.children.size();
                    while(i > 0)
                        set.push(node.children.get(--i));
                }
            }
        }
        
        return result;
    }
}