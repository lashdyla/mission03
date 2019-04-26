package edu.isu.cs.cs3308.structures;

/**
 * Node class needed for Double List
 *
 * @author Dylan Lasher
 * @param <E>
 */
public class NodeDouble<E> extends Node<E>{

	// Stores prev node
	private NodeDouble<E> prev;

	/**
	 * Constructor with data parameter
	 * @param data Node stores
	 */
	public NodeDouble(E data) {
		super(data);
	}

	/**
	 * Get Node stored as previous in List.
	 * @return Node currently stored in prev
	 */
	public NodeDouble<E> getPrev() {
		return prev;
	}

	/**
	 * Set Node as the prev in List.
	 * @param prev Node to current Node
	 */
	public void setPrev(NodeDouble<E> prev) {
		this.prev = prev;
	}
}
