package graph;

import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph {
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		
		if (node == null) {
			return null;
		}
		
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        ArrayList<UndirectedGraphNode> list = new ArrayList<UndirectedGraphNode>();

        map.put(node, new UndirectedGraphNode(node.label));
        list.add(node);
        
        int index = 0;
        while (index < list.size()) {
        	UndirectedGraphNode cur = list.get(index);
        	for (int i = 0; i < cur.neighbors.size(); i++) {
        		UndirectedGraphNode neigbor = cur.neighbors.get(i);
        		if (!map.containsKey(neigbor)) {
        			list.add(neigbor);
        			map.put(cur.neighbors.get(i), new UndirectedGraphNode(neigbor.label));
        		}
        	}
        	index++;
        }
        
        //clone neigbors
        for (int i = 0; i < list.size(); i++) {
        	UndirectedGraphNode newNode = map.get(list.get(i));
        	
        	for (UndirectedGraphNode temp: list.get(i).neighbors) {
        		newNode.neighbors.add(map.get(temp));
        	}
        	
        }
        
        return map.get(node);
    }
}
