/*
 * TCSS 343
 */

package homework3;


import java.util.Random;


public class quicksort <E>{

	/**
	 * Both of these wanted by teacher.
	 */
	public Comparable[] a1st;
	public Comparable[] amid;
	
	/**
	 * Added for timer, for timing sort time.
	 */
	long myStartTime;
	long myEndTime;
	long myFinalTime;
	
	/**
	 * Method used to make arrays
	 * 
	 * @param n the size of n
	 */
	public quicksort(final int n) {
		a1st = new Comparable[n];
		amid = new Comparable[n];
	    Random randomGenerator = new Random();
	    for (int i = 0; i < n; ++i){
	      int randomInt = randomGenerator.nextInt(10);
	      a1st[i] = Integer.valueOf(randomInt);
	      amid[i]= Integer.valueOf(randomInt);
	    }
	    sortPivot1st();
	    sortPivotMid();
	    System.out.println();
	    System.out.println();
	    System.out.println("a1st already sorted");
	    sortPivot1st();
	    System.out.println("amid already sorted");
	    sortPivotMid();
	}
	
	public void sortPivot1st() {
		myStartTime = System.currentTimeMillis();
		Quicksort1st( a1st, 0, a1st.length-1);
		myEndTime = System.currentTimeMillis();
		myFinalTime = myEndTime - myStartTime;
		System.out.println("Pivot1st took millis = " + myFinalTime);
		//for (int i = 0; i < a1st.length; ++i){
		//	System.out.print(a1st[i] + " ");
		//}
		System.out.println();
	}
	
	public void sortPivotMid() {
		myStartTime = System.currentTimeMillis();
		QuicksortMid( a1st, 0, a1st.length-1);
		myEndTime = System.currentTimeMillis();
		myFinalTime = myEndTime - myStartTime;
		System.out.println("PivotMid took millis = " + myFinalTime);
		//for (int i = 0; i < amid.length; ++i){
		//	System.out.print(amid[i] + " ");
		//}
	}
	
	/**
	 *  Helper method used to swap elements in a comparable
	 *  
	 * @param a comparable
	 * @param i int
	 * @param j int
	 */
	public void swap(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
	
	/**
	 *  Helper method used to swap elements in a comparable
	 *  
	 * @param a comparable
	 * @param i int
	 * @param j int
	 */
	public void swap2(Comparable[] a, int i, int j) {
		Comparable temp = a[(i + j)/2];
        a[i] = a[j];
        a[j] = temp;
    }
	
	//First sorting method group
	public int Pivot1st(Comparable[] a, int l, int r) {
		Comparable pivot = a[l];
		int low = l + 1;
		int high = r;
		
		while (low <= high) {
			//compare to low and if low goes over r break
			while (pivot.compareTo(a[low]) > 0 ) {
				low++;
				//used to break out of loop
				// really important
				if (low > r) {
					break;
				}
			}
			//compare to high
			while (0 > pivot.compareTo(a[high])) {
				--high;
			}
			
			//compare low and high
			if (low <= high) {
				//swap the elements
				swap(a, low, high);
				//for (int i = 0; i < a1st.length; ++i){
				//	System.out.print(a1st[i] + " ");
				//}
				low++;
				high--;
			}
		}	
		//for (int i = 0; i < a1st.length; ++i){
		//	System.out.print(a1st[i] + " ");
		//}
		//swap the elements
		swap(a, l, high);
		//returns pivots new storage location
		return high;      
	}

	public void Quicksort1st(Comparable[] a, int l, int r) { 
		if (r > l) { 
			int p = Pivot1st(a, l, r);
			Quicksort1st(a, l, p - 1); 
			Quicksort1st(a, p + 1, r);
		} 
	}
	
	public void Quicksort1st(Comparable[] a) { 
		Quicksort1st(a, 0, a.length - 1); 
	}
	
	
	
	
	
	//Second sorting method group
	// I tried to take what i did in the first part and change it to work
	// in the second part and it was just not happening.
	public int PivotMid(Comparable[] a, int l, int r) {
		int middle = (l + r)/2;
		Comparable pivot = a[middle];
		int low = l+1;
		int high = r;
		
		//for (int i = 0; i < amid.length; ++i){
		//	System.out.print(amid[i] + " ");
		//}
		while (low <= high) {
			//compare to low and if low goes over r break
			while (pivot.compareTo(a[low]) > 0 ) {
				low++;
				//used to break out of loop
				// really important
				if (low > r) {
					break;
				}
			}
			//compare to high
			while (0 > pivot.compareTo(a[high])) {
				--high;
			}
			
			//compare low and high
			if (low <= high) {
				//swap the elements
				swap(a, middle, high);
				//for (int i = 0; i < amid.length; ++i){
				//	System.out.print(amid[i] + " ");
				//}
				low++;
				high--;
			}
		}
		//for (int i = 0; i < amid.length; ++i){
		//	System.out.print(amid[i] + " ");
		//}
		//swap the elements
		swap(a, l, high);
		//for (int i = 0; i < amid.length; ++i){
		//	System.out.print(amid[i] + " ");
		//}
		//returns pivots new storage location middle
		return middle;    
	}
	
	public void QuicksortMid(Comparable[] a, int l, int r) { 
		if (r > l) { 
			int p = PivotMid(a, l, r); 
			QuicksortMid(a, l, p - 1); 
			QuicksortMid(a, p + 1, r); 
		} 
	}
	
	public void QuicksortMid(Comparable[] a) { 
		QuicksortMid(a, 0, a.length - 1); 
	}

}
