package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.List;
import edu.isu.cs.cs3308.structures.Node;

/**
 * A class to implement a singly linked list
 *
 * @author Dylan Lasher
 * @param <E> any list type
 */
public class SinglyLinkedList<E> implements List<E>
{

	// Head node for List
	protected Node<E> head = null;

	// Tail node for List
	protected Node<E> tail = null;

	// Temporary node
	protected Node<E> tempNode = null;

	// Count of nodes in List
	protected int size = 0;

	/**
	 * Checks if given element is null
	 * @param element to check
	 * @return true if not null, false if null
	 */
	protected boolean checkElement(E element)
	{
		return element != null;
	}

	/**
	 * Checks if given index is within 0 or greater
	 * @param index to check
	 * @return true if valid index, false if invalid
	 */
	protected boolean checkIndex(int index) {
		return index < size && index >= 0;
	}

	protected void verifyList()
	{

		// if only one node in the list
		if (size == 1)
		{
			if (head != null)
			{
				tail = head;
			}
			else {
				head = tail;
			}
		}
		if (size == 0)
		{
			head = null;
			tail = null;
		}
		if (size > 0)
		{
			verifyBoundary();
		}
	}

	/**
	 * Set Node values for add action
	 * @param dataToAdd for node
	 * @param atIndex to add node
	 */
	protected void nodeSetAdd(E dataToAdd, int atIndex)
	{

		// Create node to add
		Node<E> addNode = new Node<>(dataToAdd);

		if (atIndex == 0)
		{

			// if more than one node in list
			if (size > 0)
			{
				// make next of new node to original head
				addNode.setNext(head);
			}

			// change head to new node
			head = addNode;
		}

		else if (atIndex >= size)
		{
			tail.setNext(addNode);
			tail = addNode;
		}

		// else insert Node at index
		else {
			Node<E> prevNode = getNode(atIndex-1);
			addNode.setNext(prevNode.getNext());
			prevNode.setNext(addNode);
		}
		addSize();
		verifyList();
	}

	/**
	 * Set Node values for remove action
	 * @param atIndex of node to remove
	 * @return data in the node
	 */
	protected E nodeSetRemove(int atIndex) {
		Node<E> removeNode = null;

		// if removing first Node
		if (atIndex == 0) {
			removeNode = head;

			// if at least two nodes in list
			if (size > 1) {
				// set new head to next of original
				head = removeNode.getNext();
			}
		}
		else {
			Node<E> prevNode = getNode(atIndex-1);
			removeNode = prevNode.getNext();
			prevNode.setNext(removeNode.getNext());

			if (atIndex >= size-1)
			{
				tail = prevNode;
			}
		}

		removeNode.setNext(null);
		subSize();
		verifyList();

		return removeNode.getData();
	}

	/**
	 * Get node from list, given index
	 * @param index in list
	 * @return node retrieved from list
	 */
	protected Node<E> getNode(int index)
	{
		// get current head node
		Node<E> seekNode = head;

		// seek through list
		for (int i = 0; i < index; i++)
		{
			seekNode = seekNode.getNext();
		}

		// return Node from list
		return seekNode;
	}

	/**
	 * Adds 1 to size
	 */
	protected void addSize() {
		size++;
	}

	/**
	 * Subtracts 1 from the size
	 */
	protected void subSize()
	{
		size--;

		if (size < 0)
		{
			size = 0;
		}
	}

	protected void verifyBoundary() {
		tail.setNext(null);
	}

	@Override
	public E first() {
		return (head != null) ? head.getData() : null;
	}

	@Override
	public E last() {
		return (tail != null) ? tail.getData() : null;
	}

	@Override
	public void addLast(E element)
	{
		if (checkElement(element))
		{
			if (!isEmpty())
			{
				nodeSetAdd(element,size);
			}
			else {
				addFirst(element);
			}
		}
	}

	@Override
	public void addFirst(E element)
	{
		if (checkElement(element))
		{
			nodeSetAdd(element, 0);
		}
	}

	@Override
	public E removeFirst()
	{
		if (head != null)
		{
			return nodeSetRemove(0);
		}
		else {
			return null;
		}
	}

	@Override
	public E removeLast()
	{
		if (size > 1)
		{
			return remove(size - 1);
		}
		else {
			return removeFirst();
		}
	}

	@Override
	public void insert(E element, int index)
	{
		if (checkElement(element))
		{
			if (index >= 0)
			{
				if (index == 0)
				{
					addFirst(element);
				}
				else if (index >= size)
				{
					addLast(element);
				}
				else {
					nodeSetAdd(element, index);
				}
			}
		}
	}

	/**
	 * Remove node from list based on index
	 * @param index of node in list
	 * @return data stored in node
	 */
	@Override
	public E remove(int index)
	{
		if (checkIndex(index))
		{
			if (index == 0)
			{
				return removeFirst();
			}
			else {
				return nodeSetRemove(index);
			}
		}
		else {
			return null;
		}
	}

	/**
	 * Get data in node from list at index
	 * @param index of node in list
	 * @return data stored in node
	 */
	@Override
	public E get(int index)
	{
		if (checkIndex(index))
		{
			if (index == 0)
			{
				return head.getData();
			}
			else if (index == size-1)
			{
				return tail.getData();
			}
			else {
				return getNode(index).getData();
			}
		}
		else {
			return null;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void printList()
	{
		if (!isEmpty())
		{
			tempNode = head;
			for (int i = 0; i < size; i++)
			{
				if (i < size-1)
				{
					System.out.print(tempNode.getData() + "\n");
				}
				else {
					System.out.println(tempNode.getData());
				}
				tempNode = tempNode.getNext();
			}
		}
		else {
			System.out.println("There is nothing in this list.");
		}
		tempNode = null;
	}

	/**
	 * Find given item in list, return -1 if not found
	 * @param item to find in list
	 * @return index of found item
	 */
	public int indexOf(E item)
	{
		if (!isEmpty() && item != null)
		{
			if (head.getData() == item)
			{
				return 0;
			}
			else if (tail.getData() == item)
			{
				return size-1;
			}
			else {
				tempNode = head;
				for (int i = 0; i < size; i++)
				{
					if (tempNode.getData() == item)
					{
						return i;
					}
					tempNode = tempNode.getNext();
				}
			}
		}
		tempNode = null;

		return -1;
	}
}
