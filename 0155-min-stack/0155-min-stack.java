class MinStack {
    private class TMinStack {
        int val;
        int min;

        TMinStack(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    private List<TMinStack> stack;

    public MinStack() {
        this.stack = new LinkedList();
    }

    public void push(int val) {
        int min;
        if (stack.size() == 0)
            min = val;
        else {
            min = Math.min(stack.getFirst().min, val);
        }
        this.stack.addFirst(new TMinStack(val, min));
    }

    public void pop() {
        this.stack.removeFirst();
    }

    public int top() {
        return this.stack.getFirst().val;
    }

    public int getMin() {
        return this.stack.getFirst().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */