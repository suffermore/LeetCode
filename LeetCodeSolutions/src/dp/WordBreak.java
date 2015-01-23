package dp;

import java.util.Set;

public class WordBreak {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
        	return false;
        }
        int maxLen = getMaxLength(dict);
        
        boolean[] can = new boolean[s.length() + 1];
        can[0] = true;
        //can[i] means whether the first i element can be perfectly cut
        for (int i = 1; i <= s.length(); i++) {
        	for (int j = 1; j <= i && j <= maxLen; j++) {
        		if (!can[i - j]) {
        			continue;
        		}
        		String word = s.substring(i - j, i);
        		if (dict.contains(word)){
        			can[i] = true;
        			break;
        		}
        	}
        }
        return can[s.length()];
    }
    
    private int getMaxLength(Set<String> dict) {
    	int max = 0;
    	for (String word: dict) {
    		max = Math.max(max, word.length());
    	}
    	return max;
    }
}
