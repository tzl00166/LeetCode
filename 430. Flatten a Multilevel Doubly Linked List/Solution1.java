/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if(head == null)
            return null;
        
        Node child = flatten(head.child);
        Node next = flatten(head.next);
        if(child != null){
            head.next = child;
            child.prev = head;
            head.child = null;
            if(next != null){
                Node temp = head;
                while(temp.next != null)
                    temp = temp.next;
                temp.next = next;
                next.prev = temp;
            }
        }
        else if (next != null){
            head.next = next;
            next.prev = head;
        }
        
        return head;
    }
}