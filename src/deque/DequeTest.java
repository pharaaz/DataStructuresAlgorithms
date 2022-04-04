package deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DequeTest {
	public static void main(String[] args) {
		
		System.out.println("==============DEQUE TEST=========");
		DequeADT<String> deque = new DoublyLinkedDeque<>();
		System.out.println("Enqueue To Front (F) and Rear (R)");
		deque.enqueueFront("(F)");
		deque.enqueueRear("(R)");
		System.out.println("Deque is: " +deque.toString());
		System.out.println("Clearing the Deque");
		deque.clear();
		System.out.println("Deque is: " +deque.toString());
		
		System.out.println("Enqueue To REAR: A, B, C, D");
		deque.enqueueRear("(A)");
		deque.enqueueRear("(B)");
		deque.enqueueRear("(C)");
		deque.enqueueRear("(D)");
		System.out.println("Deque is: " +deque.toString());
		System.out.println("FRONT element is: " +deque.first() +"REAR element is: " +deque.last());
		
		System.out.println("Enqueue To Front: E, F, G, H");
		deque.enqueueRear("(E)");
		deque.enqueueRear("(F)");
		deque.enqueueRear("(G)");
		deque.enqueueRear("(H)");
		
		System.out.println("Deque is: " +deque.toString());
		System.out.println("Number of elements is: " +deque.size());
		System.out.println("FRONT element is: " +deque.first() +"REAR element is: " +deque.last());
		System.out.println("Dequeue Two ellesments from FRONT:" +deque.dequeueFront() +"," +deque.dequeueFront());
		System.out.println("Dequeue Two ellesments from REAR: " +deque.dequeueRear() +"," +deque.dequeueRear());
		System.out.println("Number of elements is: " +deque.size());
		System.out.println("FRONT element is: " +deque.first() +"REAR element is: " +deque.last());
		
		System.out.println("Testing Ieration: ");
		Iterator<String> iterator = deque.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() +" ");
		}
		System.out.println("\nLOOP and dequeue from rear until empty: ");
		while(!deque.isEmpty()) {
			System.out.print(deque.dequeueRear() +" ");
		}
		
		System.out.println("\ndeque is: " +deque.toString());
		System.out.print("Enqueue at rear: 1, 2, 3 and 4 at front ");
		deque.enqueueRear("1");
		deque.enqueueRear("2");
		deque.enqueueRear("3");
		deque.enqueueFront("4");
		
		System.out.println("Deque is: " +deque.toString());
		System.out.println("LOOP and dequeue from front until empty: ");
		while(!deque.isEmpty()) {
			System.out.print(deque.dequeueFront() +" ");
		}
		
		System.out.println("\nDeque is: " +deque.toString());
		System.out.println("ecepection should be cause and done on purpose. Enqueue from Rear");
		try {
			System.out.println(deque.dequeueRear());
		}catch(NoSuchElementException e) {
			System.out.println("EXCEPTION: " +e);
		}
		
		System.out.println("==============TEST DONE=========");
		
		


		
		
		
	}

}
