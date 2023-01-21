package hw6_p5;

import java.util.*;

public class Node {
    String name;
    // represent people that the given person follows as a list of strings containing their name
    ArrayList<String> follows = new ArrayList<>();

    public Node(String name) {
            this.name = name;
    }
}
