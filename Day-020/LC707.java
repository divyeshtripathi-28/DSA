class MyLinkedList {
    int val;
    MyLinkedList next;

    MyLinkedList(int data) {
        this.val = data;
        this.next = null;
    }
    
    public MyLinkedList() {
        this.next = null;
    }

    MyLinkedList head = null;
    MyLinkedList tail = null;
    int size = 0;
    
    public int get(int index) {
        int i = 0;
        MyLinkedList temp = head;

        if(index >= size) {
            return -1;
        }

        while(i < index) {
            temp = temp.next;
            i++;
        }

        return temp.val;
    }
    
    public void addAtHead(int val) {
        MyLinkedList newNode = new MyLinkedList(val);

        if(head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head = newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        MyLinkedList newNode = new MyLinkedList(val);

        if(head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        int i = 0;
        MyLinkedList newNode = new MyLinkedList(val);
        MyLinkedList temp = head;

        if(index > size) {
            return;
        }

        if(index == 0) {
            addAtHead(val);
            return;
        }

        if(index == size) {
            addAtTail(val);
            return;
        }

        while(i < index - 1) {
            temp = temp.next;
            i++;
        }

        MyLinkedList next = temp.next;
        temp.next = newNode;
        newNode.next = next;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        int i = 0;
        MyLinkedList temp = head;

        if(index >= size) {
            return;
        }

        if(index == 0) {
            head = head.next;
            size--;
            return;
        }

        while(i < index - 1) {
            temp = temp.next;
            i++;
        }

        if(index == size - 1) {
            tail = temp;
            tail.next = null;
            size--;
            return;
        }

        temp.next = temp.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */