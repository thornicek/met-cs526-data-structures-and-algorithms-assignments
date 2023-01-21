package homework4;

import java.util.*;


public class Problem_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime, endTime, elapsedTime;
		
		int trialCount = 10;
		
		int numberOfKeys = 100000;
		
		HashMap<Integer,Integer> myMap = new HashMap<Integer,Integer>();
		
		ArrayList<Integer> myArrayList = new ArrayList<Integer>();
		
		LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
		
		LinkedList<Long> insertionLinkedList = new LinkedList<Long>();
		
		LinkedList<Long> insertionInsertMap = new LinkedList<Long>();
		
		LinkedList<Long> insertionArrayList = new LinkedList<Long>();
		
		LinkedList<Long> searchArrayList = new LinkedList<Long>();
		
		LinkedList<Long> searchInsertMap = new LinkedList<Long>();
		
		LinkedList<Long> searchLinkedList = new LinkedList<Long>();
		
		
		//Store random generated numbers in insertKeys array 
		int[] insertKeys =  generateRandom(numberOfKeys,1000000);
		//Run insertion test trialCount times
		for(int i = 0; i < trialCount; i++) {
			 //Hashmap insertion test
		 	startTime = System.currentTimeMillis();
		 	for(int k = 0; k < numberOfKeys; k++ ) {
		 		myMap.put(k,insertKeys[k]);
		 	}
		 	endTime = System.currentTimeMillis();	
		 	elapsedTime = endTime - startTime;
		 	insertionInsertMap.add(elapsedTime);
			
		 	//LinkedList insertion test
		 	startTime = System.currentTimeMillis();
		 	for(int l = 0; l < numberOfKeys; l++ ) {
		 		myLinkedList.add(insertKeys[l]);
		 	}
		 	endTime = System.currentTimeMillis();	
		 	elapsedTime = endTime - startTime;
		 	insertionLinkedList.add(elapsedTime);
		 	
		 	
		
			//Array List insertion test
		 	startTime = System.currentTimeMillis();
		 	for(int m = 0; m < numberOfKeys; m++ ) {
		 		myArrayList.add(insertKeys[m]);
		 	}
		 	endTime = System.currentTimeMillis();	
		 	elapsedTime = endTime - startTime;
		 	insertionArrayList.add(elapsedTime);
		 	
		}
		
		//Store random numbers in the searchKeys array
		int[] searchKeys = generateRandom(numberOfKeys,2000000) ;
		
		//Run search test trialCount times
		for(int n = 0; n < trialCount; n++) {
			//HashMap search test
		 	startTime = System.currentTimeMillis();
		 	for(int k = 0; k < numberOfKeys; k++ ) {
		 		myMap.containsKey(searchKeys[k]);
		 	}
		 	endTime = System.currentTimeMillis();	
		 	elapsedTime = endTime - startTime;
		 	searchInsertMap.add(elapsedTime);
		 	
		
		 	//LinkedList search test
		 	startTime = System.currentTimeMillis();
		 	for(int k = 0; k < numberOfKeys; k++ ) {
		 		myLinkedList.contains(searchKeys[k]);
		 	}
		 	endTime = System.currentTimeMillis();	
		 	elapsedTime = endTime - startTime;
		 	searchLinkedList.add(elapsedTime);
		
		
		 	//ArrayList search test
		 	startTime = System.currentTimeMillis();
		 	for(int k = 0; k < numberOfKeys; k++ ) {
		 		myArrayList.contains(searchKeys[k]);
		 	}
		 	endTime = System.currentTimeMillis();	
		 	elapsedTime = endTime - startTime;
		 	searchArrayList.add(elapsedTime);
		 	
		}	
		
		//Compute average times
		long averageInsertionLL = generateAverage(insertionLinkedList);
		long averageInsertionIM = generateAverage(insertionInsertMap);
		long averageInsertionAL = generateAverage(insertionArrayList);
		long averageSearchAL = generateAverage(searchArrayList);
		long averageSearchLL  = generateAverage(searchLinkedList);
		long averageSearchIM  = generateAverage(searchInsertMap);
		
		//Print out results
		System.out.println("Number of keys = "+ numberOfKeys);
		System.out.println();
		System.out.println("HashMap average total insert time = "+ averageInsertionIM);
		System.out.println("ArrayList average total insert time = "+ averageInsertionAL);
		System.out.println("LinkedList average total insert time = "+ averageInsertionLL);
		System.out.println();
		System.out.println("HashMap average total search time = "+ averageSearchIM );
		System.out.println("ArrayList average total search time = "+ averageSearchAL );
		System.out.println("LinkedList average total search time = "+ averageSearchLL );
		
	}
	//Helper function to generate distinct random numbers
	public static int[] generateRandom(int count, int range) {
		//Use set to ensure unique numbers
		Set<Integer> randomSet = new HashSet<Integer>();
		Random r = new Random(System.currentTimeMillis());
		//Add numbers to set until given count is reached
		while (randomSet.size() < count) {
			int randint = r.nextInt(range) + 1;
			randomSet.add(randint);
		}
		//Copy set into array
		int[] randomArr = new int[count];
		int i = 0;
		for (int temp : randomSet) {
			randomArr[i] = temp;
			i++;
		}
		
		return randomArr;
	
	}
	//Helper function to compute average 
	public static long generateAverage(LinkedList<Long> input) {
		long total = 0;
		for(long temp: input) {
			total += temp;
		}
		long average = total/input.size();
		return average;
	}
}
