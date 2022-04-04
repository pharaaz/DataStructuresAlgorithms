/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author pgx2172 17985055
 */
public class ArrayDeque<E> implements DequeADT<E> {
    
    int front; 
    private int rear;
    private E[] nums;
    private int size;
    
    
    public ArrayDeque(int size){
        this.front=this.rear=-1;
        this.size=size;
        this.nums = (E[]) new Object[size];
    }

    @Override
    public void enqueueRear(E element) {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
//        if(size==nums.length){
          if(isFull()){
           throw new IllegalStateException();
        }
        else if (isEmpty()){
            front++;
           
        }
      
           nums[++rear]=element;
       //size++;
       
    
    }

    @Override
    public E dequeueFront() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        
        E tempp = nums[front];
        if(front==rear){
            front=rear=-1;
        }else{
            front++;
            
        }
        
        return tempp;
        
        
    }

    @Override
    public E first() {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return nums[front];
    }

    @Override
    public E last() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        if(rear<0||isEmpty()){
             throw new NoSuchElementException();
        }
//        size--;
//       rear=size;
        return nums[rear];
        
    }

//    @Override
//    public void enqueueFront(E element) {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    
//        if(isFull()){
//            //throw new IllegalStateException();
//            System.out.println("Deque Overflow");
//            return ;
//        }
//      else if (isEmpty()){
//        for(int i = size; i>0;i--){
//            nums[i]=nums[i-1];
//        }
//      }
//        nums[0]=element;
//        size++;
//       
//    }

    @Override
        public void enqueueFront(E element) {
            if(isFull())
        {
            throw new IllegalStateException();
        }
        if(front==-1)
        {
            front=0;
            rear=0;
        }
        else if(front==0){
            front=size-1;
        }
        else{
            front--;
        }
        nums[front]=element;

        }
    
    
    @Override
    public E dequeueRear() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        
//        E savey = nums[size-1];
//        size--;
//        return savey;

           E tempp = nums[rear];
        if(front==rear){
            front=rear=-1;
        }else{
            rear++;
            
        }
        
        return tempp;
        
        
        
    }

    @Override
    public boolean isEmpty() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
       return front==-1;
    
    }

    @Override
    public int size() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        Iterator<E> iterato= Arrays.asList(nums).iterator();
        return iterato;
    }
    
    private boolean isFull(){
        return rear== nums.length-1;
    }
    
    
    
    @Override
    public String toString(){
        System.out.print("[");
        for (E num : nums) {
            System.out.print(num+",");
            
        }

         //System.out.println(nums[9]);

        return "]\n";
    }
    
    public void clear() {

                nums = (E[]) new Object[1];
                size = 0;

        }
    
    public static void main(String args[]){
    
        ArrayDeque<Character> deku= new  ArrayDeque<Character>(10);
        
        deku.enqueueFront('P');
        deku.enqueueRear('R');
        deku.enqueueFront('L');
        deku.enqueueFront('O');
        deku.enqueueRear('W');
        deku.enqueueFront('Z');
        deku.enqueueRear('N');
        deku.enqueueFront('F');
        deku.enqueueFront('G');
        deku.enqueueRear('H');
        
       Iterator<Character>iterato=deku.iterator();
       
       while(iterato.hasNext()){
           
           System.out.println(iterato.next());
       }
       
       System.out.println("\nThe Elements in the ArrayDeque: " );
        System.out.println(deku);
        
        System.out.println("Size of the ArrayDeque is: " +deku.size);
        System.out.println("\nFirst element in the front of deque is: " +deku.first());
//        deku.dequeueFront();
        System.out.println("Calling dequeFront removes the Front element: " +deku.dequeueFront() +"\nNew Front of deque: " +deku.first());
        
         System.out.println("\nFirst element in the rear of deque is: " +deku.last());
        //deku.dequeueRear();
        System.out.println("Calling dequeRear removes the Rear element: " +deku.dequeueRear());
        
        System.out.println("\nCalling deku.clear(); to clear arrayDeque: ");
        deku.clear();
        
        System.out.println("\nThe Elements in the ArrayDeque: " );
        System.out.println(deku);
        
        
       
}
    
    
    
}
