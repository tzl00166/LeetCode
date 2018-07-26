/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        
        ListNode endA = null;
        ListNode endB = null;
        ListNode traA = headA;
        ListNode traB = headB;
        
        while(traA != traB){
            if(traA.next == null){
                endA = traA;
                traA = headB;
            }
            else
                traA = traA.next;        
            if(traB.next == null){
                endB = traB;
                traB = headA;
            }
            else
                traB = traB.next;
            
            if((endA != null && endB != null) && endA != endB)
                return null;
        }
           
        return traA;
    }
}