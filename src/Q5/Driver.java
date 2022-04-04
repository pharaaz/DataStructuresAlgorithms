package q3;

import java.util.Iterator;
import java.util.Set;

public class Driver {
	
	public static void main(String[] args) {
		Set<String> set = new HashSetWithChaining<>(6, 0.75f);
		set.add("Frost");
		set.add("Jay");
		set.add("Kevin");
		set.add("Faraaz");
		
		System.out.println("Creating Set, inital capacity is 6. adding Frost, Jay, Kevin, Faraaz");
		System.out.println(set);
		System.out.println("Size is: " +set.size());
		System.out.println("Adding Sasuke, Bob, Zack, Frost, Jay, Bre");

		set.add("Sasuke");
		set.add("Bob");
		set.add("Zack");
		set.add("Frost");
		set.add("Jay");
		set.add("Logan");
		set.add("Bre");
		
		System.out.println("Size is: " +set.size());
		System.out.println(set);
		System.out.println("Does it Contain Frost?" +set.contains("Frost") +"Contain Zack " +set.contains("Zack"));
		System.out.println("Iterating");
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println();
		System.out.println("Removing frost, Zack");
		set.remove("Frost");
		set.remove("Zack");
		
		System.out.println("Size is: " +set.size());
		System.out.println(set);
		
	}

}
