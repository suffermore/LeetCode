package datastructure.stack;

import java.util.Stack;

public class LongestValidParentheses {
	
	public int longestValidParentheses(String s) {
		if (s == null) {
            return 0;
        }
		Stack<Integer> stack = new Stack<Integer>();
		int maxLen = 0;
        int accumulatedLen = 0;
        
        for(int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) == '(') {
        		stack.push(i);
        	} else {
                if (stack.isEmpty()) {
                	accumulatedLen = 0;
                } else {
                	int matchedPos = stack.pop();
                    int matchedLen = i - matchedPos + 1;

                    if (stack.isEmpty()) {
                        accumulatedLen += matchedLen;
                        matchedLen = accumulatedLen;
                    } else {
                        matchedLen = i - stack.peek();	//stack.peek() record where current pairs starts
                    }

                    maxLen = Math.max(maxLen, matchedLen);
                }
        	}
        }
        
		return maxLen;
    }
	
	public static void main(String[] args) {
		String s = "(()()";
//		String s = "((()(()";
//		String s = ")(((((())";
//		String s = "(((((((((((((()(((((())";
		LongestValidParentheses l = new LongestValidParentheses();
		System.out.println(l.longestValidParentheses(s));
	}
}
