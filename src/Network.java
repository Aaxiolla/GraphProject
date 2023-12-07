import java.util.ArrayList;
public class Network {
    ArrayList<Node> nodes;
    Network(){}
    Network(ArrayList<Node> pNodes){
        this.nodes = pNodes;
    }
    public Node addNode(String name){
        Node nNode = new Node(name);
        nodes.add(nNode);
        return nNode;
    }
}
