package dp;

public class InterleavingString {

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		
		//interleaved[i][j] = true means first i of s1 and first j of s2 can create fisrt i + j of s3
		boolean[][] interleaved = new boolean[s1.length() + 1][s2.length() + 1];
		interleaved[0][0] = true;
		
		for (int i = 1; i <= s1.length(); i++) {
			if (interleaved[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1)) {
				interleaved[i][0] = true;
			}
		}
		
		for (int i = 1; i <= s2.length(); i++) {
			if (interleaved[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1)) {
				interleaved[0][i] = true;
			}
		}
		
		//dp programming
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if ((interleaved[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || 
						(interleaved[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1))) {
					interleaved[i][j] = true;
				}
			}
		}
		
		return interleaved[s1.length()][s2.length()];
	}
}
