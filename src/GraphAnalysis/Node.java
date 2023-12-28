package GraphAnalysis;

import java.util.ArrayList;
public class Node {
    String name;
    ArrayList<Edge> outEdgesList;
    ArrayList<Edge> inEdgesList;
    public Node(String name){
        this.name = name;
    }
    public Node(){
        outEdgesList = new ArrayList<>();
        inEdgesList = new ArrayList<>();
    }
}