package GraphAnalysis;

import java.sql.Time;
import java.util.*;
import java.util.function.BiConsumer;

public class GraphSearcher {
    public Network network;
    HashMap<Node, HashMap<Node, Path>> tableDistances = new HashMap<>();
    HashMap<Node, HashMap<Node, Double>> phermoneStrenght;
    Random antGod = new Random();
    public GraphSearcher(Network network){
        this.network = network;
    }
    void antColonyOptimise(){
        phermoneStrenght = new HashMap<>();
        for(Node currentNode1 : network.nodes){
            HashMap<Node, Double> fromThisNode = new HashMap<>();
            for(Node currentNode2 : network.nodes){
                fromThisNode.put(currentNode2, 1.0);
            }
            phermoneStrenght.put(currentNode1, fromThisNode);
        }
        iterateAnts();
    }
    void iterateAnts(){
        Ant[] ants = new Ant[5];
        for(int i = 0; i < 5; i++){
            ants[i] = new Ant(network.nodes.getFirst(), this);
            ants[i].Tour();
        }
        for(Node currentNode1 : network.nodes){
            for(Node currentNode2 : network.nodes){
                double val = phermoneStrenght.get(currentNode1).get(currentNode2);
                phermoneStrenght.get(currentNode1).put(currentNode2, val * 0.7);
            }
        }
    }
    Node chooseAntPath(Node fromNode, ArrayList<Node> allowed){
        HashMap<Node, Double> desireability = new HashMap<>();
        double sum = 0;
        for(Node currentNode : allowed){
            double d = phermoneStrenght.get(fromNode).get(currentNode) * (10.0 / tableDistances.get(fromNode).get(currentNode).length);
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
        antColonyOptimise();
        tableDistances = new findShortestPaths(this).findShortestDistances();
        return tableDistances;
    }

}

