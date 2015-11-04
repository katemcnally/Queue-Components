package bddqueue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AbstractQueueTest {
	
	AbstractQueue<Object> q = new CircArrayQueue<>(20);
	AbstractQueue<Object> q2 = new ListQueue<>(10);

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

	@Test
	public void Capacitytest() {
		assertEquals(q.capacity, 20);
	}
	
	 @Test  	
     public void isEmptyTest(){  	
         assertFalse(q.isEmpty());	
         q.clear();  	
         assertTrue(q.isEmpty()); 	
     }
	 
	 @Test	
     public void isFullTest(){	
         assertFalse(q2.isFull());  	
         q2.enqueue(4); 	
         q2.enqueue(5);  	
         q2.enqueue(6);  	
         q2.enqueue(7);	  	
         q2.enqueue(8);	  	
         q2.enqueue(9);	  	
         q2.enqueue(10);	  	
         assertTrue(q2.isFull());	  	
     }
	
	

}
