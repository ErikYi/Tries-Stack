package stack;

import trie.TriePath;

public class ArrayStack {
	
	private static final int minCapacity = 10;
	private static final double extendFactor = 0.8;
	private static final double shrinkFactor = 0.3;
	
	private TriePath[] arr;
	private int size;
	private int capacity;
	
	
	public ArrayStack() {
		arr = new TriePath[minCapacity];
		size = 0;
		capacity = minCapacity;
	}
	
	public ArrayStack(int capacity) {
		this.capacity = capacity;
		arr = new TriePath[capacity];
		size = 0;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public void push(TriePath node) {
		arr[size++] = node;
		if (size > capacity*extendFactor) extend();
	}
	
	public TriePath pop() {
		TriePath res = arr[--size];
		if (capacity > minCapacity && size < capacity*shrinkFactor) shrink();
		return res;
	}
	
	public TriePath top() {
		return arr[size-1];
	}
	
	private void extend() {
		capacity *= 2; 
		TriePath[] temp = new TriePath[capacity];
		for (int i=0;i<size;i++) {
			temp[i] = arr[i];
		}
		arr = temp;
	
	}
	
	private void shrink() {
		capacity = Math.max(minCapacity,capacity/2);
		TriePath[] temp = new TriePath[capacity];
		for (int i=0;i<size;i++) {
			temp[i] = arr[i];
		}
		arr = temp;
		
	}
}
