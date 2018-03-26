package sorterClasses;

import java.lang.reflect.Array;

public class CombSorter<E> extends AbstractSorter<E>{
	private boolean sorted = false;
	public CombSorter() {
		super("   	Comb Sort");
	}

	@Override
	protected void auxSort() { 
		boolean sorted = false;
		int gap = arr.length;
		while(sorted == false){
			gap = gap*10/13;
			if(gap>1){
				sorted = false;
			}else {
				gap = 1;
				sorted = true;
			}
			int i=0;
			while(i+gap<arr.length){
				if (cmp.compare(arr[i], arr[i+gap]) > 0){
					super.swapArrayElements(i, i+gap);
					sorted = false;
				}
				i++;
			}
		}
	}
}
