/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;

        int carry = 0;

        while(l1 != null || l2 != null){
            int x  = 0;

            if(l1 == null){
                x = l2.val + carry;
            }else if(l2 == null){
                x = l1.val + carry;
            }else{
                x = l1.val + l2.val + carry;
            }
            
            ListNode temp = new ListNode(x%10);
            carry = x/10;

            if(head == null){
                head = temp;
                tail = temp;
            }else{
                tail.next = temp;
                tail = temp;
            }

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry > 0) {
            ListNode temp = new ListNode(carry);
            tail.next = temp;
        }

        return head;

    }
}