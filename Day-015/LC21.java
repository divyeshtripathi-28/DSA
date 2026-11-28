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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l3 = new ListNode();

        if(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                l3 = list1;
                list1 = list1.next;
            } else {
                l3 = list2;
                list2 = list2.next;
            }
        } else if(list1 == null && list2 != null) {
            l3 = list2;
            list2 = list2.next;
        } else if(list2 == null && list1 != null) {
            l3 = list1;
            list1 = list1.next;
        } else {
            return l3.next;
        }
        

        ListNode temp = l3;

        while(list1 != null || list2 != null) {
            if(list1 != null && list2 != null) {
                if(list1.val <= list2.val) {
                    temp.next = list1;
                    list1 = list1.next;
                } else {
                    temp.next = list2;
                    list2 = list2.next;
                }
            } else if(list1 == null) {
                temp.next = list2;
                list2 = list2.next;

            } else if(list2 == null) {
                temp.next = list1;
                list1 = list1.next;
            }

            temp = temp.next;
        }

        return l3;
    }
}