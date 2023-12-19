package GraphAnalysis;

import java.util.ArrayList;
public class Network {
    ArrayList<Node> nodes;
    Network(){}
    Network(ArrayList<Node> pNodes){
        this.nodes = pNodes;
    }
    public void addNode(Node newNode){
        nodes.add(newNode);
    }
}
