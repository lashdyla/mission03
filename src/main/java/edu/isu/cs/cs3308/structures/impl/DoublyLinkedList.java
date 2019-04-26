package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.NodeDouble;

/**
 * @author Dylan Lasher
 * @param <E> any type of list

 */
public class DoublyLinkedList<E> extends SinglyLinkedList<E>
{

	// Head node for List
	protected NodeDouble<E> head = null;

	// Tail node for List
	protected NodeDouble<E> tail = null;

	// Temporary node
	protected NodeDouble<E> tempNode = null;

	@Override
	protected void nodeSetAdd(E dataToAdd, int atIndex)
	{
		// Create node to add
		NodeDouble<E> addNode = new NodeDouble<>(dataToAdd);

		if (atIndex == 0)
		{
			if (size > 0)
			{
				addNode.setNext(head);
				((NodeDouble<E>) head).setPrev(addNode);
			}
			head = addNode;
		}

		else if (atIndex >= size)
		{
			tail.setNext(addNode);
			addNode.setPrev((NodeDouble<E>) tail);
			tail = addNode;
		}
		else {
			NodeDouble<E> prevNode = getNode(atIndex-1);
			addNode.setNext(prevNode.getNext());
			addNode.setPrev(prevNode);
			((NodeDouble<E>) addNode.getNext()).setPrev(addNode);
			prevNode.setNext(addNode);
		}

		// increment size
		addSize();

		verifyList();
	}

	@Override
	protected E nodeSetRemove(int atIndex)
	{
		NodeDouble<E> removeNode = null;

		// if removing first Node
		if (atIndex == 0)
		{
			removeNode = (NodeDouble<E>) head;

			// if there are at least two nodes in list
			if (size > 1) {
				// set the new head to next of original
				head = (NodeDouble<E>) removeNode.getNext();
			}
		}

		// else if removing last Node
		else if (atIndex >= size - 1) {
			// get the node before the one to be removed
			NodeDouble<E> prevNode = ((NodeDouble<E>) tail).getPrev();

			// get to-be-removed node
			removeNode = (NodeDouble<E>) tail;

			tail = prevNode;
		}

		else {
			NodeDouble<E> prevNode = getNode(atIndex-1);
			removeNode = (NodeDouble<E>) prevNode.getNext();
			((NodeDouble<E>) removeNode.getNext()).setPrev(prevNode);
			prevNode.setNext(removeNode.getNext());
		}
		removeNode.setPrev(null);
		removeNode.setNext(null);
		subSize();
		verifyList();

		return removeNode.getData();
	}

	@Override
	protected NodeDouble<E> getNode(int index) {
		NodeDouble<E> seekNode;

		// if first half of list, use next
		if (index <= size/2) {
			// get current head node to start from
			seekNode = (NodeDouble<E>) head;

			// seek through list starting from head
			for (int i = 0; i < index; i++) {
				seekNode = (NodeDouble<E>) seekNode.getNext();
			}
		}
		// else in second half of list, use previous
		else {
			// get current tail node to start from
			seekNode = (NodeDouble<E>) tail;

			// seek through list starting from head
			for (int i = size-1; i > index; i--) {
				seekNode = seekNode.getPrev();
			}
		}

		return seekNode;
	}

	@Override
	protected void verifyBoundary() {
		((NodeDouble<E>) head).setPrev(null);
		tail.setNext(null);
	}
}
