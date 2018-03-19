package sortersTesterClasses;

import java.util.Comparator;

import sorterClasses.SelectionSortSorter;
import interfaces.Sorter;

public class IntegerSorterTester2 {
	private static Integer[] array= {5, 9, 20, 22, 20, 5, 4, 13, 17, 8, 22, 1, 3, 7, 11, 9, 10}; 
	private static Sorter<Integer> sorter = new SelectionSortSorter<>();
	
	public static void main(String[] args) { 
		test("Sorting Using IntegerComparator1", new IntegerComparator1()); 
		test("Sorting Using IntegerComparator2", new IntegerComparator2()); 
	}
	
	private static void test(String msg, Comparator<Integer> cmp) { 

		System.out.println("\n\n*******************************************************");
		System.out.println("*** " + msg + "  ***");
		System.out.println("*******************************************************");
		
		Integer[] original, arr; 
		// generate random arrays is size i and test...
		original = array;
		showArray("\n ---Original array of size " + original.length + " to sort:", original);
		arr = original.clone(); 
		sorter.sort(arr, cmp);
		showArray(sorter.getName() + ": ", arr); 
	}
	
	private static void showArray(String msg, Integer[] a) {
		System.out.print(msg); 
		for (int i=0; i<a.length; i++) 
			System.out.print("\t" + a[i]); 
		System.out.println();
	}
}
