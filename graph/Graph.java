package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private final List<Integer>[] adsList;

    public Graph(int V) {
        adsList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adsList[i] = new ArrayList<>();
        }
    }


    public void addEdge(int v, int w) {
        adsList[v].add(w);
        adsList[w].add(v);
    }

    public List<Integer>[] getV() {
        return adsList;
    }

    public List<Integer> getConnectedVertices(int v) {
        return adsList[v];
    }
}
