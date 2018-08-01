/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null)
            slow = slow.next;
        slow = reverse(slow);
        
        while(slow != null){
            if(head.val != slow.val)
                return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode head){
        ListNode newhead = head;
        while(head.next != null){
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = newhead;
            newhead = temp;
        }
        return newhead;
    }
}