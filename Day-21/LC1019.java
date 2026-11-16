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
    public int[] nextLargerNodes(ListNode head) {
        ListNode temp = head;
        ArrayList<Integer> arr = new ArrayList<>();
        

        while(temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }

        int[] result = new int[arr.size()];
        int st[] = new int[arr.size()];

        int top = -1;
        st[++top] = 0;

        for(int i = 1; i < arr.size(); i++) {
            while(top != -1 && arr.get(st[top]) < arr.get(i)) {
                result[st[top--]] = arr.get(i);
            }

            st[++top] = i;
        }

        while(top != -1) {
            result[st[top--]] = 0;
        }

        return result;
    }
}