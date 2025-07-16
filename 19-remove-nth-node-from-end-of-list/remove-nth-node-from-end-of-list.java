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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n == 0) return head;

        int len = 0;
        ListNode frontNode = head;
        while(frontNode != null){
            frontNode = frontNode.next;
            len++;
        }

        len = len-n;
        if(len == 0) return head.next;
        frontNode = head;
        System.out.println(len);
        int i = 1;
        while(len>1){
            frontNode = frontNode.next;
            len--;
        }

        frontNode.next = frontNode.next.next;

        return head;
        
    }
}