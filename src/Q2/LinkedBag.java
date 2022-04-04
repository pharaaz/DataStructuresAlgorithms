/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

import java.util.Iterator;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Owner
 */
public class LinkedBag<E> implements Bag<E>  {
    
    int elements;
    Node<E> firstNode;
    
    public LinkedBag()
   {  super();
      elements = 0;
      firstNode = null;
   }
    
    private class Node<E>{  	
        public E elementy;  	
        public Node<E> next;	
        public Node<E> prev;
        
        public Node(E element){
            
		this.elementy = element;		
                next = null;		
                prev = null; 	}
}


    @Override
    public boolean add(E item) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
        if (!(contains(item)))
      {  Node<E> newNode = new Node<E>(item);
         
         newNode.next = firstNode;
         firstNode = newNode;
         elements++;
         return true;
      }
      else
         return false;
    }
    
     public boolean contains(E target){  
         
         Node<E> current = firstNode;
         boolean found = false;
         while(current != null && !found){  
         if(current.elementy.equals(target)){	  
             found = true;      
         }
         
         
         
         else{	  
             current = current.next;
       }
    }    
         
         return found;
}


    @Override
    public E grab() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Object o)
   {  
      boolean found = false;
      if (firstNode!=null)
      {  // check if the element is first in list
         if ((firstNode.elementy==null && o==null) ||
            (firstNode.elementy!=null && firstNode.elementy.equals(o)))
         {  found = true;
            firstNode = firstNode.next;
            elements--;
         }
         else
         {  // check the other nodes in the list
            Node<E> previous = firstNode;
            Node<E> current = firstNode.next;
            while (current!=null && !found)
            {  if ((current.elementy==null && o==null) ||
                  (current.elementy!=null && current.elementy.equals(o)))
               {  found = true;
                  previous.next = current.next;
                  elements--;
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
    public int size() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        return elements;
    
    }

    @Override
    public int capacityRemaining() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
        if(elements>0){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public void clear() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        firstNode=null;
        elements=0;
        
    }

    @Override
    public Iterator<E> iterator() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
         return new LinkedIterator<E>(firstNode);
    }
    
    
    
    private class LinkedIterator<E> implements Iterator<E>
   {
      private Node<E> nextNode; // next node to use for the iterator
      
      public LinkedIterator(Node<E> firstNode)
      {  nextNode = firstNode; // start with first node in list
      }
      
      
      public boolean hasNext()
      {  return (nextNode!=null);
      }
   
      public E next() throws NoSuchElementException
      {  if (!hasNext())
            throw new NoSuchElementException();
         E element = nextNode.elementy;
         nextNode = nextNode.next;
         return element;
      }
      
      public void remove() throws UnsupportedOperationException
      {  throw new UnsupportedOperationException();
      }
   }

    @Override
    public E[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        
    }
    
}
