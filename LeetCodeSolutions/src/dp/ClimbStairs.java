package dp;

public class ClimbStairs {
	
	//use scrolling array
    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        int[] sum = new int[3];
        sum[0] = 1;
        sum[1] = 2;
        for (int i = 2; i < n; i++) {
            sum[i%2] = sum[(i - 1) % 2] + sum[(i - 2) % 2];
        }
        return sum[(n - 1) % 2];
    }
    
    //normal method
    public int climbStairsII(int n) {
        if (n < 2) {
            return n;
        }
        int[] f = new int[n];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n - 1];
    }
}
