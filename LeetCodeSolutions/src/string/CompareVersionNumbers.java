package string;

import java.util.ArrayList;

public class CompareVersionNumbers {
	
	public int compareVersion(String s1, String s2) {
		
		int i = 0, j = 0;
		while (i < s1.length() || j < s2.length()) {
			
			int num1 = 0;
			while (i < s1.length() && s1.charAt(i) != '.') {
				num1 = num1 * 10 + Integer.valueOf(s1.substring(i, i + 1));
				i++;
			}
			
			int num2 = 0;
			while (j < s2.length() && s2.charAt(j) != '.') {
				num2 = num2 * 10 + Integer.valueOf(s2.substring(j, j + 1));
				j++;
			}
			
			if (num1 > num2) {
				return 1;
			} else if (num1 < num2) {
				return -1;
			} else {
				i++;
				j++;
			}
		}
		
		return 0;
    }
	
	public static void main(String[] args) {
		CompareVersionNumbers c = new CompareVersionNumbers();
//		System.out.println(c.compareVersion("01", "1"));
//		System.out.println(c.compareVersion("1", "1.1"));
		System.out.println(c.compareVersion("1", "1.0"));
	}
}
