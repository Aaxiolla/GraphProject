package GraphAnalysis;

public class Edge {
    double length;
    Node start;
    Node end;
    boolean biDirectional;
    Edge pairing;
    Edge(Node start, Node end, double length){
        this.start = start;
        this.end = end;
        this.length = length;
    }
    //Creates either one or two edge objects to represent a mono or bidirectional edge
    static void newEdge(boolean pbiDirectional, Node pstart, Node pend, double plength){
        //Creates one way edge and adds it to the arrays of connected edges in its connected nodes
        Edge startToEnd = new Edge(pstart, pend, plength);
        pstart.outEdgesList.add(startToEnd);
        pend.inEdgesList.add(startToEnd);
        startToEnd.biDirectional = pbiDirectional;
        //Create a second edge if it is bidirectional and does the same
        if(pbiDirectional){
            Edge endToStart = new Edge(pend, pstart, plength);
            pend.outEdgesList.add(endToStart);
            pstart.inEdgesList.add(endToStart);
            endToStart.biDirectional = true;
            //Gives each edge a reference to its equivalent
            endToStart.pairing = startToEnd;
            startToEnd.pairing = endToStart;
        }
    }
}
