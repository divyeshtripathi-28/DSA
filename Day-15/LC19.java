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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) {
            return null;
        }
        ListNode temp = head;
        
        int size = 0;

        while(temp != null) {
            size++;
            temp = temp.next;
        }

        int curr = size - n;

        if(curr == 0) {
            return head.next;
        }

        int prev = curr - 1;
        ListNode prevNode = head;
        ListNode currNode = head;

        int i = 0;

        while(i != prev) {
            prevNode = prevNode.next;
            i++;
        }

        i=0;

        while(i != curr) {
            currNode = currNode.next;
            i++;
        }

        prevNode.next = currNode.next;

        return head;
    }
}