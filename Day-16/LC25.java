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
    public ListNode reverse(ListNode head, ListNode last) {
        ListNode after = last.next;
        ListNode prev = after;
        ListNode temp = head;

        while(temp != after) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode temp = head;
        ListNode newHead = null;
        ListNode temp2 = newHead;
        int n = k;

        while(true) {
            ListNode curr = temp;
            while(n > 1 && temp != null) {
                temp = temp.next;
                n--;
            }
            n = k;
            ListNode last = temp;
            if(last == null) {
                if(temp2 != null) {
                    temp2.next = curr;
                }
                break;
            }
            ListNode nextIter = last.next;
            ListNode reversedHead = reverse(curr, last);
            if(newHead == null) {
                newHead = reversedHead;
            } else {
                temp2.next = reversedHead;
            }

            temp2 = curr;
            temp = nextIter;
        }

        return newHead;
    }
}