package string;

public class LongestPalindromicSubString {


	public String longestPalindrome(String s) {
    	if (s == null || s.length() == 0) {
    		return s;
    	}
    	
    	String rst = s.substring(0, 1);
    	for (int i = 0; i < s.length(); i++) {
    		
            // get longest palindrome with center of i
    		String tmp = helper(s, i, i);
    		if (tmp.length() > rst.length()) {
    			rst = tmp;
    		}
    		
            // get longest palindrome with center of i, i+1
    		tmp = helper(s, i, i + 1);
    		if (tmp.length() > rst.length()) {
    			rst = tmp;
    		}
    	}
    	return rst;
    }
    
    // Given a center, either one letter or two letter, find longest palindrome
    private String helper(String s, int left, int right) {
    	
    	while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
    		left--;
    		right++;
    	}
    	return s.substring(left + 1, right);
    }
}
