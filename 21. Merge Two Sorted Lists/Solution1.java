/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        
        ListNode head = l1.val < l2.val ? l1 : l2;
        if(head == l1)
            l1 = l1.next;
        else
            l2 = l2.next;
        ListNode current = head;
        while(l1 != null && l2 != null){
            
            if(l1.val < l2.val){
                current.next = l1;
                current = l1;
                l1 = l1.next;
            }
            else{
                current.next = l2;
                current = l2;
                l2 = l2.next;
            }
            
        }
        
        if(l1 == null){
            current.next = l2;
        }
        if(l2 == null){
            current.next = l1;
        }
        
        return head;
    }
}