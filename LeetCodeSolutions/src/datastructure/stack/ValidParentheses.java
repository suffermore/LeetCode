package datastructure.stack;

import java.util.Stack;

public class ValidParentheses {
	
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (Character c : s.toCharArray()) {
            if ("{[(".contains(String.valueOf(c))) {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    Character a = stack.pop();
                    if (!isValid(a,c)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    private boolean isValid(Character a, Character b) {
        return (a == '(' && b == ')') || (a == '{' && b == '}' ) || (a == '[' && b == ']');
    }
}
