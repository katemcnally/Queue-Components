package bddqueue;

import java.util.*;

public abstract class AbstractStack<E> implements Stack<E> {

	protected final int capacity;
	
	protected AbstractStack(int max) throws IllegalArgumentException {
		if(max <= 0) throw new IllegalArgumentException();
		capacity = max;
	}
	
	public int capacity() {
		return capacity;
	}
	
	public boolean isEmpty() {
		return depth() == 0;
	}

	public boolean isFull() {
		return depth() == capacity;
	}
	
	public void flip() {
		Stack<E> temp = copy();
		this.clear();
		while(!temp.isEmpty()) {
			E elem = temp.pop();
			this.push(elem);
		}
	}
	
	public Stack<E> copy() {
		Stack<E> result = newInstance();
		for(E elem : this) {
			result.push(elem);
		}
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacity;
		result = prime * result + depth();
		for(E elem : this) {
			result = prime * result + elem.hashCode();
		}
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Stack)) return false;
		Stack<?> other = (Stack<?>) obj;
		if (capacity != other.capacity()) return false;
		if (depth() != other.depth()) return false;
		Iterator<?> otherIter = other.iterator();
		for(E elem : this) {
			if(!elem.equals(otherIter.next())) return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Iterator<E> iter = this.iterator();
		while(iter.hasNext()) {
			sb.append(iter.next());
			if(!iter.hasNext()) sb.append(", ");
		}
		sb.append("]:" + capacity());
		return sb.toString();
	}
}