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
    public ListNode deleteAtPos(ListNode head, int pos) {
        if(pos == 0) {
            return null;
        }

        int i = 0;
        ListNode temp = head;

        while(i < pos - 1) {
            temp = temp.next;
            i++;
        }

        temp.next = temp.next.next;

        return head;
    }
    public ListNode deleteMiddle(ListNode head) {
        int size = 0;
        ListNode temp = head;

        while(temp != null) {
            size++;
            temp = temp.next;
        }

        head = deleteAtPos(head, size/2);

        return head;
    }
}