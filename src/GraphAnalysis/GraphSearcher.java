package GraphAnalysis;


import java.util.*;


public class GraphSearcher {
    public Network network;
    HashMap<Node, HashMap<Node, Path>> tableDistances = new HashMap<>();
    HashMap<Node, HashMap<Node, Double>> phermoneStrenght;
    Random antGod = new Random();
    public Path pathFound;

    public GraphSearcher(Network network){
        this.network = network;
    }
    public void antColonyOptimise(){
        phermoneStrenght = new HashMap<>();
        for(Node currentNode1 : network.nodes){
            HashMap<Node, Double> fromThisNode = new HashMap<>();
            for(Node currentNode2 : network.nodes){
                fromThisNode.put(currentNode2, 1.0);
            }
            phermoneStrenght.put(currentNode1, fromThisNode);
        }
        int max = Math.min(1000,(int) Math.pow( network.nodes.size(), 4));
        for(int count = 0;count < max; count++){
            iterateAnts();
        }
    }
    void iterateAnts(){
        Ant[] ants = new Ant[12];
        for(int i = 0; i < 12; i++){
            ants[i] = new Ant(network.nodes.getFirst(), this);
            ants[i].tour();
        }
        for(Node currentNode1 : network.nodes){
            for(Node currentNode2 : network.nodes){
                double value = phermoneStrenght.get(currentNode1).get(currentNode2);
                phermoneStrenght.get(currentNode1).put(currentNode2, value * 0.5);
            }
        }
        for(Ant currentAnt: ants){
            if(pathFound == null || currentAnt.path.length < pathFound.length ){
                pathFound = currentAnt.path;
            }
            double addedStrenght = 100.0 / currentAnt.path.length;
            for(int i = 0;i < currentAnt.visitedNodes.size() - 1; i++){
                double value = phermoneStrenght.get(currentAnt.visitedNodes.get(i)).get(currentAnt.visitedNodes.get(i + 1));
                phermoneStrenght.get(currentAnt.visitedNodes.get(i)).put(currentAnt.visitedNodes.get(i + 1), value + addedStrenght);
            }
        }
    }
    Node chooseAntPath(Node fromNode, ArrayList<Node> allowed){
        HashMap<Node, Double> desireability = new HashMap<>();
        double sum = 0;
        for(Node currentNode : allowed){
            double d = Math.pow(phermoneStrenght.get(fromNode).get(currentNode), 2) * Math.pow(10.0 / tableDistances.get(fromNode).get(currentNode).length, 3);
            sum += d;
            desireability.put(currentNode, d);
        }
        double choice = antGod.nextDouble(0.0, 1.0);
        for(Node currentNode: allowed){
            choice -= desireability.get(currentNode) / sum;
            if(choice <= 0){
                return currentNode;
            }
        }
        return null;
    }
    public HashMap<Node, HashMap<Node, Path>> findShortestDistances(){
        tableDistances = new findShortestPaths(this).findShortestDistances();
        return tableDistances;
    }

}

