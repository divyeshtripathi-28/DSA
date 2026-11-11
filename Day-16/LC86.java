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
    public ListNode partition(ListNode head, int x) {
        if(head == null) {
            return null;
        }
        ListNode curr = null;
        ListNode newHead = null; 

        ListNode temp = head;

        while(temp != null) {
            if(temp.val < x) {
                ListNode newNode = new ListNode(temp.val, null);

                if(curr != null) {
                    curr.next = newNode;
                    curr = curr.next;
                } else {
                    curr = newNode;
                    newHead = curr;
                }
            }
            temp = temp.next;
        }

        temp = head;

        while(temp != null) {
            if(temp.val >= x) {
                ListNode newNode = new ListNode(temp.val, null);

                if(curr != null) {
                    curr.next = newNode;
                    curr = curr.next;
                } else {
                    curr = newNode;
                    newHead = curr;
                }
            }
            temp = temp.next;
        }

        return newHead;

    }
}