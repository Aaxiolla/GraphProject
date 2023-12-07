import java.util.ArrayList;
public class Node {
    String name;
    ArrayList<Edge> outEdgesList;
    ArrayList<Edge> inEdgesList;
    Node(String name){
        this.name = name;
    }
}