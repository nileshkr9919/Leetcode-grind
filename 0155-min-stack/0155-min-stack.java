class MinStack {
    Deque<int[]> items;

    public MinStack() {
        items = new ArrayDeque<>();
    }

    public void push(int val) {
        if (items.isEmpty()) {
            items.push(new int[]{val, val});
        } else {
            int currentMin = items.peek()[1];
            items.push(new int[]{val, Math.min(val, currentMin)});
        }
    }

    public void pop() {
        items.pop();
    }

    public int top() {
        return items.peek()[0];
    }

    public int getMin() {
        return items.peek()[1];
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