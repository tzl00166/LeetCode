/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
 // if the original linked list is empty
        if(head == null)
            return new Node(insertVal, null);
        
        // if the original linked list contains only one node
        if(head.next == null){
            head.next = new Node(insertVal, null);
            head.next.next = head;
            return head;
        }
        
        // if the original linked list contains more than one node
        Node prev = head;
        Node curNode = head.next;
        
        
        // case 1: 1 -> 3 -> 5, insertVal = 2 (normal case)
        // case 2: 1 -> 3 -> 5, insertVal = 0 (edge case)
        // case 3: 1 -> 3 -> 5, insertVal = 6 (edge case)
        // case 4: 3 -> 3 -> 3, insertVal = 3 (edge case)
        // curNode.val >= insertVal && prev.val <= insertVal: deal with
        while(!(   curNode.val >= insertVal && prev.val <= insertVal   //case 1
                || curNode.val <= prev.val && insertVal <= curNode.val // case 2
                || curNode.val <= prev.val && insertVal >= prev.val)    //case 3
             ){
            prev = curNode;
            curNode = curNode.next;
            if(curNode == head) // case 4: if we already went throug the whole linked list
                break;          //  and we haven't find the place that means all of the nodes have the same value
        }
        prev.next = new Node(insertVal, curNode);
        return head;
    }
}