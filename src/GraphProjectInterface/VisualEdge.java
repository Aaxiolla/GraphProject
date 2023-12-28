package GraphProjectInterface;

import GraphAnalysis.Edge;

public class VisualEdge {
    VisualNode start;
    VisualNode end;
    int startx, starty, endx, endy, xlenght, ylenght, textx, texty;
    double squaredLength;
    boolean biDirectional;
    Edge edge;
    VisualEdge(VisualNode startNode, VisualNode endNode, boolean pBiDirectional){
        biDirectional = pBiDirectional;
        start = startNode;
        end = endNode;
        startx = start.x + 5;
        starty = start.y + 5;
        endx = end.x + 5;
        endy = end.y + 5;
        xlenght = endx - startx;
        ylenght = endy - starty;
        squaredLength = squaredDistance(startx, starty, endx, endy);
        textx = Math.round((float)(startx + endx) / 2 - 5);
        texty = Math.round((float)(starty + endy) / 2);
    }
    double squaredDistanceFromEdge(int x1, int y1){
        double position = ((x1 - startx) * (xlenght) + (y1 - starty) * (ylenght)) / squaredLength;
        position = Math.clamp(position,0.0, 1.0);
        return squaredDistance(startx + position * xlenght, starty + position * ylenght, x1, y1);
    }
    double squaredDistance(double x1,double y1,double x2, double y2 ){
        return (x1 - x2) * (x1 - x2) + (y1 -y2) * (y1 - y2);
    }
}
