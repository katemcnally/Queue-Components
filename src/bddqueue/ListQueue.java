package bddqueue;

import java.util.*;

public class ListQueue<E> extends AbstractQueue<E> {
	
	private List<E> list;
	
	public ListQueue(int max) {
		super(max);
		list = new ArrayList<>();
	}

	public int length() {
		return list.size();
	}

	public void clear() {
		list.clear();
	}

	public Queue<E> newInstance() {
		return new ListQueue<>(capacity);
	}

	public boolean isValid() {
		for(E elem : list) {
			if(elem == null) return false;
		}
		if(list.size() > capacity) return false;
		if(capacity <= 0) return false;
		return true;
	}
	
	public Iterator<E> iterator() {
		return list.iterator();
	}

	@Override
	public void enqueue(E element) throws NullPointerException, IllegalStateException {
		if(element == null){	  	
            throw new NullPointerException();	  	
        }  	
        else{
            if(length()<capacity){  	
            	list.add(element);
            } 	
            else{ 	
                throw new IllegalStateException();	
            }	  	
        }
	}

	@Override
	public E dequeue() throws IllegalStateException {
		if(length()!=0){ 	
            E x = list.get(0);	
            list.remove(0);  	
            return x;  	
        } 	
        else{  	
            throw new IllegalStateException();
        }  	
	}
}