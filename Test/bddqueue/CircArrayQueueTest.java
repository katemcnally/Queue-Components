package bddqueue;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class CircArrayQueueTest {

	CircArrayQueue<Object> q = new CircArrayQueue<>(20); 	
	CircArrayQueue<Object> q2 = new CircArrayQueue<>(10);
	CircArrayQueue<Object> q3 = new CircArrayQueue<>(10);
		  	
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
	 	
	     @Test(expected = IllegalArgumentException.class) 	
	     public void ArraySizeTest(){
	     CircArrayQueue<Object> q = new CircArrayQueue<>(-1);	
	     }
		
	     @Test(expected = IllegalArgumentException.class) 	
	     public void ArraySizeTest2(){	
	         CircArrayQueue<Object> q = new CircArrayQueue<>(0);
	     }
	 	
	     @Test	
	     public void CapacityTest(){ 	
	         assertNotEquals(q.capacity(), 0); 	
	     }
	  	
	     @Test 	
	     public void ClearTest(){	
	         q2.clear();  	
	         assertEquals(q2.length(), 0);	
	     }
	  	
	     @Test 	
	     public void DequeueTest(){
	         q.dequeue(); 	
	         assertEquals(q.length(), 3); 	
	     }
	  	
	     @Test(expected = IllegalStateException.class) 	
	     public void DequeueTestThrow(){  	
	         q2.clear(); 	
	         q2.dequeue();  	
	     }
	  	
	     @Test	
	     public void EnqueueTest(){ 	
	         q.enqueue("Mattie");
	         assertEquals(q.length(), 5);	
	         assertNotEquals(q.length(), q.capacity());	
	     }  	
	      	
	     @Test(expected = IllegalStateException.class) 	
	     public void EnqueueTestThrow(){	
	         q2.enqueue(4); 	
	         q2.enqueue(5);	
	         q2.enqueue(6); 	
	         q2.enqueue(7);  	
	         q2.enqueue(8);	
	         q2.enqueue(9); 	
	         q2.enqueue(10);  	
	         q2.enqueue(11);
	     }
	 	
	     @Test(expected = NullPointerException.class) 	
	     public void Enqueue2TestThrow(){	  	
	         q2.enqueue(null);  	
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
		  	
	     @Test	  	
	     public void LengthTest(){	  	
	         assertEquals(q.length(), 4);  	
	     }
		  	
	     @Test	  	
	     public void toStringTest(){	  	
	         System.out.println(q.toString());	  	
	         assertEquals(q.toString(), "(Hello, Shaked, Kate, Audrey)20");	  	
	         System.out.println(q2.toString());	  	
	         assertEquals(q2.toString(), "(1, 2, 3)10");	  	
	     }
	     
	     @Test
	     public void isValidTest(){
	    	 assertTrue(q2.isValid());
	     }
	     
	     @Test
	     public void newInstanceTest(){
	    	 assertEquals(q2.capacity(), q2.newInstance().capacity());
	     }
	     
	     @Test
	     public void IteratorTest(){
	    	 assertTrue(q2.iterator().hasNext());
	    	 q3.enqueue(3);
	    	 assertEquals(q3.iterator().next(), 3);
	     }
	     
	     @Test(expected = NoSuchElementException.class)
	     public void IteratorTextException(){
	    	 q3.enqueue(3);
	    	 System.out.println(q3.iterator().hasNext());
	    	 //assertNotEquals(q3.iterator().hasNext());
	     }
		  	
	 }