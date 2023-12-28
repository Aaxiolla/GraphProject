package GraphProjectInterface;



import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GraphPanel extends JPanel implements MouseListener, MouseMotionListener {
    public GraphTool myTool;
    VisualGraph visualGraph;
    VisualNode nearestNode;
    VisualEdge nearestEdge;

    GraphPanel(){
        this.setBackground(Color.black);
        this.setLayout(null);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        visualGraph = new VisualGraph();
        myTool = new AddNode();
    }
    public void setTool(GraphTool tool){
        myTool = tool;
        setNearestNode(null);
        setNearestEdge(null);
    }
    void setNearestNode(VisualNode node){
        if(node != nearestNode){
            nearestNode = node;
            repaint();
        }
    }
    void setNearestEdge(VisualEdge edge){
        if(edge != nearestEdge){
            nearestEdge = edge;
            repaint();
        }
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.LIGHT_GRAY);
        for (VisualEdge edge: visualGraph.edges) {
            g2d.drawLine(edge.startx, edge.starty, edge.endx, edge.endy);
        }
        g2d.setPaint(Color.WHITE);
        for(VisualNode node : visualGraph.nodes){
            g2d.fillOval(node.x, node.y, 10, 10);
        }
        if(nearestNode != null){
            g2d.setPaint(Color.YELLOW);
            g2d.fillOval(nearestNode.x, nearestNode.y, 10, 10);
        }
        if(nearestEdge != null){
            g2d.setPaint(Color.YELLOW);
            g2d.drawLine(nearestEdge.startx, nearestEdge.starty, nearestEdge.endx, nearestEdge.endy);
        }

        for (VisualEdge edge : visualGraph.edges){
            g2d.setPaint(Color.LIGHT_GRAY);
            g2d.fillRect(edge.textx - 3, edge.texty - 10, 40, 12);
            g2d.setPaint(Color.BLACK);
            g2d.drawString(Double.toString(edge.edge.length), edge.textx, edge.texty);
        }
        for (VisualNode node : visualGraph.nodes){
            g2d.setPaint(Color.LIGHT_GRAY);
            g2d.fillRect(node.x, node.y - 15, 15, 12);
            g2d.setPaint(Color.YELLOW);
            g2d.drawString(node.name, node.x, node.y - 5);
        }
    }


    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        myTool.mouseMovedEvent(this, e.getX(), e.getY());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        myTool.clickEvent(this, e.getX(), e.getY());
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {}
}
