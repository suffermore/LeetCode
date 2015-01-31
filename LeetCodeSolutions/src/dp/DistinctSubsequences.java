package dp;

public class DistinctSubsequences {
	
	//count the number of distinct subsequences of T in S.
	public int numDistinct(String S, String T) {
        if (S.length() == 0 || T.length() == 0) {
            return 0;
        }
        
        int[][] dp = new int[T.length() + 1][S.length() + 1];
        
        for (int i = 0; i <= S.length(); i++) {
        	dp[0][i] = 1;
        }
        
        //no need to discuss the conditions when i > j, dp[i][j] must be 0 because S cannot hold T
        for (int i = 1; i <= T.length(); i++) {
        	dp[i][0] = 0;
        }
        
        //dp function
        for (int i = 1; i <= T.length(); i++) {
        	for (int j = 1; j <= S.length(); j++) {
    			dp[i][j] = dp[i][j - 1];
        		if (S.charAt(j - 1) == T.charAt(i - 1)) {
        			dp[i][j] += dp[i - 1][j - 1];
        		}
        	}
        }
        
        return dp[T.length()][S.length()];
    }

	public int numDistinctI(String S, String T) {
        int[][] dp = new int[T.length() + 1][S.length() + 1];

        //while s == "", there are always one subsequence in T which equals to ""
		for (int i = 0; i <= S.length(); i++) {
			dp[0][i] = 1;
		}
		
		for (int i = 1; i <= T.length(); i++) {
            //while j < i, dp[i][j] must quals to 0
			for (int j = i; j <= S.length(); j++) {
				dp[i][j] = dp[i][j - 1];
				if (S.charAt(j - 1) == T.charAt(i - 1)) {
					dp[i][j] += dp[i - 1][j - 1];
				}
			}
		}

        return dp[T.length()][S.length()];
	}

	public static void main(String[] args) {
		DistinctSubsequences d = new DistinctSubsequences();
		System.out.println(d.numDistinct("ddd", "dd"));
	}
}
