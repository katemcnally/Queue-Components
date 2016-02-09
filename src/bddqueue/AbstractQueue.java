package bddqueue;

import java.util.*;

public abstract class AbstractQueue<E> implements Queue<E> {

	protected final int capacity;
	
	protected AbstractQueue(int max) throws IllegalArgumentException {
		capacity = max;
	}
	
	public int capacity() {
		return capacity;
	}
	
	public boolean isEmpty() {
		if(this.length() == 0){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean isFull() {
		return length() == capacity;
	}
	
	public void append(Queue<E> that) throws NullPointerException, IllegalStateException{ //append
		int length_that = that.length();
		if(that.length() == 0){
			throw new NullPointerException();
		}
		while(that.length() != 0) {
			E elem = that.dequeue();
			this.enqueue(elem);
			length_that--;
		}
		int sum = this.length() + that.length();
		if(this.capacity <= sum){
			throw new IllegalStateException();
		}
		
	}
	
	public Queue<E> copy() {
		Queue<E> result = newInstance();
		for(E elem : this) {
			result.enqueue(elem);
		}
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacity;
		result = prime * result + length();
		for(E elem : this) {
			result = prime * result + elem.hashCode();
		}
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Queue)) return false;
		Queue<?> other = (Queue<?>) obj;
		//if (capacity != other.capacity()) return false;
		//if (length() != ((Queue) other).length()) return false;
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