class MinStack {
    Stack<Integer>st;
    Stack<Integer>min_st;
    public MinStack() {
        st=new Stack<>();
        min_st=new Stack<>();
    }
    
    public void push(int value) {
        st.push(value);
        if(min_st.isEmpty()||value<=min_st.peek()){
            min_st.push(value);
        }
    }
    
    public void pop() {
        if(st.peek().equals(min_st.peek())){
            min_st.pop();
        }
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min_st.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */