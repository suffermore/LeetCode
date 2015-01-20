package dfs;

import java.util.ArrayList;

public class PalindromePatitioning {
	
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
        for (int i = pos + 1; i <= s.length(); i++) {
            String prefix = s.substring(pos, i);
            if (!isPalindrome(prefix)) {
                continue;
            }
            path.add(s.substring(pos, i));
            //new argu pos of helper is i because we never use i in last operation. s.substring(pos, i) inlude pos, and exlude i
            helper(result, path, s, i);
            path.remove(path.size() - 1);
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
		p.partition("a");
	}
}
