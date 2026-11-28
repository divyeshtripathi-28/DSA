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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode tail = head;
        int size = 0;

        if(head == null) {
            return head;
        }

        while(tail.next != null) {
            size++;
            tail = tail.next;
        }
        size++;

        int n = 0;
        if(k > size) {
            k = k % size;
        }
        ListNode next;

        while(n < size - k) {
            tail.next = head;
            next = head.next;
            head.next = null;
            tail = tail.next;
            head = next;
            n++;
        }

        return head;
    }
}