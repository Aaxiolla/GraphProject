package GraphProjectInterface;


import GraphAnalysis.Edge;
import GraphAnalysis.Node;

import javax.swing.*;

public interface GraphTool {
    void clickEvent(GraphPanel panel, int xCoord, int yCoord);

    void mouseMovedEvent(GraphPanel panel, int xCoord, int yCoord);
}
class AddNode implements GraphTool{
    @Override
    public void clickEvent(GraphPanel panel, int xCoord, int yCoord) {
        panel.visualGraph.addNode(new VisualNode(xCoord - 5, yCoord - 5));
    }

    @Override
    public void mouseMovedEvent(GraphPanel panel, int xCoord, int yCoord) {

    }
}
class AddEdge implements GraphTool{
    VisualNode selectedNode;
    boolean biDirectional;
    public AddEdge(boolean pBiDirectional){
        biDirectional = pBiDirectional;
    }
    @Override
    public void clickEvent(GraphPanel panel, int xCoord, int yCoord) {
        VisualNode nearest = panel.visualGraph.findNearestNode(xCoord, yCoord);
        //Selects the nearest node if none is selected
        if(selectedNode == null){
            selectedNode = nearest;
        }
        //Creates a new edge if a node is selected and a different node is nearest
        else if(selectedNode != nearest && nearest != null){
            //Creates a visual edge between the two visual nodes
            VisualEdge newEdge = new VisualEdge(selectedNode, nearest, biDirectional);
            //Asks for the length and creates a new edge in the network
            double edgeLength = Double.parseDouble(JOptionPane.showInputDialog(panel, "Please input the length", "Input Length", JOptionPane.PLAIN_MESSAGE));
            newEdge.edge = Edge.newEdge(biDirectional,selectedNode.node, nearest.node, edgeLength);
            System.out.println("Edge created with length " + edgeLength);
            panel.visualGraph.addEdge(newEdge);
            selectedNode = null;
        }
    }

    @Override
    public void mouseMovedEvent(GraphPanel panel, int xCoord, int yCoord) {
        panel.setNearestNode(panel.visualGraph.findNearestNode(xCoord, yCoord));
    }
}
class RemoveEdge implements GraphTool{
    @Override
    public void clickEvent(GraphPanel panel, int xCoord, int yCoord) {
        VisualEdge nearestEdge = panel.visualGraph.findNearestEdge(xCoord, yCoord);
        if(nearestEdge != null){
            panel.visualGraph.deleteEdge(nearestEdge);
            panel.setNearestEdge(null);
        }
    }

    @Override
    public void mouseMovedEvent(GraphPanel panel, int xCoord, int yCoord) {
        panel.setNearestEdge(panel.visualGraph.findNearestEdge(xCoord, yCoord));
    }
}

class RemoveNode implements GraphTool{
    @Override
    public void clickEvent(GraphPanel panel, int xCoord, int yCoord) {
        VisualNode selectedNode = panel.visualGraph.findNearestNode(xCoord, yCoord);
        if(selectedNode != null) {
            panel.visualGraph.deleteNode(selectedNode);
            panel.setNearestNode(null);
        }
    }

    @Override
    public void mouseMovedEvent(GraphPanel panel, int xCoord, int yCoord) {
        panel.setNearestNode(panel.visualGraph.findNearestNode(xCoord, yCoord));
    }
}

