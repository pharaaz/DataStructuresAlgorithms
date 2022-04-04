package ex3_4;

import java.util.List;
import java.util.ListIterator;

public class BinarySearchList<E extends Comparable> {
	
	private final List<E> elements;
	
	public BinarySearchList(List<E> elements) {
		this.elements=elements;
	}
	
	public int search(E target) {
		if(target == null) {
			throw new NullPointerException("search target is null");
		}
			ListIterator<E> iterator = elements.listIterator();
			return search(target, 0, elements.size(), iterator);
		
	}
	
	private int search(E target, int start, int end, ListIterator<E> iterator) {
		if(start>=end) {
			return -start-1;
		}
		else
	      { 
			int midpoint = (start+end)/2; 
			
			if(midpoint >iterator.nextIndex()) {
				for(int i = iterator.nextIndex();i<midpoint;i++) {
					
				}
			}
			
			//return search(target, midpoint+1, end);
	      
	      }
		return end;
		
	}

}
