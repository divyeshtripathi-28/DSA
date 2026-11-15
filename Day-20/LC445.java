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
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode temp1 = l1.next;
        ListNode temp2 = l2.next;

        int val = l1.val + l2.val;

        ListNode newHead = new ListNode(val % 10);
        ListNode temp3 = newHead;
        val = val / 10;

        while(temp1 != null && temp2 != null) {
            int curr = temp1.val + temp2.val + val;
            temp3.next = new ListNode(curr % 10);
            val = curr / 10;

            temp1 = temp1.next;
            temp2 = temp2.next;
            temp3 = temp3.next;
        }

        while(temp1 != null) {
            int curr = temp1.val + val;
            temp3.next = new ListNode(curr % 10);
            val = curr / 10;
            temp1 = temp1.next;
            temp3 = temp3.next;
        }

        while(temp2 != null) {
            int curr = temp2.val + val;
            temp3.next = new ListNode(curr % 10);
            val = curr / 10;
            temp2 = temp2.next;
            temp3 = temp3.next;
        }

        if(val > 0) {
            temp3.next = new ListNode(val);
        }

        newHead = reverse(newHead);

        return newHead;
    }
}