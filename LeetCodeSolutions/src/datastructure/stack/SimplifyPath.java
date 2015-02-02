package datastructure.stack;

import java.util.Stack;

public class SimplifyPath {

	public String simplifyPath(String path) {
		if (path == null || path.length() == 0) {
			return path;
		}
		
		String[] str = path.split("/");
		
		Stack<String> stack = new Stack<String>();
		for (String item: str) {
			if (item.equals("") || item.equals(".")) {
				continue;
			} else if (item.equals("..")) {
				if(!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(item);
			}
		}
		
		String rst = "";
		while (!stack.isEmpty()) {
			String temp = "/" + stack.pop();
			rst = temp + rst;
		}
		
		if (rst == "") {
			return "/";
		} else {
			return rst;
		}
    }
	
	public static void main(String[] args) {
		SimplifyPath s = new SimplifyPath();
		System.out.println(s.simplifyPath("//a/b/../c"));
	}
}
