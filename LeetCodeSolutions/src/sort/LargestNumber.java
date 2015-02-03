package sort;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	
	public String largestNumber(int[] num) {
		
		String[] strNum = new String[num.length];
		
		for (int i = 0; i < num.length; i++) {
			strNum[i] = Integer.toString(num[i]);
		}
		
		Arrays.sort(strNum, new Comparator<String>() {

			@Override
			public int compare(String left, String right) {
                String leftRight = left.concat(right);
                String rightLeft = right.concat(left);
                return rightLeft.compareTo(leftRight);
			}
		});
		
		StringBuffer sb = new StringBuffer();
		for (String str: strNum) {
			sb.append(str);
		}
		
//		BigInteger result = new BigInteger(sb.toString());
//        return result.toString();
		

		String s = sb.toString();
		int i = 0;
		while (s.charAt(i) == '0' && i != s.length() - 1) {
		    i++;
		}
        return s.substring(i);
    }
	
}
