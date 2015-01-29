package dp;

/**
 * @LintCode
 * 
 * For "ABCD" and "EDCA", the LCS is "A" (or D or C), return 1
 * For "ABCD" and "EACB", the LCS is "AC", return 2
 * 
 * @param A, B: Two strings.
 * @return: The length of longest common subsequence of A and B.
 */
public class LongestCommonSubsequence {

	public int longestCommonSubsequence(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();
        
        int[][] dp = new int[lenA + 1][lenB + 1];
        
        for (int i = 0; i <= lenA; i++) {
        	dp[i][0] = 0;
        }
        for (int i = 0; i <= lenB; i++) {
        	dp[0][i] = 0;
        } 
        
        for (int i = 1; i <= lenA; i++) {
        	for (int j = 1; j <= lenB; j++) {
        		//notice when charaters at i and j is not equals, what should we do
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
		System.out.println(l.longestCommonSubsequence("bedaacbade", "dccaeedbeb"));
	}
}
