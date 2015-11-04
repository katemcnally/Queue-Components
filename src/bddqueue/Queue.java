package bddqueue;

/**
 * A bounded first-in first-out sequence of non-null elements.
 * 
 * @param <E>
 *            the type of elements in this queue
 */
public interface Queue<E> extends Iterable<E> {

	// ==========================================================
	// Primary methods (implemented using instance variables)
	// ==========================================================

	/**
	 * Adds the specified element to the end of this queue.
	 * 
	 * @param element
	 *            element to be added to this queue
	 * @throws NullPointerException
	 *             if the specified element is null
	 * @throws IllegalStateException
	 *             if the queue is already at capacity
	 */
	public void enqueue(E element) throws NullPointerException, IllegalStateException;

	/**
	 * Removes and returns the element at the front of this queue.
	 * 
	 * @return element at the front of this queue
	 * @throws IllegalStateException
	 *             if the queue is empty
	 */
	public E dequeue() throws IllegalStateException;

	/**
	 * Returns the length of this queue.
	 * 
	 * @return the length of this queue
	 */
	public int length();

	/**
	 * Returns the maximum number of elements that are allowed in this queue.
	 * 
	 * @return the capacity of this queue
	 */
	public int capacity();

	/**
	 * Clears this queue. The queue becomes empty.
	 */
	public void clear();

	/**
	 * Returns true if the representation of this queue is in a valid state.
	 * 
	 * @return true if the representation of this queue is in a valid state
	 */
	public boolean isValid();

	/**
	 * Returns a new, empty queue object with the same capacity as this queue.
	 * 
	 * @return a new, empty queue object with the same capacity as this queue
	 */
	public Queue<E> newInstance();

	// ==========================================================
	// Secondary methods (implemented using primary methods)
	// ==========================================================

	/**
	 * Returns true if this queue is empty, false otherwise.
	 * 
	 * @return true if this queue is empty
	 */
	public boolean isEmpty();

	/**
	 * Returns true if this queue is full, false otherwise.
	 * 
	 * @return true if this queue is full
	 */
	public boolean isFull();

	/**
	 * Returns a shallow copy of this queue.
	 * 
	 * @return a shallow copy of this queue
	 */
	public Queue<E> copy();

	/**
	 * Removes the elements from the specified queue and appends them to this
	 * queue.
	 * 
	 * @param that
	 *            the queue from which the elements are appended
	 * @throws NullPointerException
	 *             if the specified queue is null
	 * @throws IllegalStateException
	 *             if the capacity of this queue is less than the sum of the
	 *             lengths of this queue and that queue
	 */
	public void append(Queue<E> that) throws NullPointerException, IllegalStateException;

}