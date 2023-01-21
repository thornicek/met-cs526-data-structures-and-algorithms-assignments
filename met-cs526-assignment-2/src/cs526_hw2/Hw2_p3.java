package cs526_hw2;


public class Hw2_p3 {

	// implement reverse method
	// you may want to write a separate method with additional parameters, which is recursive
	//reverse method calls rev method and sets the new tail and head
	public static void reverse(DoublyLinkedList<Integer> intList) {
		DoubleLinkNode<Integer> header = intList.getHeader(); //get old header
		DoubleLinkNode<Integer> tail = intList.getTrailer();//get old tail
		rev(header);
		intList.setHeader(tail);//set new header
		intList.setTrailer(header);//set new tail
	}
	//helper method, which reverses the order of the doubly linked list by exchanging the previous and next pointers.
	//input argument should initially be the first element in the doubly linked list.
	//the function then proceeds recursively until it reaches end of list.
	private static <E> void rev(DoubleLinkNode<E> currentNode) {
		if(currentNode == null)
			return;
		DoubleLinkNode<E> temp =  currentNode.getPrev();//store previous node in temp variable
		currentNode.setPrev(currentNode.getNext()); //set previous pointer to get next element
		currentNode.setNext(temp); //set next to previous element
		rev(currentNode.getPrev()); //recurse
		
		
	}
	
	// use the main method for testing
	// test with arrays of different lenghts
	public static void main(String[] args) {

		
		DoublyLinkedList<Integer> intList = new DoublyLinkedList<>();
		
		int[] a = {10, 20, 30, 40, 50};
		for (int i=0; i<a.length; i++) {
			intList.addLast(a[i]);
		}
		System.out.println("Initial list: size = " + intList.size() + ", " + intList.toString());
		
		// Here, invoke the reverse method you implemented above
		reverse(intList);
		
		System.out.println("After reverse: " + intList.toString());
		
		intList = new DoublyLinkedList<>();
		int[] b = {10, 20, 30, 40, 50, 60};
		for (int i=0; i<b.length; i++) {
			intList.addLast(b[i]);
		}
		System.out.println();
		System.out.println("Initial list: size = " + intList.size() + ", " + intList.toString());
		
		// Here, invoke the reverse method you implemented above
		reverse(intList);
		
		System.out.println("After reverse: " + intList.toString());

	}

}
