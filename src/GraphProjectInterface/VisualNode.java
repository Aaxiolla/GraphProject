package GraphProjectInterface;

import GraphAnalysis.Node;

import java.util.ArrayList;

public class VisualNode {
    Node node;
    ArrayList<VisualEdge> edges;
    String name;
    int x, y;
    static int namesCounter = 0;

    VisualNode(int xposition,int yposition){
        x = xposition;
        y = yposition;
        node = new Node();
        edges = new ArrayList<>();
        name = nameNode();
    }
    public void addEdge(VisualEdge edge){
        edges.add(edge);
    }
    static String nameNode(){
        String name = "" + (char)(namesCounter % 26 + 65);
        if(namesCounter >= 26){
            name += Math.floorDiv(namesCounter, 26);
        }
        namesCounter++;
        System.out.println(name);
        return name;
    }
}
