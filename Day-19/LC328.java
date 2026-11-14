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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode temp = head;
        int size = 0;

        while(temp.next != null) {
            size++;
            temp = temp.next;
        }

        size++;

        ListNode tail = temp;
        ListNode odd = head;
        ListNode even = head.next;

        int i = 0;

        while(i < size/2) {
            odd.next = even.next;
            tail.next = even;
            odd = even.next;
            tail = even;
            tail.next = null;
            even = odd.next;
            i++;
        }

        return head;
    }
}