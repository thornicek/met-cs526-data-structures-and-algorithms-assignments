package hw6_p5;

import java.io.*;
import java.util.*;



public class Hw6_p5 {
	
	public static void main(String[] args) {
		try {
            ArrayList<Node> adjList = new ArrayList<>();
            Scanner scanner = new Scanner(new File("follows_input.txt"));
            // read the input file, line by line
            while (scanner.hasNextLine()) {
                    String ar[] = scanner.nextLine().split(",");
                    // first item in the array is the node representing the person
                    String src = ar[0];
                    src = src.trim();
                    Node node = new Node(src);
                    // iterate over rest of the line which are people that the given persons follows
                    for (int i = 1; i < ar.length; i++) {
                            String des = ar[i];
                            des = des.trim();
                            // add names of people that the person follows
                            node.follows.add(des);
                    }
                    adjList.add(node);
            }
            // print out the adjacency list
            for (Node n : adjList) {
                System.out.println(n.name + " " + n.follows);
        }
            System.out.println();
            // test the code with person "D"
            allFollows("D", adjList);
	    	} 
	    catch (Exception e) {
	            e.printStackTrace();
	    }

	}
    // method that will print all the people X directly and indirectly follows
    static void allFollows(String X, ArrayList<Node> adjList) {
            // use priority queue to save all direct and indirect follows
    		// priority queue has O(1) runtime for addition and removal
    		PriorityQueue<String> pq = new PriorityQueue<>();
            // keep track of all people that have been processed
    		Set<String> processedPersons = new TreeSet<>();
            Set<String> indirectFollows = new TreeSet<>();
            ArrayList<String> directFollows = new ArrayList<String>();
            // add all people that X directly follows to directFollows list 
            // add all people who X directly follows to priority queue
            for (Node n : adjList) {
                    if (n.name.equals(X)) {
                            directFollows = n.follows;
                            for (String following : n.follows) {
                                    pq.add(following);
                            }
                            break;
                    }
            }
            System.out.println(X + " directly follows " + directFollows);
            // iterate over the priority queue, until its empty
            while (!pq.isEmpty()) {
                    String currentPerson = pq.remove();
                    // check if we have already considered the given person 
                    if (processedPersons.add(currentPerson)) {
                        // find given person in adjacency list    
                    	for (Node n : adjList) {
                                    if (n.name.equals(currentPerson)) {
                                    		// add all people that the person follows to priority queue
                                            for (String following : n.follows) {
                                                    pq.add(following);
                                                    // if the person is not a direct follow, add them as an indirect follow
                                                    if (!directFollows.contains(following))
                                                            indirectFollows.add(following);
                                            }
                                            break;
                                    }
                            }
                    }
            }

            System.out.println(X + " indirectly follows " + indirectFollows);
    }
}


