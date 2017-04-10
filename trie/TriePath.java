package trie;

public class TriePath {
	
	private TrieNode node;
	private String pathString;
	
	public TriePath() {}
	
	public TriePath(TrieNode node, String pathString) {
		this.node = node;
		this.pathString = pathString;
	}
	
	public TrieNode getNode() {
		return node;
	}
	public void setNode(TrieNode node) {
		this.node = node;
	}
	public String getPathString() {
		return pathString;
	}
	public void setPathString(String pathString) {
		this.pathString = pathString;
	}
	
}
