package math;

public class DivideTwoIntegers {
	
	public int divide(int dividend, int divisor) {
		
		if (divisor == 0) {
            return Integer.MAX_VALUE;
        } else if (divisor == 1) {
            return dividend;
        } else if (divisor == -1) {
        	//notice that there is no positive 2147483648 exsit in system
            return (dividend == Integer.MIN_VALUE) ? Integer.MAX_VALUE : -dividend;
        } else {
	        long a = Math.abs((long)dividend);
	        long b = Math.abs((long)divisor);
	        
	        int answer = 0;
	        while (a >= b) {
	            int shift = 0;
	        	while (a >= (b << shift)) {
	        		shift++;
	        		if (b << shift < 0) {
	        			break;
	        		}
	        	}
	        	shift--;
	        	answer = answer + (1 << shift);
	        	a = a - (b << shift);
	        }
	
			if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
			    return answer;
			} else {
			    return -answer;
			}
        }
    }
	
	public static void main(String[] args) {
		DivideTwoIntegers d = new DivideTwoIntegers();
		
//		System.out.println(d.divide(2147483647, 1));
//		System.out.println(d.divide(-1010369383, -2147483647));
		System.out.println(d.divide(-2147483648, -1));
		
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Math.abs(Integer.MIN_VALUE));
	}
}
