package GraphProjectInterface;

import GraphAnalysis.Edge;
import GraphAnalysis.Network;
import GraphAnalysis.Node;

import java.util.ArrayList;

public class VisualGraph {
    Network network;
    ArrayList<VisualNode> nodes;
    ArrayList<VisualEdge> edges;
    void addNode(VisualNode node){
        nodes.add(node);
        network.addNode(node.node);
    }
    void addEdge(VisualEdge edge){
        edges.add(edge);
    }
    VisualGraph(){
        nodes = new ArrayList<VisualNode>();
        edges = new ArrayList<VisualEdge>();
        network = new Network();
    }
    VisualNode findNearestNode(int xCoord, int yCoord){
        double nearestSquaredDistance = 400;
        VisualNode nearestNode = null;
        for(VisualNode currentNode : nodes){
             double squaredDistance = Math.pow(xCoord - currentNode.x, 2) + Math.pow(yCoord - currentNode.y, 2);
             if(squaredDistance < nearestSquaredDistance){
                 nearestSquaredDistance = squaredDistance;
                 nearestNode = currentNode;
             }
        }
        return  nearestNode;
    }
    VisualEdge findNearestEdge(int xCoord, int yCoord){
        double nearestSquaredDistance = 400;
        VisualEdge nearestEdge = null;
        for(VisualEdge currentEdge : edges){
            double squaredDistance = currentEdge.squaredDistanceFromEdge(xCoord, yCoord);
            if(squaredDistance < nearestSquaredDistance){
                nearestSquaredDistance = squaredDistance;
                nearestEdge = currentEdge;
            }
        }
        return nearestEdge;
    }
    void deleteEdge(VisualEdge edge){
        edge.start.edges.remove(edge);
        edge.end.edges.remove(edge);
        edge.edge.delete();
        edge.edge = null;
        edges.remove(edge);
    }
    void deleteNode(VisualNode selectedNode){
        ArrayList<VisualEdge> tempEdges = (ArrayList<VisualEdge>) edges.clone();
        for(VisualEdge currentEdge : tempEdges){
            if(currentEdge.start == selectedNode || currentEdge.end == selectedNode){
                deleteEdge(currentEdge);
            }
        }
        network.deleteNode(selectedNode.node);
        nodes.remove(selectedNode);
    }
}
