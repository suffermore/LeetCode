package datastructure.trie;

public class TrieNode {
	//check whether string end in this node is a word
	public boolean isStr;
	public TrieNode nodes[];
	
	public TrieNode() {
		isStr = false;
		nodes = new TrieNode[26];
	}
}
