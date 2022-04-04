package ex1_2;

public class Sorts {
	
	public static void main(String args[]) {
		
		int thisy[]= {4,3,8,9,6,5,7,1};
		int small= 10000000;
		int sub=2;
		int found=0;
		int reset = 0;
		
		System.out.print("Original: ");
		
		for(int i =0; i<thisy.length;i++) {
			
			System.out.print(thisy[i] +" ,");
		}
		
		
		for(int j=0; j<thisy.length;j++) {
			for(int i =reset; i<thisy.length; i++) {
			
				if(small>thisy[i] ) {
					small = thisy[i];
					found=i;
					
				}
			}

			sub=thisy[j];
			thisy[j]= small;
			thisy[found]=sub;
			reset++;
		
			if(small==thisy[j]) {
				
				for(int k =0; k<thisy.length; k++) {
			
					if(small<thisy[k] ) {
					
						small = thisy[k];
						
					}
				}
				
			}
		}

		
		System.out.print("\nSorted: ");
		
		for(int i =0; i<thisy.length;i++) {
			
			System.out.print(thisy[i] +" ,");
		}

	}

}