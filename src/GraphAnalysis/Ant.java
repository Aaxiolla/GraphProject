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
        visitedNodes = new ArrayList<>();
        visitedNodes.add(startNode);
    }

    void tour(){
        Node currentNode = startNode;
        while (!unvisitedNodes.isEmpty()){
            Node nextNode = searcher.chooseAntPath(currentNode, unvisitedNodes);
            Path newPath = searcher.tableDistances.get(currentNode).get(nextNode);
            path.add(newPath);
            for (Node traversedNode : newPath.nodes) {
                if (unvisitedNodes.contains(traversedNode)) {
                    unvisitedNodes.remove(traversedNode);
                    visitedNodes.add(traversedNode);
                }
            }
            currentNode = nextNode;
        }
        path.add(searcher.tableDistances.get(currentNode).get(startNode));

    }
}
