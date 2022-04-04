/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

import java.util.Iterator;

/**
 *
 * @author Owner
 */
public class Test {
    
    public static void main(String[] args)
	   { 
		 
		int n;
		 
		 System.out.println("Testing ArrayBag first: " );
		 n =10;
		 ArrayBag<Integer> onie = new ArrayBag<>(n);
                 
		 System.out.println("Havent added anything yet so calling .isEmpty should = true\nLets see: " +onie.isEmpty());
		 
                 System.out.println("\nAdding 10, 4, 9, 8 to bag");
                 onie.add(10);
                 onie.add(4);
                 onie.add(9);
                 onie.add(8);

		 System.out.println("Now isEmpty should = false. Lets see: " +onie.isEmpty());
		 System.out.println("Bag not full yet so isFull should be false, : " +onie.isFull());
                 
		 
                 System.out.println("Remove 4 from bag: " +onie.remove(4));
                 
	    System.out.println("Current ArrayBag: ");
		Iterator<Integer>iterato=onie.iterator();
       
              System.out.print("[");
                while(iterato.hasNext()){
           
           
                    System.out.print(iterato.next()+",");
       
                }
                  
		 System.out.print("]\n Using toString:\n");
                 System.out.println(onie);
		 
                 System.out.println("Size of bag: "+onie.size() +" Capacity remaining: " +onie.capacityRemaining());
                 
		System.out.print("Clearing bag: ");
                onie.clear();
                 System.out.println(onie);
                 
                 System.out.println("\nAdding 10, 4, 9, 8,2,6,22,77,55,63 to bag");
                 onie.add(10);
                 onie.add(4);
                 onie.add(9);
                 onie.add(8);
                 onie.add(2);
                 onie.add(6);
                 onie.add(22);
                 onie.add(77);
                  onie.add(55);
                 onie.add(63);
                 
                 System.out.println("Bag now: ");
                 System.out.print(onie);
                  System.out.println("Check bag full: "+onie.isFull());
                  System.out.println("Grab from bag: " +onie.grab());
                 System.out.println("=================================================================");
                 System.out.println("Testing Linked Bag now: ");
                 
                 LinkedBag<Integer> linkybag = new LinkedBag<Integer>();
                 System.out.println("Havent added anything yet so calling .isEmpty should = true\nLets see: " +linkybag.isEmpty());
	  
                 System.out.println("\nAdding 10, 4, 9, 8 to bag");
                 linkybag.add(10);
                 linkybag.add(4);
                 linkybag.add(9);
                 linkybag.add(8);

		 System.out.println("Now isEmpty should = false. Lets see: " +linkybag.isEmpty());
                  
                 Iterator<Integer>ity=linkybag.iterator();
       
              System.out.print("[");
                while(ity.hasNext()){
           
           
                    System.out.print(ity.next()+",");
       
                }
           
                 System.out.print("]\n");
                 
                 System.out.println("Remove 4 from bag: " +linkybag.remove(4));
                 ity=linkybag.iterator();
                 
           System.out.print("[");
                while(ity.hasNext()){
           
           
                    System.out.print(ity.next()+",");
       
                }
           
                 System.out.print("]\n");
                 
                 
                 System.out.println("Size of bag: "+linkybag.size());
                 
		System.out.print("Clearing bag: ");
                linkybag.clear();
               ity=linkybag.iterator();
                 
           System.out.print("[");
                while(ity.hasNext()){
           
           
                    System.out.print(ity.next()+",");
       
                }
           
                 System.out.print("]\n");
           
           }
    
}
