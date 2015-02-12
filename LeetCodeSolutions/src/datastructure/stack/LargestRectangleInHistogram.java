package datastructure.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {

	public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <= height.length; i++) {
            int curHeight = i == height.length ? 0 : height[i];
            
            while (!stack.isEmpty() && curHeight < height[stack.peek()]) {
                int index = stack.pop();
                int h = height[index];
                int w = stack.isEmpty()? i : i - 1 - stack.peek();
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        
        return max;
    }
	
	public static void main(String[] args) {
		LargestRectangleInHistogram l = new LargestRectangleInHistogram();
//		int[] height = {1};
		int[] height = {2,1,2};
		System.out.println(l.largestRectangleArea(height));
	}
}
