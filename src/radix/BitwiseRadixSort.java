/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radix;

/**
 *
 * @author pgx2172
 */
import java.util.*;

public class BitwiseRadixSort {
	
	 public static void main (String[] args)
	   {
		   System.out.println("Sorting These");
		 
		   char symbols[] = {'®', '&', '#', '^', '$', '!', '?'};
	       int n = symbols.length;
	       
	       for (int i=0; i<symbols.length; i++){
	    	   
	       System.out.print(symbols[i]+" ");
	       }
	       System.out.println();
	       
	       for (int i=0; i<symbols.length; i++)
	       {
	       int a = symbols[i];
	       System.out.print(a+" ");
	       }
	      
	       bitwiseRadixSort(symbols, n);
	           
	       System.out.println("\nSorted");
	       for (int i=0; i<symbols.length; i++){
	    	   
	       System.out.print(symbols[i]+" ");
	       }
	       System.out.println();
	       
	       for (int i=0; i<symbols.length; i++)
	       {
	       int a = symbols[i];
	       System.out.print(a+" ");
	       }
	   }
	 
	 static void bitwiseRadixSort(char symbols[], int n)
	   {
	       int alpha = combo(symbols, n);
	       for (int beta = 1; alpha/beta > 0; beta *= 10)
	       {
	    	   char output[] = new char[n];
		       int i;
		       int count[] = new int[10];
		       Arrays.fill(count,0);

		       for (i = 0; i < n; i++)
		       {
		       count[ (symbols[i]/beta)%10 ]++;
		       }
		       
		       for (i = 1; i < 10; i++)
		       {
		       count[i] += count[i - 1];   
		       }
		      
		       for (i = n - 1; i >= 0; i--)
		       {
		           output[count[ (symbols[i]/beta)%10 ] - 1] = symbols[i];
		           count[ (symbols[i]/beta)%10 ]--;
		       }

		       for (i = 0; i < n; i++)
		       {
		           symbols[i] = output[i];
		       }
	       }
	          
	   }
	
	 static int combo(char symbols[], int n)
	   {
	       int mx = symbols[0];
	       for (int i = 1; i < n; i++)
	           if (symbols[i] > mx)
	               mx = symbols[i];
	       return mx;
	   }

	  

	  

}