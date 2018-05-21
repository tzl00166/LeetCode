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
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null)
            return new ArrayList(){};
        
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> set = new LinkedList<>();
        set.add(root);
        
        while(!set.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int n = set.size();
            for(int i = 0; i < n; i++){
                Node N = set.poll();
                level.add(N.val);
                for(Node child : N.children)
                    set.add(child);
            }
            
            result.add(level);
        }
        
        return result;
    }
}