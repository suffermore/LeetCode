package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordBreakII {

	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> result = new ArrayList<String>();
		HashMap<String, ArrayList<String>> memo = new HashMap<String, ArrayList<String>>();
		result = helper(s, dict, memo);
		System.out.println(result.toString());
		return result;
	}
    
	private ArrayList<String> helper(String s, Set<String> dict, Map<String, ArrayList<String>> memo) {
		if (memo.containsKey(s)) {
			return memo.get(s);
		}
		
		ArrayList<String> result = new ArrayList<String>();
		
		int len = s.length();
		if (len == 0) {
			return result;
		}
		
		for (int i = 1; i <= len; i++) {
			String prefix = s.substring(0, i);
			if (dict.contains(prefix)) {
				if (i == len) {//when i == len, there's no subfix behind. so add current string to result directly
					result.add(prefix);
				} else {
					String subfix = s.substring(i);
					ArrayList<String> subResult = helper(subfix, dict, memo);
					for (String item: subResult) {
						result.add(prefix + " " + item);
					}
				}
			}
		}
		
		//use memo to store the string that we have addressed, int order to deal with the same string next time
		memo.put(s, result);
		return result;
	}
	
    public static void main(String[] args) {
		WordBreakII w = new WordBreakII();
		Set<String> dict = new HashSet<String>();
		
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		w.wordBreak("catsanddog", dict);
		
		dict.add("a");
//		dict.add("aa");
//		dict.add("aaa");;
		w.wordBreak("a", dict);
	}
}
