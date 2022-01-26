package textgen;

//import org.reactfx.util.LL;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element == null){
			throw new NullPointerException();
		}
		LLNode<E> lastNode = new LLNode<>(element);
		if (this.size == 0){
			head = tail = lastNode;
		} else {
			tail.next = lastNode;
			lastNode.prev = tail;
			tail = lastNode;
			lastNode.next = null;
		}
		this.size += 1;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index < 0 || index >=size){
			throw new IndexOutOfBoundsException();
		}
		int check;
		LLNode<E> current;
		if (index < size/2){
			check = 0;
			current = head;
			while (check != index){
				current = current.next;
				check++;
			}
		} else {
			check = size - 1;
			current = tail;
			while (check != index){
				current = current.prev;
				check--;
			}
		}
		return current.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param index index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		LLNode<E> addNode = new LLNode<>(element);
		if (size == 0){
			head = tail = addNode;
		}
		if (index < 0 || index > size){
			throw new IndexOutOfBoundsException();
		}
		if (element == null){
			throw new NullPointerException();
		}
		int check;
		LLNode<E> current;
		if (index == 0){
			addNode.next = head;
			addNode.prev = null;
			head = addNode;
		} else if (index == size - 1){
			add(element);
		} else {
			if (index < size/2){
				check = 1;
				current = head.next;
				while (check != index){
					current = current.next;
					check++;
				}
			} else {
				check = size - 2;
				current = tail.prev;
				while (check!= index){
					current=current.prev;
					check--;
				}
			}
			current.prev.next = addNode;
			addNode.prev = current.prev;
			current.prev = addNode;
			addNode.next = current;
		}
		size+=1;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}
		int check;
		E data;
		LLNode<E> current;
		if (index == 0){
			current = head;
			data = current.data;
			head = current.next;
		} else if (index == (size-1)){
			current = tail;
			data = current.data;
			tail.prev.next = null;
			tail = tail.prev;
		} else {
			if (index < size/2){
				check = 1;
				current = head.next;
				while (check != index){
					current = current.next;
					check++;
				}
			} else {
				check = size - 2;
				current = tail.prev;
				while (check != index){
					current = current.prev;
					check--;
				}
			}
			data = current.data;
			current.next.prev = current.prev;
			current.prev.next = current.next;
			current.prev = null;
			current.next = null;
		}
		size-=1;
		return data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (element == null){
			throw new NullPointerException();
		}
		if (index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}
		E oldData;
		LLNode<E> current;
		int check;
		if (index < size/2){
			check = 0;
			current = head;
			while (check != index){
				current = current.next;
				check++;
			}
		} else {
			check = size - 1;
			current = tail;
			while (check != index){
				current = current.prev;
				check--;
			}
		}
		oldData = current.data;
		current.data = element;
		return oldData;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
