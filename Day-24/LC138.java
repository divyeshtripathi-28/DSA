/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        HashMap<Node, Node> rMap = new HashMap<>();
        HashMap<Node, Node> nMap = new HashMap<>();
        HashMap<Node, Node> copyMap = new HashMap<>();


        Node temp = head;

        while(temp != null) {
            rMap.put(temp, temp.random);
            nMap.put(temp, temp.next);
            temp = temp.next;
        }

        temp = head;

        Node newHead = new Node(temp.val);

        Node newTemp = newHead;

        while(temp != null) {
            copyMap.put(temp, newTemp);
            Node nxt = nMap.get(temp);

            if(nxt != null) {
                newTemp.next = new Node(nxt.val);
                newTemp = newTemp.next;
            }

            temp = temp.next;
        }

        temp = head;
        newTemp = newHead;

        while(temp != null) {
            Node rand = rMap.get(temp);
            newTemp.random = copyMap.get(rand);

            temp = temp.next;
            newTemp = newTemp.next;
        }

        return newHead;
    }
}