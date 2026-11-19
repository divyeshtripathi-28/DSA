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
    public int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next == null) {
            return head;
        }

        ListNode temp1 = head;

        while(temp1.next != null) {
            ListNode temp2 = temp1.next;

            ListNode insert = new ListNode(gcd(Math.max(temp1.val, temp2.val),Math.min(temp1.val, temp2.val)));

            temp1.next = insert;
            insert.next = temp2;
            temp1 = temp2;
        }

        return head;
    }
}