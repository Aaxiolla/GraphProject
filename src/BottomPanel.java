import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel {
    ButtonGroup tools;
    JRadioButton addNode, addEdge, removeNode, removeEdge;
    BottomPanel(){
        //Create the panel
        this.setBackground(Color.GRAY);
        this.setPreferredSize(new Dimension(200,400));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        addToolButtons();
    }

    private void addToolButtons(){
        tools = new ButtonGroup();
        //Creates buttons
        addNode = new JRadioButton("Add a node");
        addEdge = new JRadioButton("Add an edge");
        removeNode = new JRadioButton("Remove an node");
        removeEdge = new JRadioButton("Remove an edge");
        //Adds buttons
        tools.add(addNode);
        tools.add(addEdge);
        tools.add(removeNode);
        tools.add(removeEdge);
        this.add(addNode);
        this.add(addEdge);
        this.add(removeNode);
        this.add(removeEdge);
    }
}
