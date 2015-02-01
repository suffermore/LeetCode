package string;

public class IntegerToRoman {

	public String intToRoman(int tar) {
		if (tar < 0) {
			return "";
		}
		
		int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 3, 2, 1};
		String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "III", "II", "I"};
		
//		int[] nums = {1000, 500, 100, 50, 10, 5, 3, 2, 1};
//		String[] symbols = {"M", "D", "C", "L", "X", "V", "III", "II", "I"};
		
		StringBuilder sb = new StringBuilder();
		
		int i = 0;
		while (tar >= 0) {
			
			int times = tar / nums[i];
			tar = tar - times * nums[i];
			for (;times > 0; times++) {
				sb.append(symbols[i]);
			}
			
			i++;
		}
		
		return sb.toString();
	}
}
