package math;

public class FactorialTrailingZeros {

    public int trailingZeroes(int n) {
        int sum = 0;
        long factor = 5;
        while (n >= factor) {
            sum += n / factor;
            factor *= 5;
        }
        return sum;
    }
}
