package GraphProjectInterface;



import javax.swing.*;
import javax.swing.event.MouseInputListener;
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
        nearestNode = null;
        nearestEdge =  null;
    }
    void setNearestNode(VisualNode node){
        if(node != nearestNode){
            nearestNode = node;
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
            System.out.println("Painted yellow node");
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
