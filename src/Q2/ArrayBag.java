/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 *
 * @author Owner
 */
public class ArrayBag<E> implements Bag<E>  {
    
    private E[] arry;
    private int size=0;
    int n ;
    Random randy = new Random();
    
    public ArrayBag(int n){
        this.n=n;
        this.arry=(E[])new Object[n];
        size=0;
    }
    
    public ArrayBag(){
        this.n=10;
        this.arry=(E[])new Object[n];
        size=0;
    }
    
    public boolean contains(E x) {
		for(int i = 0; i<size;i++) {
			if(x.equals(arry[i])) {
				return true;
			}
		}
		
		return false;
	}

    @Override
    public boolean add(E item) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
         if(isFull()){
           throw new IllegalStateException();
        }
         else{
             if(!(contains(item))){
                  arry[size]=item;
		  size++;
                  
                  return true;
             }
             else{
                 return false;
             }
             
         }
        
                
    
    }

    @Override
    public E grab() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        int pick = randy.nextInt(size)+1;
        return arry[pick];
    
    }

    @Override
    public boolean remove(E item) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        
        int dex = 0; 
        boolean found = false; 
        
        for(int i =0; i<size&&!found;i++){
            if ((arry[i]==null && item==null)
            || (arry[i]!=null && arry[i].equals(item)))
         {  dex = i;
            found = true;
         }
      }
      if (found) 
      {  arry[dex] = arry[size-1];
         arry[size-1] = null; 
         size--;
      }
      return found;
    }

    @Override
    public int size() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
       return size;
    }

    @Override
    public int capacityRemaining() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        int remaindin = n -size;
        return remaindin;
    
    }

    @Override
    public boolean isFull() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
       if(size==n){
           return true;
       }else{
           return false;
       }
    
    }

    @Override
    public boolean isEmpty() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
        if(size>0){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public void clear() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
         for (int i=0; i<size; i++){
              arry[i]= null;
         }
        
      size = 0;
    }

    @Override
    public Iterator<E> iterator() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
//       return new ArrayIterator<E>(elements, numElements);
        Iterator<E> iterato= Arrays.asList(arry).iterator();
        return iterato;
    }

    @Override
    public E[] toArray() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    E[] secArray=arry;
        
        return secArray;
    
    }
    
     @Override
    public String toString(){
        
        System.out.print("[");
       
        for (int i =0; i<n;i++) {
            System.out.print(arry[i]+",");
            
        }

         //System.out.println(nums[9]);

        return "]\n";
    }
    
}
