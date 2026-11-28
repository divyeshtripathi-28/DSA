/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public void flat(Node head, List<Node> list) {
        if(head == null) {
            return;
        }

        list.add(head);
        flat(head.child, list);
        flat(head.next, list);
    }
    public Node flatten(Node head) {
        if(head == null) {
            return null;
        }
        List<Node> list =  new ArrayList<>();

        flat(head, list);

        Node newHead = list.get(0);
        Node temp = newHead;

        for(int i = 1; i < list.size(); i++) {
            temp.child = null;
            temp.next = list.get(i);
            temp = temp.next;
        }

        temp.child = null;
        temp.next = null;

        temp = newHead;
        Node prev = null;

        while(temp != null) {
            temp.prev = prev;
            prev = temp;
            temp = temp.next;
        }

        return newHead;
    }
}