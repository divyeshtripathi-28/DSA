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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int rem = 0;
        ListNode l3 = new ListNode();


        if((l1.val + l2.val) < 10) {
            l3 = new ListNode(l1.val + l2.val);
        } else {
            rem = (l1.val + l2.val) /10;
            l3 = new ListNode((l1.val + l2.val) % 10);
        }

        l1 = l1.next;
        l2 = l2.next;
        ListNode temp = l3;
        
        while(l1 != null || l2 != null) {
            if(l1 != null && l2 != null) {

                if((l1.val + l2.val + rem) < 10) {
                    temp.next = new ListNode(l1.val + l2.val + rem);
                    rem = 0;
                } else {
                    temp.next = new ListNode((l1.val + l2.val + rem) % 10);
                    rem = (l1.val + l2.val + rem) /10;
                }

            } else if(l1 == null) {
                if((l2.val + rem) < 10) {
                    temp.next = new ListNode(l2.val + rem);
                    rem = 0;
                } else {
                    temp.next = new ListNode((l2.val + rem) % 10);
                    rem = (l2.val + rem) /10;
                }
            } else if(l2 == null) {
                if((l1.val + rem) < 10) {
                    temp.next = new ListNode(l1.val + rem);
                    rem = 0;
                } else {
                    temp.next = new ListNode((l1.val + rem) % 10);
                    rem = (l1.val + rem) /10;
                }
            }

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

            if (temp != null) temp = temp.next;
        }

        while(rem != 0) {
            if(rem < 10) {
                temp.next = new ListNode(rem);
            } else {
                temp.next = new ListNode(rem % 10);
                temp = temp.next;
            }
            rem = rem / 10;
        }

        return l3;
    }
}