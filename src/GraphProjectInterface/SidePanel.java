package GraphProjectInterface;

import GraphAnalysis.GraphSearcher;
import GraphAnalysis.Network;
import GraphAnalysis.Node;
import GraphAnalysis.Path;
import com.sun.net.httpserver.Headers;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;

public class SidePanel extends JPanel {
    JTable leastDistances;
    JLabel results;
    JScrollPane scrollPane;
    PrimaryFrame main;
    GraphSearcher graphSearcher;
    JButton traverseGraph;
    SidePanel(PrimaryFrame main){
        this.setBackground(Color.DARK_GRAY);
        this.setPreferredSize(new Dimension(500, 900));
        this.main = main;
        traverseGraph = new JButton("Traverse");
        traverseGraph.addActionListener((ActiveEvent) -> findLeastDistances());
        this.add(traverseGraph);
        //scrollPane = new JScrollPane(leastDistances);
    }
    void findLeastDistances(){
        try {
            //Removes any existing results
            if (results != null) {
                this.remove(results);
                revalidate();
            }
            if (scrollPane != null) {
                this.remove(scrollPane);
                revalidate();
            }
            graphSearcher = new GraphSearcher(main.mainPanel.graphP.visualGraph.network);
            //Finds the table of least distances
            HashMap<Node, HashMap<Node, Path>> leastDistanceMap = graphSearcher.findShortestDistances();
            String[] headers = new String[leastDistanceMap.size() + 1];
            headers[0] = "Nodes";
            String[][] tableContents = new String[leastDistanceMap.size()][leastDistanceMap.size() + 1];
            int counter1 = 0;
            //iterates through the table to add data
            for (VisualNode node : main.mainPanel.graphP.visualGraph.nodes) {
                headers[counter1 + 1] = node.name;
                tableContents[counter1][0] = node.name;
                int counter2 = 0;
                for (VisualNode currentNode : main.mainPanel.graphP.visualGraph.nodes) {
                    counter2++;
                    if (currentNode == node) {
                        //Adds a dash for every node to itself
                        tableContents[counter1][counter2] = "-";
                        continue;
                    }
                    if (!leastDistanceMap.get(node.node).containsKey(currentNode.node)) {
                        throw new RuntimeException(String.format("Cannot solve the problem as node %s cannot be reached from node %s so the network is not connected", currentNode.name, node.name));
                    }
                    tableContents[counter1][counter2] = Double.toString(leastDistanceMap.get(node.node).get(currentNode.node).length);
                }
                counter1++;
            }
            //creates a new table that cannot be edited
            leastDistances = new JTable(tableContents, headers) {
                public boolean editCellAt(int row, int column, java.util.EventObject e) {
                    return false;
                }
            };
            leastDistances.setPreferredSize(new Dimension(400, 200));
            scrollPane = new JScrollPane(leastDistances);
            scrollPane.setPreferredSize(new Dimension(450, 200));
            this.add(scrollPane);
            //Finds the shortest path using ant colony optimisation and adds the results
            graphSearcher.antColonyOptimise();
            results = new JLabel(graphSearcher.pathFound.toString());
            results.setForeground(Color.WHITE);
            add(results);
            revalidate();
        }catch (RuntimeException r){
            JOptionPane.showMessageDialog(this, r.getMessage(), "Graph not connected", JOptionPane.ERROR_MESSAGE);
        }
    }
}
