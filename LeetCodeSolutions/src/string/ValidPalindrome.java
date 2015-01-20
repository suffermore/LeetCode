package string;

public class ValidPalindrome {
	/**
     * @param s: S is the String we try to figure out.
     * @return: True if the String is palindrome, or false
     */
	public boolean isPalindrome(String s) {
        if (s== null || s.length() == 0) {
            return true;
        }
        
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
        	//locate position of left and right to the 1st letter
        	while (left < s.length() && !isValid(s.charAt(left))) {
        		left++;
        	}
        	if (left == s.length()) {
        		return true;
        	}
        	while (right > 0 && !isValid(s.charAt(right))) {
        		right--;
        	}
        	
        	//for now, element in s whose index is left and right is valid character
            if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                left++;
                right--;
            } else {
            	break;
            }
        }
        
        return left >= right;
    }
    
    private boolean isValid(char c) {
        return Character.isDigit(c) ||Character.isLetter(c);
    }
}
