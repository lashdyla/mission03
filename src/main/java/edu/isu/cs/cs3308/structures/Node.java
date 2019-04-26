package edu.isu.cs.cs3308.structures;

/**
 * Node class for list functionality
 *
 * @author Dylan Lasher
 * @param <E> any node type
 */
public class Node<E>
{

	// Data stored in node.
	protected E data;

	// Store next node
	protected Node<E> next;

	/**
	 * Constructor with data parameter
	 * @param data Node stores
	 */
	public Node(E data) {
		this.data = data;
	}

	/**
	 * Get data stored in Node
	 * @return data that node stores
	 */
	public E getData() {
		return data;
	}

	/**
	 * Set data to be stored in Node
	 * @param data node should store
	 */
	public void setData(E data) {
		this.data = data;
	}

	/**
	 * Get Node stored as next in List.
	 * @return Node that is currently stored in next attribute
	 */
	public Node<E> getNext() {
		return next;
	}

	/**
	 * Set Node to be stored as next in List.
	 * @param next
	 */
	public void setNext(Node<E> next) {
		this.next = next;
	}
}
