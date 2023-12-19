package GraphProjectInterface;

import GraphAnalysis.Node;

public class VisualNode {
    Node node;
    String name;
    int x, y;
    VisualNode(int xposition,int yposition){
        x = xposition;
        y = yposition;
        node = new Node();
    }

}
