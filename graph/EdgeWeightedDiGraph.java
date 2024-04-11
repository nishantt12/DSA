package graph;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedDiGraph {

    private final List<DirectedEdge>[] adsList;

    public EdgeWeightedDiGraph(int V) {
        adsList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adsList[i] = new ArrayList<>();
        }
    }

    public void addEdge(DirectedEdge directedEdge) {
        int v = directedEdge.from();
        adsList[v].add(directedEdge);
    }

    public List<DirectedEdge>[] getV() {
        return adsList;
    }

    public int V() {
        return adsList.length;
    }

    public List<DirectedEdge> getConnectedVertices(int v) {
        return adsList[v];
    }

}
