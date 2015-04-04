package datastructure.trie;
//import trie.TrieNode;

public class StanderdTrie {
	
	private static Node root = new Node();
	
	public static void insert(String str) {
		Node t = root;
		Node tempNode = null;
		
		for (int i = 0; i < str.length(); i++) {
			System.out.println(i);
			System.out.println(t.nodes[str.charAt(i)-'a']);
			if (t.nodes[str.charAt(i) - 'a'] == null) {
				tempNode = new Node();
				t.nodes[str.charAt(i) - 'a'] = tempNode;
			}
			t = t.nodes[str.charAt(i) - 'a'];
		}
		t.isStr = true;
	}
	
	public static boolean find(String str) {
		Node t = root;
		int i;
		for (i = 0; i < str.length(); i++) {
			t = t.nodes[str.charAt(i)-'a'];
			if (t == null){
				break;
			}
		}
		return (t!=null && t.isStr==true);
	}
	
	public static void main(String args[]){
		insert("abc");
		insert("abd");
		insert("bbb");
		insert("bcd");
		
		if (find("abd")){
			System.out.println("abd has been in this trie.");
		}
		if (find("bcd")){
			System.out.println("bcd has been in this trie.");
		}
	}
	
	private static class Node {
        boolean isStr;
        Node[] nodes;
        
        Node() {
            isStr = false;
            nodes = new Node[26];
        }
    }
}
