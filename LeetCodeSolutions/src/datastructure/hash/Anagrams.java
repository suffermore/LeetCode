package datastructure.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Anagrams {
	
	public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        
        for (String str: strs) {
        	char[] arr = str.toCharArray();
        	Arrays.sort(arr);
        	String temp = String.valueOf(arr);
//        	String temp = arr.toString();
        	if (map.containsKey(temp)) {
        		map.get(temp).add(str);
        	} else {
        		ArrayList<String> list = new ArrayList<String>();
        		list.add(str);
        		map.put(temp, list);
        	}
        }
        
        Iterator<Entry<String, ArrayList<String>>> iter = map.entrySet().iterator();
        
        while (iter.hasNext()) {
//        	Map.Entry entry = (Map.Entry) iter.next();
//        	ArrayList<String> val = (ArrayList<String>) entry.getValue();

        	ArrayList<String> val = iter.next().getValue();
            if (val.size() > 1) {
            	res.addAll(val);
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		Anagrams a = new Anagrams();
		String[] strs = {"", ""};
		a.anagrams(strs);
	}
}
