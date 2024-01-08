package GraphAnalysis;

import java.util.ArrayList;

public class Ant {
    Path path;
    ArrayList<Node> unvisitedNodes;
    ArrayList<Node> visitedNodes;
    Node startNode;
    GraphSearcher searcher;
    Ant(Node start, GraphSearcher graphSearcher){
        searcher = graphSearcher;
        startNode = start;
        unvisitedNodes = new ArrayList<>(graphSearcher.network.nodes);
        unvisitedNodes.remove(startNode);
        path = new Path(startNode);
        visitedNodes = new ArrayList<>(visitedNodes.size() + 1);
    }

    void Tour(){
        for (Node currentNode : unvisitedNodes) {

        }
    }
}
