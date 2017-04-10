package trie;

public class TrieNode {
	private boolean strInTrie = false;
	
	private final TrieNode[] children = new TrieNode[26];
	
	public TrieNode() {
		
	}

	public boolean isStrInTrie() {
		return strInTrie;
	}

	public void setStrInTrie(boolean strInTrie) {
		this.strInTrie = strInTrie;
	}
	
	public void addChild(TrieNode child, int pos) {
		this.children[pos] =  child;
	}
	
	public TrieNode getChild(int pos) {
		return children[pos];
	}
}
