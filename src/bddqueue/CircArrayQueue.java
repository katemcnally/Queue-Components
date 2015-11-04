package bddqueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircArrayQueue<E> extends AbstractQueue<E> {
	  	
	  	
    private E[] contents;  	
    private int first;
    private int length;
    private int capacity;
	
    @SuppressWarnings("unchecked")	  	
    public CircArrayQueue(int max) {	
    	super(max);
        if(max <= 0){  	
            throw new IllegalArgumentException();
        }
  	
        contents = (E[]) new Object[max];  	
        first = 0; 	
        length = 0;  	
        capacity = max; 	
    }
	  	
    public int capacity() {	  	
        return capacity;	  	
  	}

    public void clear() {  	
        length = 0;
    }
	  	
    public E dequeue() throws IllegalStateException {	  	
        if(length!=0){ 	
            E x = contents[first];	
            first++;	  	
            length--;  	
            return x;  	
        } 	
        else{  	
            throw new IllegalStateException();
        }  	
    }
	
    public void enqueue(E element) throws NullPointerException, IllegalStateException {	
        if(element == null){	  	
            throw new NullPointerException();	  	
        }  	
        else{  	
            if(length<capacity){  	
                contents[length] = element;  	
                length++; 	
            } 	
            else{ 	
                throw new IllegalStateException();	
            }	  	
        }	  	
    }
	  	
    public boolean isEmpty() { 	
        if(length == 0){ 	
            return true;	
        } 	
        else{  	
        return false;  	
        }	  	
    }
	  	
    public boolean isFull() {  	
        if(length == capacity){	
            return true;	
        }  	
        else{ 	
        return false;  	
        }  	
    }
	  	
    public int length() {	
        return length;	  	
    }
	  	
//    public E peek() throws IllegalStateException {	
//        if(isEmpty()==true){ 	
//            throw new IllegalStateException();
//    }	
//        return contents[(first+ length -1) % capacity]; 	
//    }
  	
    public String toString(){  	
        String x = "(";	  	
        for(int i = first; i<length(); i++){	  	
            x = x + contents[i]; 	
            if(i<length()-1){  	
                x = x + ", ";  	
            }	  	
        }  	
        x = x + ")" + capacity;	  	
        return x;  	
    }

	@Override
	public boolean isValid() {
		for(int i = 0; i < length(); i++) {
			if(contents[i] == null) return false;
		}
		if(length() < 0 || length() > capacity) return false;
		if(capacity != contents.length) return false;
		if(capacity <= 0) return false;
		return true;
	}

	@Override
	public Queue<E> newInstance() {
		return new CircArrayQueue<>(capacity);
	}

	@Override
	public Iterator<E> iterator() {
		return new QueueIterator();
	}
	
	public class QueueIterator implements Iterator<E>{
		private int index;
		public QueueIterator(){
			index = 0;
		}
		public boolean hasNext(){
			return index<length;
		}
		public E next(){
			if(!hasNext()) throw new  NoSuchElementException();
			return contents[index++];
		}
	}
 	
}