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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode temp = head;
        int size = 0;

        while(temp != null) {
            size++;
            temp = temp.next;
        }

        int arr[] = new int[size];
        int st[] = new int[size];
        int top = -1;

        temp = head;
        int k = 0;

        while(temp != null) {
            arr[k] = temp.val;
            temp = temp.next;
            k++;
        }

        int criticalPt = 0;

        for(int i = 1; i < arr.length - 1; i++) {
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
                criticalPt++;
                st[++top] = i;
            }

            if(arr[i] < arr[i-1] && arr[i] < arr[i+1]) {
                criticalPt++;
                st[++top] = i;
            }
        }

        if(criticalPt < 2) {
            int result [] = new int [2];
            result[0] = result[1] = -1;
            return result;
        }

        int lastPt = st[top];

        int minDist = Integer.MAX_VALUE;

        while(top != 0) {
            int f = st[top--];
            int g = st[top];

            minDist = Math.min(minDist, f - g);
        }

        int firstPt = st[top];

        int result [] = new int [2];
        result[0] = minDist;

        result[1] = lastPt - firstPt;


        return result;
    }
}