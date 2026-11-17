class BrowserHistory {
    Stack<String> back;
    Stack<String> forward;


    public BrowserHistory(String homepage) {
        back = new Stack<>();
        forward = new Stack<>();
        back.push(homepage);
    }
    
    public void visit(String url) {
        forward.clear();
        back.push(url);
    }
    
    public String back(int steps) {
        int i = 1;
        while(back.size() > 1 && i <= steps) {
            forward.push(back.pop());
            i++;
        }

        return back.peek();
    }
    
    public String forward(int steps) {
        int i = 1;

        while(!forward.isEmpty() && i <= steps) {
            back.push(forward.pop());
            i++;
        }

        return back.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */