package dp;

public class PalindromePartitioningII {

	public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] cut = new int[s.length() + 1];
        boolean[][] isPalindrome = getIsPalindrome(s);

        cut[0] = 0;
        for (int i = 1; i <= s.length(); i++) {
            cut[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                if (isPalindrome[i - j][i - 1] && cut[i - j] != Integer.MAX_VALUE) {
                    cut[i] = Math.min(cut[i], cut[i - j] + 1);
                }
            }
        }

        //we assume cut[s.length()] = 1 even if s = "aaa", so each time we get cut[s.length], it should minus 1
        return cut[s.length()] - 1;
    }
    
    /**
     * isPalindrome[i][j] means whether s.substring(i, j+1) which is string[i,j] is palindrome.
     * */
    private boolean[][] getIsPalindrome(String s) {
    	boolean[][] isPalindrome = new boolean[s.length()][s.length()];
    	//all strings whose length is 1 is palindrome
    	for (int i = 0; i < s.length(); i++) {
    		isPalindrome[i][i] = true;
    	}
    	
    	//all strings whose length is 2
    	for (int i = 0; i < s.length() - 1; i++) {
    		isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i+ 1));
    	}
    	
    	//all other conditions: based on length is 1 and 2
    	for (int length = 3; length <= s.length(); length++) {
    		for (int i = 0; i < s.length() - length + 1; i++) {
    			isPalindrome[i][i + length - 1] = isPalindrome[i + 1][i + length - 2] 
    					&& (s.charAt(i) == s.charAt(i + length - 1));
    		}
    	}
    	
		return isPalindrome;
    }
    
    public static void main(String[] args) {
		PalindromePartitioningII p = new PalindromePartitioningII();
		p.minCut("aa");
	}
}
