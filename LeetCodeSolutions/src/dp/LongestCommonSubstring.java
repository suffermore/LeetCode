package dp;

public class LongestCommonSubstring {

    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
	
	public int longestCommonSubsequence(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();
        
        //dp[i][j] means the max length of common substring(includes A[i] and B[j]) of strings ending with A[i] and B[j]
        int[][] dp = new int[lenA + 1][lenB + 1];
        
        for (int i = 0; i <= lenA; i++) {
        	dp[i][0] = 0;
        }
        for (int i = 0; i <= lenB; i++) {
        	dp[0][i] = 0;
        }
        
        for (int i = 1; i <= lenA; i++) {
        	for (int j = 1; j <= lenB; j++) {
        		if (A.charAt(i - 1) == B.charAt(j - 1)) {
        			dp[i][j] = dp[i - 1][j - 1] + 1;
        		} else {
        			dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        		}
        	}
        }
        
        return dp[lenA][lenB];
    }
	
	public static void main(String[] args) {
		LongestCommonSubsequence l = new LongestCommonSubsequence();
		System.out.println(l.longestCommonSubsequence("www.lintcode.com code", "www.ninechapter.com code"));
	}
}
