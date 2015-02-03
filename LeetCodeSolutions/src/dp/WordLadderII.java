package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
	
	public List<List<String>> findLadders(String start, String end,
            Set<String> dict) {
        List<List<String>> ladders = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Map<String, Integer> distance = new HashMap<String, Integer>();

        dict.add(start);
        dict.add(end);
 
        bfs(map, distance, start, end, dict);
        
        List<String> path = new ArrayList<String>();
        
//        path.add(end);
        dfs(ladders, path, end, start, distance, map);

        return ladders;
    }

    void bfs(Map<String, List<String>> map, Map<String, Integer> distance,
            String start, String end, Set<String> dict) {
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        distance.put(start, 0);
        for (String s : dict) {
            map.put(s, new ArrayList<String>());
        }
        
        while (!q.isEmpty()) {
            String crt = q.poll();

            List<String> nextList = expand(crt, dict);
            for (String next : nextList) {
                map.get(crt).add(next);
                if (!distance.containsKey(next)) {
                    distance.put(next, distance.get(crt) + 1);
                    q.offer(next);
                }
            }
        }
    }

    void dfs(List<List<String>> ladders, List<String> path, String crt, String start, Map<String, Integer> distance, Map<String, List<String>> map) {
        
    	path.add(crt);
        
    	if (crt.equals(start)) {
            Collections.reverse(path);
            ladders.add(new ArrayList<String>(path));
            Collections.reverse(path);
        } else {
            for (String next : map.get(crt)) {
                if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) {
//                	path.add(next);
                    dfs(ladders, path, next, start, distance, map);
//                    path.remove(path.size() - 1);
                }
            }
        }
        
    	path.remove(path.size() - 1);
    }
    
    void dfsII(List<List<String>> ladders, List<String> path, String crt, String start, Map<String, Integer> distance, Map<String, List<String>> map) {
        
//    	path.add(crt);
        
    	if (crt.equals(start)) {
            Collections.reverse(path);
            ladders.add(new ArrayList<String>(path));
            Collections.reverse(path);
        } else {
            for (String next : map.get(crt)) {
                if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) {
                	path.add(next);
                    dfs(ladders, path, next, start, distance, map);
                    path.remove(path.size() - 1);
                }
            }
        }
        
//    	path.remove(path.size() - 1);
    }

    List<String> expand(String crt, Set<String> dict) {

        List<String> expansion = new ArrayList<String>();

        for (int i = 0; i < crt.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != crt.charAt(i)) {
                    String expanded = crt.substring(0, i) + ch + crt.substring(i + 1);
                    if (dict.contains(expanded)) {
                        expansion.add(expanded);
                    }
                }
            }
        }

        return expansion;
    }
    
    public static void main(String[] args) {
		WordLadderII w = new WordLadderII();
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		
		w.findLadders("hit", "cog", dict);
	}
}
