package GraphAnalysis;

import java.util.ArrayList;
public class Network {
    public ArrayList<Node> nodes;
    public Network(){nodes = new ArrayList<Node>();}
    Network(ArrayList<Node> pNodes){
        this.nodes = pNodes;
    }
    public void addNode(Node newNode){
        nodes.add(newNode);
    }
    public void deleteNode(Node node){nodes.remove(node);}
}
