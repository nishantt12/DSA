package graph;

import java.util.ArrayList;
import java.util.List;

public class FlowNetwork {

    private final int V;

    private List<FlowEdge>[] adj;


    public FlowNetwork(int v) {
        V = v;
        adj = new ArrayList[V];

        for (int i = 0; i< V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(FlowEdge e){
        int v = e.from();
        int w = e.to();

        adj[v].add(e);
        adj[w].add(e);
    }

    public List<FlowEdge> adj(int v){
        return adj[v];
    }

    public int V(){
        return V;
    }
}
