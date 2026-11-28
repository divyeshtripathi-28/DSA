/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode intersect = null;
        int sizeA = 0;
        int sizeB = 0;
        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while(temp1 != null) {
            sizeA++;
            temp1 = temp1.next;
        }

        while(temp2 != null) {
            sizeB++;
            temp2 = temp2.next;
        }

        temp1 = headA;
        temp2 = headB;

        if(sizeA > sizeB) {
            for(int i = 0; i < sizeA - sizeB; i++) {
                temp1 = temp1.next;
            }
        } else if(sizeA < sizeB) {
            for(int i = 0; i < sizeB - sizeA; i++) {
                temp2 = temp2.next;
            }
        }

        while(temp1 != null) {
            if(temp1 == temp2) {
                return temp1;
            }

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return null;
    }
}