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
    public int getDecimalValue(ListNode head) {
        int n=0;
        ListNode cur = head;
        while(cur != null)
        {
            n++;
            cur = cur.next;
        }

        int ans=0;
        ListNode cur2 = head;
        while(cur2 != null)
        {
            ans+=cur2.val * Math.pow(2,n-1);
            n--;
            cur2 = cur2.next;
        }

        return ans;
        
    }
}