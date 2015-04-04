package bit;

public class ReverseBits {
	// you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rst = 0;
        int k = 32;
        while (k > 0) {
            rst = (rst << 1) + (n & 1);
            n = n >> 1;
            k--;
        }
        return rst;
    }
    
    public static void main(String[] args) {
		ReverseBits r = new ReverseBits();
		System.out.println(r.reverseBits(2));
	}
}
