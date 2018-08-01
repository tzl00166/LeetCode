/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head){
        if(head == null)
            return true;
        List<Integer> temp = new ArrayList<>();
        while(head != null){
            temp.add(head.val);
            head = head.next;
        }
        
        int left = 0;
        int right = temp.size() - 1;
        while(left < right){
            if(!temp.get(left).equals(temp.get(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }
}