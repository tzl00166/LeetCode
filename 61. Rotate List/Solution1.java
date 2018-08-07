/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null)
            return head;
        
        ListNode temp = head;
        int length = 1;
        while(temp.next != null){
            temp = temp.next;
            length++;
        }
        k %= length;
        if(k == 0)
            return head;
        
        ListNode parent = head;
        for(int i = 1; i < length - k; i++)
            parent = parent.next;
        
        ListNode newhead = parent.next;
        parent.next = null;
        temp.next = head;
        return newhead;
    }
}