package datastructure.stack;

import java.util.Stack;

public class MinStack {

	Stack<Integer> regStack;
	Stack<Integer> minStack;
	
	public MinStack() {
		regStack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	
    public void push(int x) {
        regStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
        	minStack.push(x);
        }
    }

    public void pop() {
    	int top = regStack.pop();
    	if (top == minStack.peek()) {
    		minStack.pop();
    	}
    }

    public int top() {
        return regStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
