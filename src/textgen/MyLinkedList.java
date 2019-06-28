package textgen;

import java.util.AbstractList;

/**
 * A class that implements a doubly linked list
 *
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E>
 *            The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * 
	 * @param element
	 *            The element to add
	 */
	public boolean add(E element) {
		if (element == null) {
			throw new NullPointerException("cannot add null as element");
		}

		LLNode<E> newNode = new LLNode<E>(element);
		LLNode<E> prev = tail.prev;
		prev.next = newNode;
		newNode.prev = prev;
		newNode.next = tail;
		tail.prev = newNode;
		size++;
		// TODO: Implement this method
		return false;
	}

	/**
	 * Get the element at position index
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of bounds.
	 */
	public E get(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException("Cannot get index less than 0");
		}

		if (index >= size) {
			throw new IndexOutOfBoundsException("Index bigger than array size");
		}

		if (size == 0) {
			throw new IndexOutOfBoundsException("Size of list cannot be 0");
		}

		LLNode<E> currentIndex = head.next;
		// TODO: Implement this method.
		for (int i = 0; i < index; i++) {
			if (currentIndex.next == null) {
				throw new IndexOutOfBoundsException("Out of Bounds");
			}
			currentIndex = currentIndex.next;

		}

		return currentIndex.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * 
	 * @param The
	 *            index where the element should be added
	 * @param element
	 *            The element to add
	 */
	public void add(int index, E element) {
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("Cannot add element null");
		}
		if (index < 0) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		if (index > size) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}

		LLNode<E> newNode = new LLNode<E>(element);
		LLNode<E> current = head;
		for (int i = 0; i <= index; i++) {
			current = current.next;
		}
		LLNode<E> prev = current.prev;
		prev.next = newNode;
		newNode.prev = prev;
		newNode.next = current;
		current.prev = newNode;
		size++;
	}

	/** Return the size of the list */
	public int size() {
		// TODO: Implement this method
		return size;
	}

	/**
	 * Remove a node at the specified index and return its data element.
	 * 
	 * @param index
	 *            The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException
	 *             If index is outside the bounds of the list
	 *
	 */
	public E remove(int index) {
		// TODO: Implement this method
		LLNode<E> currentIndex = head;

		if (index < 0) {
			throw new IndexOutOfBoundsException("Index out of Bounds");
		}

		if (index >= size) {
			throw new IndexOutOfBoundsException("Index out of Bounds");
		}

		for (int i = 0; i <= index; i++) {
			currentIndex = currentIndex.next;
		}
		currentIndex.prev.next = currentIndex.next;
		currentIndex.next.prev = currentIndex.prev;
		size -= 1;
		return currentIndex.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * 
	 * @param index
	 *            The index of the element to change
	 * @param element
	 *            The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of bounds.
	 */
	public E set(int index, E element) {
		// TODO: Implement this method
		// TODO: Implement this method / done
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		if (index > size) {
			throw new IndexOutOfBoundsException("Index out of Bounds");
		}
		if (index < 0) {
			throw new IndexOutOfBoundsException("Index out of Bounds");
		}
		LLNode<E> current = head;
		for (int i = 0; i < index; i++) {
			if (current.next == null) {
				return null;
			}
			current = current.next;
		}
		E originalData = current.next.data;
		current.next.data = element;
		return originalData;
	}
}

class LLNode<E> {
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) {
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
