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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp1 = list1;

        ListNode temp2 = list1;
        int i = 1;

        while(i < a) {
            temp1 = temp1.next;
            i++;
        }

        i = 0;

        while(i < b) {
            temp2 = temp2.next;
            i++;
        }

        temp1.next = list2;

        ListNode temp3 = list2;

        while(temp3.next != null) {
            temp3 = temp3.next;
        }

        temp3.next = temp2.next;
        temp2.next = null;

        return list1;
    }
}