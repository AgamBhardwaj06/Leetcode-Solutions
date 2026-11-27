class MyStack {
    Queue<Integer>qu;
    public MyStack() {
        qu=new LinkedList<>();
    }
    
    public void push(int x) {
        qu.offer(x);
        int size=qu.size();
        for(int i=0;i<size-1;i++){
            qu.offer(qu.remove());
        }
    }
    
    public int pop() {
        if(qu.size()==0)return -1;
        return qu.poll();
    }
    
    public int top() {
        if(qu.size()==0)return -1;
        return qu.peek();
    }
    
    public boolean empty() {
        if(qu.size()==0)return true;
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */