package ex2_1;

public class ArraySet<X> {
	
	private X[] stuff;
	private int size=0;
	static int n ;
	
	
	
	public ArraySet(int n) {
		this.stuff=(X[]) new Object[n];
		size=0;
	}
	
	public boolean contains(X x) {
		for(int i = 0; i<size;i++) {
			if(x.equals(stuff[i])) {
				return true;
			}
		}
		
		return false;
	}
	
	public void add(X x) {
		if(contains(x)) {
			return;
		}
		stuff[size]=x;
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public void remove(X x) {
		int key =3;
		for(int i = 0; i<size;i++) {
			if(x.equals(stuff[i])) {
				key = 2;
			}
			if(i==(n-1)) {
				
				break;
			}
			
			if(key==2 ) {
				stuff[i]=stuff[i+1];
			}
			
			
		}
		size--;
	}
	
	
	
	
	 public static void main(String[] args)
	   { 
		 
		
		 
		 System.out.println("Adding n = 100");
		 n =100;
		 ArraySet<Integer> onie = new ArraySet<>(n);
		
		long start =System.nanoTime()/1000;
		  
		 for(int i = 0; i <n; i++) {
			 onie.add(i);
		 }
		 long end= System.nanoTime()/1000;
		 
		 System.out.println("\ntime taken: " +(end-start) +" micro seconds");
		 
		 start =System.nanoTime()/1000;
		 onie.contains(n/2);
		 end= System.nanoTime()/1000;
		 System.out.println("How long it takes to find element n/2: " +(end-start) +" micro seconds");
	   
		 start =System.nanoTime()/1000;
		 onie.remove(n/2);
		 end= System.nanoTime()/1000;
		 System.out.println("How long it takes to remove element n/2: " +(end-start) +" micro seconds");
		 
		 System.out.println("Adding n = 5000");
		 n =5000;
		 ArraySet<Integer> jeff = new ArraySet<>(n);
		
		start =System.nanoTime()/1000;
		  
		 for(int i = 0; i <n; i++) {
			 jeff.add(i);
		 }
		 end= System.nanoTime()/1000;
		 
		 System.out.println("\ntime taken: " +(end-start) +" micro seconds");
		 
		 start =System.nanoTime()/1000;
		 jeff.contains(n/2);
		 end= System.nanoTime()/1000;
		 System.out.println("How long it takes to find element n/2: " +(end-start) +" micro seconds");
	   
		 start =System.nanoTime()/1000;
		 jeff.remove(n/2);
		 end= System.nanoTime()/1000;
		 System.out.println("How long it takes to remove element n/2: " +(end-start) +" micro seconds");
		 
	   }

}

