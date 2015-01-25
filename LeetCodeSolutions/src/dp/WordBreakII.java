package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordBreakII {

    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        return wordBreakHelper(s,dict,map);
    }

    public ArrayList<String> wordBreakHelper(String s, Set<String> dict, Map<String, ArrayList<String>> memo){
        if(memo.containsKey(s)) {
        	return memo.get(s);
        }
        
        ArrayList<String> result = new ArrayList<String>();
        
        int n = s.length();
        if(n <= 0) {
        	return result;
        }
        
        for(int len = 1; len <= n; ++len){
            String subfix = s.substring(0,len);
            if(dict.contains(subfix)){
                if(len == n){
                    result.add(subfix);
                }else{
                	//notice substring(index) means s.subtring(index, s.length() + 1)
                    String prefix = s.substring(len);
                    ArrayList<String> tmp = wordBreakHelper(prefix, dict, memo);
                    for(String item:tmp){
                        item = subfix + " " + item;
                        result.add(item);
                    }
                }
            }
        }
        memo.put(s, result);
        return result;
    }
    
	//method II, Time Limit Exceeded in the second test case
	public ArrayList<String> wordBreakII(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return result;
        }
        
        String path = "";
        helper(result, path, s, dict, 0);
        
        System.out.println(result.toString());
        return result;
    }
    
    private void helper(ArrayList<String> set, String path, String s, Set<String> dict, int pos) {
        if (pos == s.length()) {
            set.add(path.substring(1, path.length()));
        }
        
        for (int i = pos; i < s.length(); i++) {
            String tmp = s.substring(pos, i + 1);
            if (dict.contains(tmp)) {
                path += " " + tmp;
                helper(set, path, s, dict, i + 1);
                path = path.substring(0, pos);
            }
        }
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
		
//		dict.add("a");
//		dict.add("aa");
//		dict.add("aaa");;
//		w.wordBreak("aaaab", dict);
	}
}
