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
        if(head == null){
            head = new Node(insertVal, null);
            head.next = head;
        }
        else if(head.next == head || head.val == insertVal){
            // when there is only one node, or head's value equals to insertVal
            Node temp = new Node(insertVal, null);
            temp.next = head.next;
            head.next = temp;
        }
        else{
            // when there are 2 or more nodes
            Node temp = head;
            // store the node with largest value
            Node largest = temp;
            do{
                if(temp.val > largest.val)
                    largest = temp;
                // when insertVal can be found between smaller and bigger
                if(temp.val <= insertVal && temp.next.val >= insertVal){
                   Node insert = new Node(insertVal, null);
                   insert.next = temp.next;
                   temp.next = insert;
                   return head;
                }
                temp = temp.next;
            }
            while(temp != head);
            
            // when every number is bigger or smaller than insertVal
            // 1) every number is smaller, insertVal should be after the existing largest
            // 2) every number is bigger, insertVal should be after the existing largets too.
            Node insert = new Node(insertVal, null);
            insert.next = largest.next;
            largest.next = insert;
        }
        return head;
    }
}