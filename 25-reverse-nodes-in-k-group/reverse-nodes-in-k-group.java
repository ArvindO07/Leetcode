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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) return head;

        ListNode temp = head;
        ListNode curr = head;
        ListNode prev = null;
        ListNode currN = curr.next;

        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }

        if(count < k) return head;
        int c  = 0;
        while(c < k && currN != null){
            currN = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currN;
            c++;
        }

           if(currN != null){
            head.next = reverseKGroup(currN, k);
        }

        return  prev;
    }
}