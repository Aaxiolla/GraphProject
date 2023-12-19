package GraphProjectInterface;

import GraphAnalysis.Node;

import java.awt.event.MouseEvent;

public interface GraphTool {
    public void clickEvent(GraphPanel panel, int xCoord, int yCoord);

    public void mouseMovedEvent(GraphPanel panel, int xCoord, int yCoord);
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
    @Override
    public void clickEvent(GraphPanel panel, int xCoord, int yCoord) {

    }

    @Override
    public void mouseMovedEvent(GraphPanel panel, int xCoord, int yCoord) {
        System.out.println("finding nearest node");
        panel.setNearestNode(panel.visualGraph.findNearestNode(xCoord, yCoord));
    }
}
class RemoveEdge implements GraphTool{
    @Override
    public void clickEvent(GraphPanel panel, int xCoord, int yCoord) {

    }

    @Override
    public void mouseMovedEvent(GraphPanel panel, int xCoord, int yCoord) {

    }
}

class AddDirectedEdge implements GraphTool{
    @Override
    public void clickEvent(GraphPanel panel, int xCoord, int yCoord) {

    }

    @Override
    public void mouseMovedEvent(GraphPanel panel, int xCoord, int yCoord) {

    }
}
class RemoveNode implements GraphTool{
    @Override
    public void clickEvent(GraphPanel panel, int xCoord, int yCoord) {

    }

    @Override
    public void mouseMovedEvent(GraphPanel panel, int xCoord, int yCoord) {

    }
}

