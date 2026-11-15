class MyCircularDeque {
    int q [];
    int front = -1;
    int rear = -1;
    int n = 0;

    public MyCircularDeque(int k) {
        q = new int [k];
        n = k;
    }
    
    public boolean insertFront(int value) {
        if(front == -1) {
            front = rear = 0;
            q[front] = value;
            return true;
        }

        if(rear == front - 1 || (front == 0 && rear == n - 1)) {
            return false;
        }

        front = (n + front - 1) % n;

        q[front] = value;

        return true;
    }
    
    public boolean insertLast(int value) {
        if(front == -1) {
            front = rear = 0;
            q[rear] = value;
            return true;
        }

        if(rear == front - 1 || (front == 0 && rear == n - 1)) {
            return false;
        }

        rear = (rear + 1) % n;

        q[rear] = value;
        
        return true;
    }
    
    public boolean deleteFront() {
        if(front == -1) {
            return false;
        }

        if(front == rear) {
            front = rear = -1;
            return true;
        }

        front = (front + 1) % n;
        
        return true;
    }
    
    public boolean deleteLast() {
        if(front == -1) {
            return false;
        }

        if(front == rear) {
            front = rear = -1;
            return true;
        }

        rear = (n + rear - 1) % n;
        
        return true;
    }
    
    public int getFront() {
        if(front == -1) {
            return -1;
        }

        return q[front];
    }
    
    public int getRear() {
        if(front == -1) {
            return -1;
        }

        return q[rear];
    }
    
    public boolean isEmpty() {
        if(front == -1) {
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if(rear == front - 1 || (front == 0 && rear == n - 1)) {
            return true;
        }

        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */