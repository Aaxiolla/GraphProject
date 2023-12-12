package GraphProjectInterface;



import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class GraphPanel extends JPanel implements MouseMotionListener, MouseInputListener {
    GraphTool currentTool;
    GraphPanel(){
        this.setBackground(Color.black);
        this.setLayout(null);
    }
    void setTool(GraphTool tool){
        currentTool = tool;
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
