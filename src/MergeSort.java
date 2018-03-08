
public class MergeSort {

	public static void main(String[] args) {
		
		//main tests the merge sort method
		int[] a = new int[3];
		
		for (int i = 0; i < a.length; i++) {
			int rand = (int)(Math.random() * 10);
			a[i] = rand;
		}
		System.out.print("Unsorted Array: ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		int[] b = mergesort(a);
		
		System.out.print("Sorted Array: ");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		
	}
	
	/**
	 * This method sorts an array of integers using Merge Sort.
	 * 
	 * @param - unsorted array of integers to sort.
	 * @return Sorted Array of Integers.
	 */
	public static int[] mergesort(int[] a) {
		//Just creating an int array that will be filled with the sorted array over time.
		int[] b = new int[a.length];
		
		/*If the length is 1, it returns the current array. I have to do this so it
		 *  doesn't cause problems when splitting the array into two.
		 */
		if (a.length == 1) {
			return a;
		}
		
		//This gets the first half of the array and sets it to a1
		int[] a1 = new int[a.length/2];
		for (int i = 0; i < a.length/2; i++) {
			a1[i] = a[i];		
		}
		
		//Sets the second half of the array to a2
		int[] a2 = new int[a.length - a.length/2];
		int i = 0;
		for (int j = a.length/2; j < a.length; j++) {
			a2[i] = a[j];
			i++;
		}

		
		/* This recursively sorts the two halves of a.
		 * Then the two half will continue to split until there is only one element in the array
		 * 
		 */
		a1 = mergesort(a1);
		a2 = mergesort(a2);

		
		/* Once the split has occured, the method will sort the two halves that were split. 
		 * These halves should have already been sorted recursively or their individual lengths should equal 1
		 */
		
		/* 
		 * For sorting each one, you go from the beginning of each array and select the lower number to add to b,
		 * then move up one on the array whose number went into b
		 */
		i = 0;
		int j = 0;
		int k = 0;
		while (i < a1.length && j < a2.length) {
			if (a1[i] <= a2[j]) {
				b[k] = a1[i];
				i++;
			}
			else {
				b[k] = a2[j];
				j++;
			}
			k++;
		}
		
		/*
		 * Since the previous while loop only runs until only one of the arrays have gone completely through,
		 * then you have to put into account the array that still has elements that have not yet been added to be
		 * 
		 */
		while(i < a1.length) {
			b[k] = a1[i];
			i++;
			k++;
		}
		
		while(j < a2.length) {
			b[k] = a2[j];
			j++;
			k++;
		}
		
		return b; //this returns the sorted array
		
	}
}
