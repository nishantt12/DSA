package graph;

import common.Comparable;

public class EdgeDistance implements Comparable<EdgeDistance> {

    private final int edge;
    private final int distance;

    public EdgeDistance(int edge, int distance) {
        this.edge = edge;
        this.distance = distance;
    }

    @Override
    public int compareTo(EdgeDistance that) {
        if(this.distance < that.distance) return -1;
        if(this.distance > that.distance) return 1;
        else return 0;
    }
}
