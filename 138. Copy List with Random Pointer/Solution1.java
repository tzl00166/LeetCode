/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;
        while(head != null){
            cur.next = clone(head);
            head = head.next;
            cur = cur.next;
        }
        return dummy.next;
    }
    
    private RandomListNode clone(RandomListNode node){
        RandomListNode newNode = new RandomListNode(node.label);
        if(node.random != null) newNode.random = new RandomListNode(node.random.label);
        return newNode;
    }
}