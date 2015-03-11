package dfs;

import java.util.ArrayList;

public class PalindromePatitioning {

	/**
     * @param s: A String waited to be cut
     * @return: A list of lists of palindromes
     * 
     * @Note: there is a PalindromePartitioning II which is solved by dp in dp package
     */
	public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (s == null || s.length() == 0) {
            return result;
        }
        ArrayList<String> path = new ArrayList<String>();
        helper(result, path, s, 0);
        System.out.println(result.toString());
        return result;
    }
    
    private void helper(ArrayList<ArrayList<String>> result, ArrayList<String> path, String s, int pos) {
        if (pos == s.length()) {
            result.add(new ArrayList<String>(path));
            return;
        }
        
        for (int i = pos; i < s.length(); i++) {
            String prefix = s.substring(pos, i + 1);
            if (isPalindrome(prefix)) {
                path.add(prefix);
                helper(result, path, s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
		PalindromePatitioning p = new PalindromePatitioning();
		p.partition("ab");
	}
}
