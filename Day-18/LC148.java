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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(newHead);

        ListNode newList = null;

        if(left.val >= right.val) {
            newList = right;
            right = right.next;
        } else {
            newList = left;
            left = left.next;
        }

        ListNode temp = newList;

        while(left != null && right != null) {
            if(left.val >= right.val) {
                temp.next = right;
                right = right.next;
            } else {
                temp.next = left;
                left = left.next;
            }

            temp = temp.next;
        }

        while(left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }

        while(right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }

        return newList;
    }
}