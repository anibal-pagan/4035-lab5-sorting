package sorterClasses;

public class CocktailSortSorter<E> extends BubbleSortSorter<E>{
	
	protected void auxSort() { 
		int k=0;
		for (int i = arr.length; i>k+1; i--){ 
			relocateMaxValueToLastPositionAmongFirst(i,k); 
			for (int j=i-1; j > k; j--) 
				if (cmp.compare(arr[j-1], arr[j]) > 0)
					super.swapArrayElements(j-1, j);
			k++;
		}
	}
	
	protected void relocateMaxValueToLastPositionAmongFirst(int i, int k) {
		// pre: 1 < i < arr.length
		for (int j=k; j < i-1; j++) 
			if (cmp.compare(arr[j], arr[j+1]) > 0)
				super.swapArrayElements(j, j+1);
		
	}
}
