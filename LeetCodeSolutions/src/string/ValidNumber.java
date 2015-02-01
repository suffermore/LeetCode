package string;

public class ValidNumber {

    public boolean isNumber(String s) {
    	if (s == null || s.length() == 0) {
    		return false;
    	}

    	int left = 0;
    	int right = s.length() - 1;
    	//delete whitespace in front and back
    	while(left <= right && Character.isWhitespace(s.charAt(left))) {
    		left++;
    	}
    	if (left > s.length() - 1) {
    		return false;
    	}
    	while (right >= left && Character.isWhitespace(s.charAt(right))) {
    		right--;
    	}
    	
    	// skip leading +/-
    	if (s.charAt(left) == '+' || s.charAt(left) == '-') {
    		left++;
    	}
    	
    	boolean isNum = false;
    	boolean isDot = false;
    	boolean isExp = false;
	    
    	while (left <= right) {
    		char c = s.charAt(left);
    		if (Character.isDigit(c)) {
    			isNum = true;
    		} else if (c == '.') {
    			if (isDot || isExp) {
    				return false;
    			}
    			isDot = true;
    		} else if (c == 'e') {
    			if (isNum == false || isExp) {
    				return false;
    			}
    			isExp = true;
    			isNum = false;
    		} else if (c == '+' || c == '-') {
    			if (s.charAt(left - 1) != 'e') {
    				return false;
    			}
    		} else {
    			return false;
    		}
    		left++;
    	}
    	return isNum;
    }
    
    public static void main(String[] args) {
		ValidNumber v = new ValidNumber();
		if (v.isNumber("e9")) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}
}
