package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Queue;

/**
 * A linked queue based on Queue
 *
 * @author Dylan Lasher
 * @param <E> any queue type
 */
public class LinkedQueue<E> implements Queue<E> {

	// create DLL to use for the stack
	protected DoublyLinkedList<E> theList = new DoublyLinkedList<>();

	/**
	 * Add new element onto queue at end
	 * @param element data to add to end, unless null
	 */
	@Override
	public void offer(E element) {
		theList.addLast(element);
	}

	/**
	 * Remove value at beginning of queue
	 * @return The value at the beginning of the queue
	 */
	@Override
	public E poll() {
		return theList.removeFirst();
	}

	/**
	 * See value at beginning without removing it
	 * @return value at beginning of queue
	 */
	@Override
	public E peek() {
		return theList.first();
	}

	/**
	 * Get number of elements in queue
	 * @return number of elements in queue
	 */
	@Override
	public int size() {
		return theList.size();
	}

	/**
	 * Determine if queue is empty
	 * @return True if empty queue, else is false
	 */
	@Override
	public boolean isEmpty() {
		return theList.isEmpty();
	}

	/**
	 * Transfer all data from one queue to another,
	 * also reversing element order
	 * @param to queue to transfer to unless null
	 */
	@Override
	public void transfer(Queue<E> to) {
		// if stack is not null/empty
		if (to != null && this.size() > 0) {
			// temporary linked stack for reversal
			LinkedStack<E> tempLinkStack = new LinkedStack<>();

			// loop through all elements
			while(this.size() > 0) {
				tempLinkStack.push(this.poll());
			}

			// loop until all elements transferred
			while(tempLinkStack.size() > 0) {
				to.offer(tempLinkStack.pop());
			}
		}
	}

	/**
	 *Reverse order of elements
	 */
	@Override
	public void reverse() {
		// create 2 temporary stacks
		LinkedQueue<E> temp1 = new LinkedQueue<>();
		LinkedQueue<E> temp2 = new LinkedQueue<>();

		this.transfer(temp1);
		temp1.transfer(temp2);
		temp2.transfer(this);

	}

	/**
	 * Copy other queue to end of this queue.
	 * @param other queue whose contents are to be merged
	 */
	@Override
	public void merge(Queue<E> other) {
		if (other != null) {
			// size of other list to merge
			int listSize = other.size();

			// loop until all elements are transferred
			for(int i = 0; i < listSize; i++) {
				E tempElement = other.poll();

				other.offer(tempElement);
				this.offer(tempElement);
			}
		}
	}

	/**
	 * Prints out the content of the queue list
	 */
	@Override
	public void printQueue() {
		theList.printList();
	}
}
