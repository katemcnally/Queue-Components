package bddqueue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class _AbstractQueueTest {
	
	AbstractQueue<Object> q = new CircArrayQueue<>(20);
	AbstractQueue<Object> q2 = new ListQueue<>(10);
	AbstractQueue<Object> q3 = new CircArrayQueue<>(5);
	AbstractQueue<Object> q4 = new ListQueue<>(10);
	AbstractQueue<Object> q5 = new CircArrayQueue<>(5);

	@Before
	public void setUp() throws Exception {
		  q.enqueue("Hello");
	      q.enqueue("Shaked");	
	      q.enqueue("Kate");	
	      q.enqueue("Audrey");	
	      q2.enqueue(1);	
	      q2.enqueue(2);  	
	      q2.enqueue(3);
	      q3.enqueue(2);
	}

	@Test
	public void Capacitytest() {
		assertEquals(q.capacity, 20);
	}
	
	 @Test  	
     public void isEmptyTest(){  	
         assertFalse(q2.isEmpty());	
         q2.clear();  	
         assertTrue(q2.isEmpty()); 	
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
	 
	 @Test	  	
     public void toStringTest(){	  	
         System.out.println(q.toString());	  	
         assertEquals(q.toString(), "(Hello, Shaked, Kate, Audrey)20");	  	
         System.out.println(q2.toString());	  	
         assertEquals(q2.toString(), "[123, ]:10");	  	
     }
	 
	 @Test(expected = NullPointerException.class)
	 public void AppendTestNullPointerException(){
		 q.append(q2);
		 assertEquals(q.length(), 7);
		 q3.append(q4);
	 }
	 
	 @Test
	 public void AppendTest(){
		 q.append(q3);
	 }
	 
	 @Test(expected = IllegalStateException.class)
	 public void AppendTestIllegalStateException(){
		 //sum greater than capacity
		 q3.append(q);
	 }
	 
	 @Test
	 public void CopyTest(){
		 Queue<Object> q = q2.copy();
		 assertEquals(q, q2);
		 
	 }
	 
	 @Test
	 public void HashCodeTest(){
		 q2.hashCode();
		 assertEquals(q2.hashCode(), 37954760);
	 }
	
	 @Test
	 public void equalsTest(){
		 assertTrue(q.equals(q));
		 assertFalse(q.equals(null));
		 assertFalse(q.equals(q2.capacity()));
		 assertFalse(q.equals(q2.length()));
	 }
}
