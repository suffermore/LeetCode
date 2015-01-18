package math;

public class Power {
	public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n *= -1;
        }
//        int k = n / 2;
//        int l = n - n / 2;
//        if (isNegative) {
//            return 1 / (pow(x, k) * pow(x, l));
//        } else {
//            return pow(x, k) * pow(x, l);
//        }
        int k = n / 2;
        int l = n - k * 2;
        double t1 = pow(x, k);
        double t2 = pow(x, l);
        if (isNegative) {
            return 1 / (t1 * t1 * t2);
        } else {
            return t1 * t1 * t2;
        }
    }
	
	public static void main(String[] args) {
		Power p = new Power();
		double i = p.pow(0.00001, 2147483647);
		System.out.println(i);
	}
}
