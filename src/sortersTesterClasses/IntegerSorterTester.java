package sortersTesterClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

import sorterClasses.BubbleSortSorter;
import sorterClasses.CocktailSortSorter;
import sorterClasses.CombSorter;
import sorterClasses.HeapSortSorter;
import sorterClasses.InsertionSortSorter;
import sorterClasses.SelectionSortSorter;
import interfaces.Sorter;

public class IntegerSorterTester {
	//private static Sorter<Integer> sorter; 
	private static Random rnd; 
	private static ArrayList<Sorter<Integer>> sortersList = new ArrayList<>(); 
	private static int size;
	
	public static void main(String[] args) { 
		Integer[] custom;
		Scanner scanner = new Scanner(System.in);
		sortersList.add(new BubbleSortSorter<Integer>()); 
		sortersList.add(new SelectionSortSorter<Integer>()); 
		sortersList.add(new InsertionSortSorter<Integer>()); 
		sortersList.add(new CombSorter<Integer>()); 
		sortersList.add(new CocktailSortSorter<Integer>()); 
		sortersList.add(new HeapSortSorter<Integer>()); 
		
		test("Sorting Using Default Comparator<Integer>", null); 
		test("Sorting Using IntegerComparator1", new IntegerComparator1()); 
		test("Sorting Using IntegerComparator2", new IntegerComparator2()); 
		
		System.out.println("Enter the size of the custom array:");
		size = scanner.nextInt();
		custom = customValues(size);
		customTest("Sorting Using Default Comparator<Integer>", null, custom); 
		customTest("Sorting Using IntegerComparator1", new IntegerComparator1(), custom); 
		customTest("Sorting Using IntegerComparator2", new IntegerComparator2(), custom); 
		scanner.close();
		
	}
	
	private static void test(String msg, Comparator<Integer> cmp) { 
		rnd = new Random(101); 

		System.out.println("\n\n*******************************************************");
		System.out.println("*** " + msg + "  ***");
		System.out.println("*******************************************************");
		
		Integer[] original, arr;
		// generate random arrays is size i and test...
		for (int i=1; i<=20; i += 5) { 
			original = randomValues(i);
			showArray("\n ---Original array of size " + i + " to sort:", original); 
			
			for (int s=0; s<sortersList.size(); s++) {
				Sorter<Integer> sorter = sortersList.get(s); 
			    arr = original.clone(); 
			    sorter.sort(arr, cmp);
			    showArray(sorter.getName() + ": ", arr); 
			}
		}
	}
	private static void customTest(String msg, Comparator<Integer> cmp, Integer[] arr){
		System.out.println("\n\n*******************************************************");
		System.out.println("*** " + msg + "  ***");
		System.out.println("*******************************************************");
		
		Integer[] original, arr2;
		original = arr;
		showArray("\n ---Original array of size " + arr.length + " to sort:", original); 
		
		for (int s=0; s<sortersList.size(); s++) {
			Sorter<Integer> sorter = sortersList.get(s); 
		    arr2 = original.clone(); 
		    sorter.sort(arr2, cmp);
		    showArray(sorter.getName() + ": ", arr2); 
		}
	}

	private static void showArray(String msg, Integer[] a) {
		System.out.print(msg); 
		for (int i=0; i<a.length; i++) 
			System.out.print("\t" + a[i]); 
		System.out.println();
	}

	private static Integer[] randomValues(int i) {
		Integer[] a = new Integer[i]; 
		for (int j=0; j<i; j++) 
			a[j] = rnd.nextInt(100); 
		return a;
	}
	
	private static Integer[] customValues(int i) {
		Integer[] a = new Integer[i]; 
		Scanner scanner = new Scanner(System.in);
		for (int j=0; j<i; j++) 
			a[j] = scanner.nextInt(); 
		scanner.close();
		return a;
	}

}
