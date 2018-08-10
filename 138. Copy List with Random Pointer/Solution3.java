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
        if(head == null)
            return null;
        
        RandomListNode node = new RandomListNode(head.label);
        node.next = copyRandomList(head.next);
        if(head.random != null)
            node.random = new RandomListNode(head.random.label);
        return node;
    }
}