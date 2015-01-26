package string;

public class IsPalindrome {
	
	public boolean isPalindrome(int x) {
        //reverse x to see if x equals to it's reverse number
        int rst = reverse(x);
        return x == rst;
    }
    
    private int reverse(int x) {
        int result = 0;
        while (x > 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }
}
