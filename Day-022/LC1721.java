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
    public ListNode swapNodes(ListNode head, int k) {
        int i = 1;
        int size = 0;
        ListNode temp1 = head;
        ListNode temp2 = head;

        while(temp1 != null) {
            size++;
            temp1 = temp1.next;
        }

        temp1 = head;

        while(i < k) {
            temp1 = temp1.next;
            i++;
        }

        i = 1;

        while(i < size - k + 1) {
            temp2 = temp2.next;
            i++;
        }

        int val = temp1.val;
        temp1.val = temp2.val;
        temp2.val = val;

        return head;
    }
}