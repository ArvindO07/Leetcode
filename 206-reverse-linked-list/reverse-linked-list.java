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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode startNode = head;
        ListNode backNode = null;

        while(startNode != null){
            ListNode temp = startNode;
            startNode = startNode.next;
            temp.next = backNode;
            backNode = temp;
        }

        return backNode;
    }
}