package GraphProjectInterface;

import GraphAnalysis.Network;
import GraphAnalysis.Node;

import java.util.ArrayList;

public class VisualGraph {
    Network network;
    ArrayList<VisualNode> nodes;
    ArrayList<VisualEdge> edges;
    void addNode(VisualNode node){
        System.out.println("Node added at " + node.x + ", " + node.y);
        nodes.add(node);
        //network.addNode(node.node);
    }
    VisualGraph(){
        nodes = new ArrayList<VisualNode>();
        edges = new ArrayList<VisualEdge>();
    }
    VisualNode findNearestNode(int xCoord, int yCoord){
        double nearestDistance = 40f;
        VisualNode nearestNode = null;
        for(VisualNode currentNode : nodes){
             double dis = Math.sqrt(Math.pow(xCoord - currentNode.x, 2) + Math.pow(yCoord - currentNode.y, 2));
             if(dis < nearestDistance){
                 nearestDistance = dis;
                 nearestNode = currentNode;
             }
        }
        System.out.println("The nearest node is " + nearestNode);
        return  nearestNode;
    }
}
