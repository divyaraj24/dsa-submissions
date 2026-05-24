class MinStack {
    Stack<Integer> st;
    Stack<Integer> minst;

    public MinStack() {
        st = new Stack<>();
        minst = new Stack<>();
    }
    
    public void push(int val) {
        if (st.isEmpty()) {
            minst.push(val);
            st.push(val);
        }
        else {
            st.push(val);
            if (minst.peek() >= val) minst.push(val);
        }

    }
    
    public void pop() {
        if (st.peek().equals(minst.peek())) {
            minst.pop();
            st.pop();
        }
        else {
            st.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minst.peek();
    }
}
