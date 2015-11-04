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
		assertEquals(q.capacity(), 20);
	}

}
