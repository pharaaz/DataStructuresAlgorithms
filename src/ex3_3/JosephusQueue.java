package ex3_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JosephusQueue {
	
public static void main(String[] args) {
	
	
	Queue <Integer> nums = new LinkedList<Integer>();
	int current;
	int dead;
	
	System.out.println("===JosephusQueue==");
	Scanner scanner = new Scanner(System.in);
	System.out.println("Eneter number of soldiers in Josephus problem ");
	
	String user = scanner.nextLine();
	int numSold = Integer.parseInt(user);
	System.out.println("Eneter number to remove the soldier ");
	int numRem = scanner.nextInt();
	
	
	for(int i=1; i<=numSold; i++) {
		//System.out.println(i);
		nums.add(i);
		//System.out.println(nums);
	}
	
	System.out.println("here are the soldiers: \n" +nums);
	
	
	while(nums.size()!=1) {
		for(int i = 1; i<=numRem; i++) {
			if(i==numRem) {
				dead = nums.peek();
				nums.poll();
				System.out.println("This soldier died X( : " +dead);
			}
			else {
				current=nums.peek();
				nums.poll();
				nums.add(current);
			}
		}
	}
	
	System.out.println("Last solider left: " +nums);
	
	
}
	
	
	
	
	

}