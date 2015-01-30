package math;

import java.util.HashMap;

public class RomanToInteger {
	
	public int romanToInt (String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
	    int digit = s.length() - 1;
	    int result = map.get(s.charAt(digit));
	    
	    digit--;
	    while (digit >= 0) {
	    	if (map.get(s.charAt(digit)) >= map.get(s.charAt(digit + 1))) {
	    		result += map.get(s.charAt(digit));
	    	} else {
	    		result -= map.get(s.charAt(digit));
	    	}
	    	digit--;
	    }
	    
	    return result;
	}
}