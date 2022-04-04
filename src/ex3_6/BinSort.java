package ex3_6;

import java.util.Random;

public class BinSort
{   
   public static void main(String[] args)
   { 
	   
	   Random rand = new Random();
	   final int limit=100;
	   int[] list=new int[150];
	   for(int i =0; i<list.length;i++) {
		   list[i]=rand.nextInt(limit+1);
	   }
	   
	   System.out.println("values to sort:");
	    
	   for(int j=0; j <list.length;j++) {
		   System.out.print(" " +list[j]) ;
		  
	   }
	   
	   System.out.println();
	   long start =System.nanoTime()/1000;
	   sort(list, limit);
	   long end= System.nanoTime()/1000;
	   
	   System.out.println("\nsort values: ");
	   
	   for(int i=0; i<list.length; i++) {
		   System.out.print(" " +list[i]);
		   
	   }
	   System.out.println("\ntime taken: " +(end-start) +" micro seconds");
	 
   }
   
   public static void sort(int[] list, int limit) {
	   int[] bin = new int[limit+1];
	   
	   
	   for(int k=0; k<list.length; k++) {
		   bin[list[k]]=bin[list[k]]+1;
	   }
	   
	   int binny=0;
	   for(int i=0; i<bin.length;i++) {
		   if(bin[i]>0) {
			   for(int z=0;z<bin[i]; z++) {
				   list[binny]=i;
				   binny++;
			   }
		   }
	   }
	   
   }
}
