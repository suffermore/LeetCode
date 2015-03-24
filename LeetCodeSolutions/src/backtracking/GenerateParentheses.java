package backtracking;

import java.util.ArrayList;

public class GenerateParentheses {
	
	//Another problem about Parentheses: Valid Parentheses
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
		if (n <= 0) {
			return result;
		}
		helper(result, "", n, n);
		return result;
    }
	
	private void helper(ArrayList<String> result, String s, int left, int right) {
		if (left > right || left < 0 || right < 0) {
			return;
		}
		if (left == 0 && right == 0) {
			result.add(s);
		}
		helper(result, s + "(", left - 1, right);
		helper(result, s + ")", left, right - 1);
	}
}
