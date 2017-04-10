package trie;

import stack.ArrayStack;

public class Trie {
	private TrieNode root = null;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public void insertStr(String str) {
		char[] charArray = str.toCharArray();
		
		TrieNode cur = root;
		for (char c: charArray) {
			if (cur.getChild(c-'a')!=null) {
				cur = cur.getChild(c-'a');
			}
			else {
				TrieNode child = new TrieNode();
				cur.addChild(child, c-'a');
				cur = child;
			}
		}
		cur.setStrInTrie(true);
	}
	
	public boolean strExist(String str) {
		char[] charArray = str.toCharArray();
		
		TrieNode cur = root;
		for (char c: charArray) {
			if (cur.getChild(c-'a')==null) {
				return false;
			}
			cur = cur.getChild(c-'a');
		}
		return cur.isStrInTrie();
	}
	
	public void printStr() {
		
		if (root == null) return;
		
		ArrayStack st = new ArrayStack();
		st.push(new TriePath(root,""));
		
		while (!st.isEmpty()) {
			TriePath cur = st.pop();
			TrieNode node = cur.getNode();
			String pathString = cur.getPathString();
			
			if (node.isStrInTrie()) System.out.println(pathString);
			
			for (int i=25;i>=0;i--) {
				if (node.getChild(i) != null) {
					st.push(new TriePath(node.getChild(i), pathString+(char)(i+'a')));
				}
			}
		}
	}
	
	public void recPrint(TrieNode node, String running) {
		if (node == null) return;
		if (node.isStrInTrie()) System.out.println(running);
		
		for (int i=0;i<26;i++) {
			recPrint(node.getChild(i),running+(char)(i+'a'));
		}
	}
	
	public static void main(String[] args) {
		Trie t = new Trie();

		t.insertStr("hello");
		t.insertStr("world");
		t.insertStr("hel");
		t.insertStr("hellow");
		t.insertStr("new");
		t.insertStr("hsef");
		t.insertStr("adsafo");
		t.insertStr("afsedzx");
		t.insertStr("asdfxv");
		t.insertStr("srtjytufy");
		t.insertStr("hgdmcnb");
		t.insertStr("tuilkhg");
		t.insertStr("rtytgh");
		t.insertStr("eargbfhg");
		t.insertStr("zdxhfgjku");
		t.insertStr("egzrfd");
		t.insertStr("drfv");
		t.insertStr("eszdfd");
		t.insertStr("dfvc");
		t.insertStr("sd");
		t.insertStr("edfb");
		t.insertStr("grzf");
		t.insertStr("adxhfgjkzfcsdfvgsfbsu");
		
		t.printStr();
	}
}
