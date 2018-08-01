/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return null;
        
        ListNode odd = head;
        ListNode even = head.next;
        
        while(even != null && even.next != null){
            ListNode temp = even.next;
            even.next = temp.next;
            temp.next = odd.next;
            odd.next = temp;
            odd = odd.next;
            even = even.next;
        }
        
        return head;
    }
}