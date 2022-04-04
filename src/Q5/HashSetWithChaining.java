package q3;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;


public class HashSetWithChaining<E> implements Set<E>{
	
	private Node<E>[] hashTable;
	
	private int numElements;
	private float LOAD_FACTOR;
	private int initialCap;
	
	public HashSetWithChaining(int capa, float loadFactor) {
		this.hashTable = new Node[capa];
		this.LOAD_FACTOR=loadFactor;
	}
	

	@Override
	public int size() {
		// TODO Auto-generated method stub
		 return numElements;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (numElements==0);
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		if (!(contains(e)))
		{  int hashCode = e.hashCode()%initialCap;
			if(hashCode <0) {
				hashCode*=(-1);
			}
			hashTable[2]=(HashSetWithChaining<E>.Node<E>) e;
			return true;
		}
		else
		return false;
	}

	@Override
	public boolean remove(Object o) {
		boolean found = false;
	      if (firstNode!=null)
	      {  
	         if ((firstNode.element==null && o==null) ||
	            (firstNode.element!=null && firstNode.element.equals(o)))
	         {  found = true;
	            firstNode = firstNode.next;
	            numElements--;
	         }
	         else
	         { 
	            Node<E> previous = firstNode;
	            Node<E> current = firstNode.next;
	            while (current!=null && !found)
	            {  if ((current.element==null && o==null) ||
	                  (current.element!=null && current.element.equals(o)))
	               {  found = true;
	                  previous.next = current.next;
	                  numElements--;
	               }
	               else
	               {  previous = current;
	                  current = current.next;
	               }
	            }
	         }
	      }
	      return found;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	 protected class Node<E>
	   {  
	      public E element;
	      public Node<E> next;
	      
	      public Node(E element)
	      {  this.element = element;
	         next = null;
	      }
	   }
	   

}
