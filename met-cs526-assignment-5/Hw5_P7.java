package tHornicek_hw5;

import java.util.*;

public class Hw5_P7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime, endTime, elapsedTime;
		
		
		int[] unsortArray;
		int numberOfKeys = 1000000;
		// Store random generated numbers in unsorted array 
	
		
		// Insertion Sort
		
		for(int i = 0; i < 11; i++ ) {
			// Use this to set the array size
			numberOfKeys = i *10000;
			//Store random generated numbers in unsorted array 
			unsortArray =  generateRandom(numberOfKeys);
			//printArray(unsortArray);
			// Measure the time for n= 10 000
			startTime = System.currentTimeMillis();
			insertionSort(unsortArray);
			endTime = System.currentTimeMillis();	
		 	elapsedTime = endTime - startTime;
		 	System.out.println("Runtime for insertion sort for "+ numberOfKeys +" number of keys: "+ elapsedTime +"ms");
		}
		
	
	 	// Merge Sort
		int[] mergeUnsortArray =  generateRandom(numberOfKeys);
	 	// Initialize comparator
	 	Comparator<Integer> comp = new DefaultComparator<Integer>();
		numberOfKeys = 10000;
		for( int i = 0; i < 11; i++ ) {

			numberOfKeys = i * 10000;
			// Measure the time
			startTime = System.currentTimeMillis();
			// Create copy of array for storage
			Integer[] copy = Arrays.stream(mergeUnsortArray ).boxed().toArray( Integer[]::new );
			// Pass the comparator and the copy of array to mergeSort
			mergeSort(copy, comp);
			endTime = System.currentTimeMillis();	
		 	elapsedTime = endTime - startTime;
		 	System.out.println("Runtime for merge sort for "+ numberOfKeys +" number of keys: "+ elapsedTime +"ms");
		}
	 	

	 	// Quick Sort
		int[] quickUnsortArray =  generateRandom(numberOfKeys);
		for( int i = 0; i < 11; i++ ) {
			// Store random generated numbers in unsorted array 
			numberOfKeys = i * 10000;
			// Measure the time
			startTime = System.currentTimeMillis();
			// Create copy of array for storage
			Integer[] copy = Arrays.stream(quickUnsortArray ).boxed().toArray( Integer[]::new );
			// Pass the comparator, the copy of array and the range to quick Sort
			quickSortInPlace(copy, comp, 0, copy.length-1);
			endTime = System.currentTimeMillis();	
		 	elapsedTime = endTime - startTime;
		 	System.out.println("Runtime for quick sort for "+ numberOfKeys +" number of keys: "+ elapsedTime +"ms");
		}
		
		// Heap Sort
		int[] heapUnsortArray =  generateRandom(numberOfKeys);
		for( int i = 0; i < 11; i++ ) {
			// Store random generated numbers in unsorted array 
			mergeUnsortArray =  generateRandom(numberOfKeys);
			numberOfKeys = i * 10000;
			// Measure the time
			startTime = System.currentTimeMillis();
			// Create a new object class Heapsort
			HeapSort hs = new HeapSort();
			// Sort the unsorted array
			hs.sort(heapUnsortArray);
			endTime = System.currentTimeMillis();	
		 	elapsedTime = endTime - startTime;
		 	System.out.println("Runtime for heap sort for "+ numberOfKeys +" number of keys: "+ elapsedTime +"ms");
		}
		
		
	}
	
	// Insertion-sort copied from the book
	public static void insertionSort(int[]data) {
		int n = data.length;
		for (int k=1; k<n; k++) {
			int cur = data[k];
			int j = k;
			while(j>0 && data[j-1]>cur) {
				data[j] = data[j-1];
				j--;
			}
			data[j] = cur;
		}
	}
	// Quick sort copied from the book
	private static <K> void quickSortInPlace(K[]S, Comparator<K> comp, int a, int b) {
		if(a >= b)return;
		int left = a;
		int right = b-1;
		K pivot = S[b];
		K temp;
		while(left <= right) {
			// Scan until reaching value equal or larger than pivot (or right marker)
			while (left <= right && comp.compare(S[left], pivot) < 0) left++;
			// Scan until reaching value equal or smaller than pivot (or left marker)
			while (left <= right && comp.compare(S[right], pivot) > 0) right--;
			if (left <= right) {
				temp = S[left]; S[left] = S[right]; S[right] = temp;
				left++; right--;
			}
		}
		// put pivot into its final place (currently marked by left index)
		temp = S[left]; S[left] = S[b]; S[b] = temp;
		// make recursive calls
		quickSortInPlace(S, comp, a, left - 1);
		quickSortInPlace(S, comp, left + 1, b);
	}
	
	
	// Merge sort copied from the book
	public static <K> void mergeSort(K[]S, Comparator<K>comp) {
		int n = S.length;
		if(n<2) return;
		// Divide
		int mid = n/2;
		K[] S1 = Arrays.copyOfRange(S, 0, mid);
		K[] S2 = Arrays.copyOfRange(S, mid, n);
		// Conquer with recursion
		mergeSort(S1, comp);
		mergeSort(S2, comp);
		// Merge the results
		merge(S1, S2, S, comp);
		
	}
	
	// Helper function merge copied from the book
	public static <K> void merge(K[]S1, K[]S2, K[]S, Comparator<K>comp) {
		int i = 0, j = 0;
		while(i + j < S.length) {
			if(j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j])< 0))
				S[i+j] = S1[i++];
			else
				S[i+j] = S2[j++];
				
		}
	}
	
	// Helper function to generate distinct random numbers
	public static int[] generateRandom(int count) {
		//Initialize new random array
		int[] randomArr = new int[count];
		Random r = new Random();
		for (int i = 0; i < randomArr.length; i++) {
			randomArr[i] = r.nextInt(1000000)+ 1;
		}
		return randomArr;
	}
	// Helper function to print array for testing
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
 
        System.out.println();
    }
}
