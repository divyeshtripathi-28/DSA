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
    public ListNode merge2Lists(ListNode[] lists, int low, int high) {
        if(low == high) {
            return lists[low];
        }

        int mid = low + (high - low) / 2;


        ListNode list1 = merge2Lists(lists, low, mid);
        ListNode list2 = merge2Lists(lists, mid + 1, high);

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode result = new ListNode(Math.min(list1.val, list2.val));

        ListNode temp = result;

        if(list1.val < list2.val) {
            list1 = list1.next;
        } else {
            list2 = list2.next;
        }

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }

            temp = temp.next;
        }

        while(list1 != null) {
            temp.next = list1;
            list1 = list1.next;

            temp = temp.next;
        }

        while(list2 != null) {
            temp.next = list2;
            list2 = list2.next;

            temp = temp.next;
        }

        return result;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }

        return merge2Lists(lists, 0, lists.length - 1);
    }
}