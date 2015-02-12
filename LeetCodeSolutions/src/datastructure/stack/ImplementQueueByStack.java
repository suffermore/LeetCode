package datastructure.stack;

import java.util.Stack;

public class ImplementQueueByStack {

	Stack<Integer> inStack;
	Stack<Integer> outStack;
	
	public ImplementQueueByStack() {
		inStack = new Stack<Integer>();
		outStack = new Stack<Integer>();
	}
	
	public void push(int x) {
		inStack.push(x);
	}
	
	public void pop() {
		if (outStack.isEmpty()) {
			while (!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		} else {
			outStack.pop();
		}
	}
	
	public int top() {
		if (!outStack.isEmpty()) {
			return outStack.peek();
		} else {
			return inStack.firstElement();
		}
	}
}
