/* Core Idea:
1.Minimum value is always followed by the second minimum value (duplicate value of the second minimum value, to ensure that when pop function removes the 2nd min, it does not disrupt the stack order).
2.And while popping you pop min and 2nd min so that, you get the correct min value for the remaining stack and the remaining stack top also points to the right place.
*/

class MinStack {
    
    int min;
    Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if(x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        if(stack.pop() == min)
            min = stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */