package GraphAnalysis;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

public class GraphSearcher {
    Network network;
    HashMap<Node, HashMap<Node, Path>> tableDistances = new HashMap<>();
    LinkedList<Path> unexploredPaths;
    HashMap<Node, Boolean> visitedNodes;
    GraphSearcher(Network network){
        this.network = network;
    }
    /*
    void findShortestDistances(){
        visitedNodes = new HashMap<>();
        for(Node n : network.nodes){
            for(Node m : network.nodes){
                visitedNodes.put(m, Boolean.FALSE);
            }
            HashMap<Node, Path> thisNodePaths = new HashMap<>();
            unexploredPaths = new LinkedList<>();
            traverse(new Path(n));
            while (!unexploredPaths.isEmpty()){
                Path tempPath = unexploredPaths.pop();
                traverse(tempPath);
                thisNodePaths.put(tempPath.end, tempPath);
            }
            tableDistances.put(n, new HashMap<Node, Path>(thisNodePaths));
        }
    }

    void traverse(Path currentPath){
        //Adds new paths to list
        for(Edge cEdge : currentPath.end.outEdgesList){
            if(!visitedNodes.get(cEdge.end)){
                insertPath(new Path(currentPath, cEdge));
            }
        }
        //Marks the node as visited and removes paths that lead to it
        visitedNodes.put(currentPath.end, Boolean.TRUE);
        unexploredPaths.removeIf(p -> p.end == currentPath.end);
    }
    void insertPath(Path addedPath){
        for (int i = unexploredPaths.size();i >= 0; i--){
            if(i == 0 || unexploredPaths.get(i - 1).length <= addedPath.length){
                unexploredPaths.add(i, addedPath);
                break;
            } else if (addedPath.end == unexploredPaths.get(i - 1).end) {
                unexploredPaths.remove(i - 1);
            }
        }
    }

    */

    Path findTour(){
        //Creates an empty list for paths to visit
        unexploredPaths = new LinkedList<>();
        //Chooses a starting node and visits it
        Path tempPath = new Path(network.nodes.getFirst());
        boolean tourFound = traverseFromMap(tempPath);
        //Repeatedly uses breadth first search until a tour is found
        while(!tourFound){
            tempPath = unexploredPaths.pop();
            tourFound = traverseFromMap(tempPath);
        }
        return tempPath;
    }
    void insertPathFromMap(Path addedPath){
        //Moves through the list until the correct path is found
        ListIterator<Path> listit = unexploredPaths.listIterator(unexploredPaths.size());
        while (listit.hasPrevious()){
            if(listit.previous().length <= addedPath.length){
                break;
            }
        }
        //Adds the path at that position
        unexploredPaths.add(listit.nextIndex(), addedPath);
    }
    boolean traverseFromMap(Path currentPath){
        //flag remains true if the path has explored every node
        boolean flag = true;
        //Adds the shortest path to every node that the current path has not yet visited to the list of unexplored paths
        for (Node inspectNode : network.nodes) {
            if(!currentPath.nodes.contains(inspectNode)){
                insertPathFromMap(new Path(currentPath, tableDistances.get(currentPath.end).get(inspectNode)));
                flag = false;
            }
        }
        if(flag){
            //Returns true if currentPath is a tour
            //Adds the tour to the list if every node is visited but it is not a tour
            if(currentPath.end == currentPath.start){
                return true;
            }else {
                insertPathFromMap(new Path(currentPath, tableDistances.get(currentPath.end).get(currentPath.start)));
            }
        }
        return false;
    }
}

