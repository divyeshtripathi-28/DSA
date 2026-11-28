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
    public int listSize(ListNode head) {
        ListNode temp = head;
        int size = 0;

        while(temp != null) {
            size++;
            temp = temp.next;
        }

        return size;
    }
    public void kIsGreater(ListNode head, int k, List<ListNode> list) {
        ListNode temp = head;

        while(temp != null) {
            list.add(new ListNode(temp.val));
            temp = temp.next;
            k--;
        }

        while(k > 0) {
            list.add(null);
            k--;
        }
    }

    public void kIsSmaller(ListNode head, List<ListNode> list, int more, int singleContain) {
        ListNode temp = head;

        while(more > 0) {
            list.add(temp);
            for(int i = 0; i < singleContain; i++) {
                temp = temp.next;
            }
            ListNode next = temp.next;

            temp.next = null;
            temp = next;
            more--;
        }

        while(temp != null) {
            list.add(temp);
            for(int i = 0; i < singleContain - 1; i++) {
                temp = temp.next;
            }
            ListNode next = temp.next;

            temp.next = null;
            temp = next;
        }
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = listSize(head);
        List<ListNode> list = new ArrayList<>();

        if(k >= size) {
            kIsGreater(head, k, list);
            return list.toArray(new ListNode[0]);
        }

        int more = size % k;
        int singleContain = size / k;

        kIsSmaller(head, list, more, singleContain);
        return list.toArray(new ListNode[0]);
    }
}