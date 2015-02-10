package math;

public class StringToInteger {
	
	public int atoi(String str) {
        if(str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        
        int sign = 1;
        int index = 0;
        
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        
        long num = 0;
        for (; index < str.length(); index++) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9') {
                break;
            }
            num = num * 10 + (str.charAt(index) - '0');
            if ((num > Integer.MAX_VALUE && sign == 1) || (num * (-1) < Integer.MIN_VALUE && sign == -1)) {
                break;
            }
        }
        if (num * sign > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (num * sign < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)num * sign;
    }
	
	public static void main(String[] args) {
		StringToInteger s = new StringToInteger();
		System.out.println(s.atoi("-9223372036854775809"));
	}
}
