package GraphProjectInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BottomPanel extends JPanel {
    ButtonGroup tools;
    JRadioButton addNode, addEdge, removeNode, removeEdge, addDirectedEdge;
    MainPanel main;
    BottomPanel(MainPanel mainPanel){
        //Create the panel
        this.setBackground(Color.GRAY);
        this.setPreferredSize(new Dimension(200,400));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        main = mainPanel;
        addToolButtons();
    }

    private void addToolButtons(){
        tools = new ButtonGroup();
        //Creates buttons
        addNode = new JRadioButton("Add a node");
        addNode.addActionListener((ActionEvent e) -> main.graphP.setTool(GraphTool.ADDNODE));
        addEdge = new JRadioButton("Add an edge");
        addEdge.addActionListener((ActionEvent e) -> main.graphP.setTool(GraphTool.ADDEDGE));
        addDirectedEdge = new JRadioButton("Add a directed edge");
        addDirectedEdge.addActionListener((ActionEvent e) -> main.graphP.setTool(GraphTool.ADDDIRECTEDEDGE));
        removeNode = new JRadioButton("Remove a node");
        removeNode.addActionListener((ActionEvent e) -> main.graphP.setTool(GraphTool.REMOVENODE));
        removeEdge = new JRadioButton("Remove an edge");
        removeEdge.addActionListener((ActionEvent e) -> main.graphP.setTool(GraphTool.REMOVEEDGE));
        //Adds buttons
        tools.add(addNode);
        tools.add(addEdge);
        tools.add(addDirectedEdge);
        tools.add(removeNode);
        tools.add(removeEdge);
        this.add(addNode);
        this.add(addEdge);
        this.add(addDirectedEdge);
        this.add(removeNode);
        this.add(removeEdge);
    }
}
