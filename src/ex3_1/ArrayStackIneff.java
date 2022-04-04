package ex3_1;

import java.util.Collection;
import java.util.NoSuchElementException;

public class ArrayStackIneff<E> implements StackADT<E>  {
	
	private final int INITIAL_CAPACITY = 20;
	private E[] elements;
	private int numElements;
	
	public ArrayStackIneff() {
		super();
		elements = (E[])(new Object [10]);
		numElements =0;
	}
  
	public ArrayStackIneff(Collection<? extends E> c) {
		this();
		for (E element : c) {
			push(element);
		}
		
	}
  
	@Override
	public void push(E element) {
		// TODO Auto-generated method stub
		 if (numElements >= elements.length) {
			 for(int i= numElements;i>0;i--) {
					elements[i]=elements[i-1];
				}
				
				elements[0] = element;
				numElements++;
		 }
		
	}

	@Override
	public E pop() throws NoSuchElementException {
		// TODO Auto-generated method stubn
		if (numElements > 0)
	      {  E topElement = elements[numElements-1];
	         elements[numElements-1] = null;
	         numElements--;
	         return topElement;
	      }
	      else
	         throw new NoSuchElementException();
	}

	@Override
	public E peek() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (numElements > 0)
	         return elements[numElements-1];
	      else
	         throw new NoSuchElementException();
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
	
	@Override
	public String toString()
	   {  String output = "[";
	      for (int i=0; i<numElements; i++)
	      {  output += elements[i];
	         if (i<numElements-1)
	            output += ",";
	      }
	      output += "]";
	      return output;
	   }
	
	public static void main(String[] args) {
		/*
		StackADT<String> stackbad = new ArrayStackIneff<>();
		stackbad.push("hello");
		System.out.println(stackbad);
		stackbad.push("world");
		stackbad.push("how");
		stackbad.push("are");
		stackbad.push("you");
		System.out.println(stackbad);
		*/
		
		int numElements =10000;
		StackADT<Integer> stackGood = new ArrayStack<Integer>();
		System.out.println("Pushing on " +numElements +" onto normal stack");
		long begin = System.currentTimeMillis();
		
		for(int i =0; i<numElements; i++) {
			stackGood.push(i);
		}
		
		System.out.println("Now pop all values from the good stack- LIFO");
		
		while(!stackGood.isEmpty()) {
			int ele = stackGood.pop();
		}
		
		System.out.print("\nProperly implemented stack took this much time ");
		System.out.print((System.currentTimeMillis()-begin) +" milliseconds");
		System.out.flush();
		
		StackADT<Integer> stackBad = new ArrayStackIneff<Integer>();
		
		System.out.println("Pushing on " +numElements +" Onto inefficient Stack ");
		begin = System.currentTimeMillis();
		for(int i =0; i<numElements;i++) {
			stackBad.push(i);
		}
		
		System.out.println("Now polling All Values from bad stack = LIFO");
		
		while(!stackBad.isEmpty()) {
			int ele = stackBad.pop();
			
		}
		
		System.out.println("\nIneff took " +(System.currentTimeMillis()-begin) +" milliseconds");



		
	}

}