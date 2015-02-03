package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	
	public int ladderLength(String start, String end, Set<String> dict) {
		if (dict == null || dict.size() == 0) {
            return 0;
        }
		
		Queue<String> queue = new LinkedList<String>();
		queue.add(start);
//		dict.remove(start);
		int len = 1;
		
		while (!queue.isEmpty()) {
			
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				
				String cur = queue.poll();
				
				//get possible child of current word
				for (char c = 'a'; c <= 'z'; c++) {
					for (int j = 0; j < cur.length(); j++) {
						
						if (c == cur.charAt(j)) {
							continue;
						}
						
						String tmp = replace(cur, j, c);
						if (tmp.equals(end)) {
							return len + 1;
						}
						if (dict.contains(tmp)) {
							queue.add(tmp);
							dict.remove(tmp);
						}
					}
				}
				
			}
			len++;
		}
		
		//can not find such a path, return 0
		return 0;
    }
	
	private String replace(String word, int i, char c) {
		char[] chars = word.toCharArray();
		chars[i] = c;
		return chars.toString();
	}
	
}