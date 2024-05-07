package graph;

import java.util.ArrayList;
import java.util.List;

public class DiGraph {

    private final List<Integer>[] adsList;

    private int V;

    public DiGraph(int V) {
        this.V = V;
        adsList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adsList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {
        adsList[v].add(w);
    }

    public List<Integer>[] getV() {
        return adsList;
    }

    public int V() {
        return V;
    }

    public List<Integer> getConnectedVertices(int v) {
        return adsList[v];
    }

}
