package GraphAnalysis;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

class findShortestPaths{

    HashMap<Node, HashMap<Node, Path>> leastDistances = new HashMap<>();
    HashMap<Node, Boolean> visitedNodes;
    LinkedList<Path> unexploredPaths;
    Network network;
    GraphSearcher caller;

    findShortestPaths(GraphSearcher grap){
        caller = grap;
        network = caller.network;
    }
    HashMap<Node, HashMap<Node, Path>> findShortestDistances(){
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
            leastDistances.put(n, new HashMap<Node, Path>(thisNodePaths));
        }
        return leastDistances;
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
}