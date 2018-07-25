/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        do{
            if(fast == null || fast.next == null)
                return false;
            fast = fast.next.next;
            slow = slow.next;          
        }
        while(slow != fast);
        
        return true;
    }
}