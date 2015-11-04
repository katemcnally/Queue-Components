package bddqueue;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class ListQueueTest {

	ListQueue<Object> q = new ListQueue<>(20); 	
	ListQueue<Object> q2 = new ListQueue<>(10);
	ListQueue<Object> q3 = new ListQueue<>(4);
		  	
	     @Before 	
	     public void setUp() throws Exception {
	         q.enqueue("Hello");
	         q.enqueue("Shaked");	
	         q.enqueue("Kate");	
	         q.enqueue("Audrey");	
	         q2.enqueue(1);	
	         q2.enqueue(2);  	
	         q2.enqueue(3); 
	         
	     }
	     
	     
}
