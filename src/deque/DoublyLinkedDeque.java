package deque;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DoublyLinkedDeque<E extends Comparable> implements DequeADT<E>{
	
	private Node<E> firstNode;
	private Node<E> lastNode;
	private int numElements;
	
	public DoublyLinkedDeque() {
		numElements = 0;
		firstNode = null;
		 lastNode = null;
	}
	
	@Override
	public void enqueueRear(E element) {
		// TODO Auto-generated method stub
		Node<E> newNode= new Node(element);
		if(newNode==null) {
			System.out.println("Overflow");
		}
		else 
		
	}

	@Override
	public void enqueueFront(E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E dequeueRear() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E dequeueFront() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E first() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E last() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		
		return size();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head = tail =0;
		
		
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
