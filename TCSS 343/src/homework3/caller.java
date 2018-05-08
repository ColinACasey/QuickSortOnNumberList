/*
 * TCSS 343
 */

package homework3;

import java.util.Random;
import java.util.Scanner;

public class caller {
	public static quicksort mySort;
	
	public static void main(String args[]){
		System.out.println("Enter in n: ");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		mySort = new quicksort(n);
		in.close();
	}
}
