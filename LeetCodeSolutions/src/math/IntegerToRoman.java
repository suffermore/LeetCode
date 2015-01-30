package math;

public class IntegerToRoman {
	public String intToRoman(int tar) {
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        StringBuffer sb = new StringBuffer();
        
        int digit = 0;
        while (digit < nums.length) {
            int times = tar / nums[digit];
            tar = tar - times * nums[digit];
            
            for (int i = 0; i < times; i++) {
                sb.append(symbols[digit]);
            }
            digit++;
        }
        
        return sb.toString();
    }
}
