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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // if(head.next == null) {
        //     return head;
        // }
        ListNode temp = head;
        ListNode prev = null;

        int i = 1;

        while(i < left) {
            prev = temp;
            temp = temp.next;
            i++;
        }

        ListNode temp2 = head;
        ListNode next = temp2.next;
        int j = 1;

        while(j < right) {
            temp2 = next;
            next = next.next;
            j++;
        }

        ListNode curr = temp;
        ListNode nextCurr;
        i = 1;

        while(i <= right - left + 1) {
            nextCurr = curr.next;
            curr.next = next;
            next = curr;
            curr = nextCurr;
            i++;
        }
        if(prev != null) {
            prev.next = next;
        } else {
            head = temp2;
        }

        return head;

    }
}