package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Stack;

/**
 * Linked stack based on Stack
 *
 * @author Dylan Lasher
 * @param <E> any stack type
 */
public class LinkedStack<E> implements Stack<E> {

	// create our DLL for stack
	DoublyLinkedList<E> theList = new DoublyLinkedList<>();

	/**
	 * Add new element onto stack beginning
	 * @param element data to add to top, unless null
	 */
	@Override
	public void push(E element) {
		theList.addFirst(element);
	}

	/**
	 * See value at beginning without removing it
	 * @return value at beginning of stack
	 */
	@Override
	public E peek() {
		return theList.first();
	}

	/**
	 * Remove the value at the beginning of the stack
	 * @return The value at beginning of stack
	 */
	@Override
	public E pop() {
		return theList.removeFirst();
	}

	/**
	 * Get number of stack elements
	 * @return Number of stack elements
	 */
	@Override
	public int size() {
		return theList.size();
	}

	/**
	 * Determine if stack list is empty
	 * @return True if stack is empty, else is false
	 */
	@Override
	public boolean isEmpty() {
		return theList.isEmpty();
	}

	/**
	 * Transfer all data from one stack to another,
	 * @param to stack to transfer
	 */
	@Override
	public void transfer(Stack<E> to) {
		// if stack is not null/empty
		if (to != null && this.size() > 0) {
			// loop all elements
			while(this.size() > 0) {
				to.push(this.pop());
			}
		}
	}

	/**
	 *Reverse order of stack elements
	 */
	@Override
	public void reverse() {
		// create 2 temporary stacks
		LinkedStack<E> temp1 = new LinkedStack<>();
		LinkedStack<E> temp2 = new LinkedStack<>();

		this.transfer(temp1);
		temp1.transfer(temp2);
		temp2.transfer(this);
	}

	/**
	 * Copy other stack end of stack.
	 * @param other stack
	 * */
	@Override
	public void merge(Stack<E> other) {
		if (other != null) {
			// temporary stacks
			LinkedStack<E> origCopy = new LinkedStack<>();
			LinkedStack<E> otherCopy = new LinkedStack<>();

			this.transfer(origCopy);
			other.transfer(otherCopy);
			while (otherCopy.size() > 0) {
				// get element to merge
				E tempElem = otherCopy.pop();

				// push element to each stack
				other.push(tempElem);
				this.push(tempElem);
			}
			origCopy.transfer(this);
		}
	}

	/**
	 * Prints stack contents
	 */
	@Override
	public void printStack() {
		theList.printList();
	}
}
