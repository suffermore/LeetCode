package math;

public class ReverseInteger {
	public int reverse(int x) {
        int rst = 0;
        while(x != 0){
        	//solve the condition in which x * 10 is overflow
        	if (x > 0 && ((Integer.MAX_VALUE - x % 10) / 10 < rst)) {
            	return 0;
            } else if (x < 0 && (Integer.MIN_VALUE - x % 10) / 10 > rst) {
            	return 0;
            } else {
            	rst = rst * 10 + x % 10;
            	x = x / 10;
            }
        }
        return rst;
    }
	public static void main(String[] args) {
		ReverseInteger ri = new ReverseInteger();
		int x = ri.reverse(1534236469);
        System.out.println(x);
	}
}
