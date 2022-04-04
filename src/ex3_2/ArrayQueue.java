package ex3_2;

import java.util.Collection;
import java.util.Collections;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements QueueADT<E>{
	
	private final int INITIAL_CAPACITY = 5;
	private int numElements;
	private E[] elements;
	private int head;
	private int tail;
	
	public ArrayQueue() {
		super();
		numElements =0;
		elements = (E[])(new Object[INITIAL_CAPACITY]);
		head=0;
		tail=0;
		
	}
	
	public ArrayQueue(Collection<? extends E> c) {
		this();
		for(E element :c) {
			enqueue(element);
		}
		
	}
	

	@Override
	public void enqueue(E element) {
		// TODO Auto-generated method stub
		if(numElements >= elements.length) {
			expandCapcity();
			if(tail>=elements.length) {
				tail=0;
			}
			elements[tail]=element;
			numElements++;
			tail++;
			
		}
		
		
		
	}

	private void expandCapcity() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E dequeue() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(numElements==0) {
			System.out.println("empty queue");
			return null;
		}
		else {
			numElements--;
			E found = elements[(head%INITIAL_CAPACITY)];
			head++;
			return found;
			
		}
		//return null;
	}

	@Override
	public E first() throws NoSuchElementException {
		// TODO Auto-generated method stub
		//E front =  
		//return front;
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (numElements==0);
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numElements;
	}
	
	
}
