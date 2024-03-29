package GraphAnalysis;

import java.util.ArrayList;

public class Path {
    ArrayList<Edge> edges;
    ArrayList<Node> nodes;
    public double length;
    Node start;
    Node end;
    Path(Node newNode){
        edges = new ArrayList<>();
        nodes = new ArrayList<>();
        nodes.add(newNode);
        length = 0;
        start = newNode;
        end = newNode;
    }
    Path(Path cPath, Edge newEdge){
        edges = new ArrayList<>(cPath.edges);
        nodes = new ArrayList<>(cPath.nodes);
        nodes.add(newEdge.end);
        edges.add(newEdge);
        length = cPath.length + newEdge.length;
        start = cPath.start;
        end = newEdge.end;
    }
    Path(Path cPath, Path newPath){
        edges = new ArrayList<>(cPath.edges);
        nodes = new ArrayList<>(cPath.nodes);
        edges.addAll(newPath.edges);
        nodes.addAll(newPath.nodes);
        length = cPath.length + newPath.length;
        start = cPath.start;
        end = newPath.end;
    }
    public void add(Path newPath){
        edges.addAll(newPath.edges);
        nodes.removeLast();
        nodes.addAll(newPath.nodes);
        length += newPath.length;
        end = newPath.end;
    }
    public String toString(){
        String name = "";
        for (Node node: nodes) {
            name += node.name + ", ";
        }
        name += "lenght: " + length;
        return name;
    }
}
