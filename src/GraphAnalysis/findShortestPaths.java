package GraphAnalysis;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

class findShortestPaths implements Runnable{
    Thread t;
    HashMap<Node, Boolean> visitedNodes;
    LinkedList<Path> unexploredPaths;
    Network network;
    GraphSearcher caller;
    Node startNode;
    findShortestPaths(GraphSearcher grap, Node startNode){
        t = new Thread(this);
        caller = grap;
        network = caller.network;
        this.startNode = startNode;
    }
    public void run(){
        //Creates a hashmap with each node and whether it has been visited
        visitedNodes = new HashMap<>();
        for(Node m : network.nodes){
            visitedNodes.put(m, Boolean.FALSE);
        }
        //Creates a hashmap for storing the shortest paths and a list for paths to explore
        HashMap<Node, Path> thisNodePaths = new HashMap<>();
        unexploredPaths = new LinkedList<>();
        //Traverses the start node then repeatedly traverses the path at the front of the list until every shortest path is found
        traverse(new Path(startNode));
        while (!unexploredPaths.isEmpty()){
            Path tempPath = unexploredPaths.pop();
            traverse(tempPath);
            thisNodePaths.put(tempPath.end, tempPath);
        }
        //Adds the shortest paths to the table from the calling class
        caller.tableDistances.put(startNode, new HashMap<>(thisNodePaths));
    }
    void traverse(Path currentPath){
        //Marks the node as visited and removes paths that lead to it
        visitedNodes.put(currentPath.end, Boolean.TRUE);
        unexploredPaths.removeIf(p -> p.end == currentPath.end);
        //Adds new paths to list
        for(Edge cEdge : currentPath.end.outEdgesList){
            if(!visitedNodes.get(cEdge.end)){
                insertPath(new Path(currentPath, cEdge));
            }
        }
    }
    void insertPath(Path addedPath){
        //Moves through the list until it finds the correct position to add the path
        ListIterator<Path> listit = unexploredPaths.listIterator(unexploredPaths.size());
        while (listit.hasPrevious()){
            Path pathExamined = listit.previous();
            if(pathExamined.length <= addedPath.length){
                break;
            }else if (addedPath.end == pathExamined.end) {
                //Removes any paths with the same destination that are longer
                unexploredPaths.remove(pathExamined);
            }
        }
        //Adds the path
        unexploredPaths.add(listit.nextIndex(), addedPath);
    }
}