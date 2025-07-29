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
    ListNode currNode ;
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        
        currNode = head;
        return check(head);
    }

    public boolean check(ListNode head){

        if(head == null) return true;

        boolean ans = check(head.next);

        boolean isEqual;
        if(head.val == currNode.val){
            isEqual = true;
        }else {
            isEqual = false;
        }
        currNode = currNode.next;
        return isEqual && ans;

    }
}