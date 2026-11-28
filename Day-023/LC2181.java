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
    public ListNode mergeNodes(ListNode head) {
        List<ListNode> list = new ArrayList<>();

        ListNode temp = head.next;
        int sum = 0;

        while(temp != null) {
            if(temp.val == 0) {
                list.add(new ListNode(sum));
                sum = 0;
            } else {
                sum += temp.val;
            }

            temp = temp.next;
        }

        ListNode newHead = list.get(0);

        ListNode temp2 = newHead;

        for(int i = 1; i < list.size(); i++) {
            temp2.next = list.get(i);
            temp2 = temp2.next;
        }

        return newHead;
    }
}