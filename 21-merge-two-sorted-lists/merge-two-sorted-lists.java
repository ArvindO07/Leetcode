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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return list1;

        if(list1 == null ) return list2;
        if(list2 == null) return list1;

        ListNode fh = list1;
        ListNode ft = list1;
        ListNode h1 = list1;
        ListNode h2 = list2;

        if(h1.val <= h2.val){
            fh = h1;
            ft = h1;
            h1 = h1.next;
        }else{
            fh = h2;
            ft = h2;
            h2 = h2.next;
        }

        while(h1 != null && h2 != null ){
            if(h1.val < h2.val){
                ft.next = h1;
                ft = h1;
                h1 = h1.next;
            }else{
                ft.next = h2;
                ft = h2;
                h2 = h2.next;
            }
        }

        if(h1 != null){
            ft.next = h1;
            ft = h1;
            h1 = h1.next;
        }

        if(h2 != null){
            ft.next = h2;
            ft = h2;
            h2 = h2.next;
        }

        return fh;


    }
}