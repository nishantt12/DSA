package graph;

import common.MyStack;
import sort.IndexedMinPQ;
import sort.IndexedMixPQTest;

public class DijkstraSP {

    private double distTo[];
    private DirectedEdge edgeTo[];

    private IndexedMixPQTest<Double> indexedMinPQ;
    private int source;

    public DijkstraSP(EdgeWeightedDiGraph graph, int source) {
        indexedMinPQ = new IndexedMixPQTest<>(graph.getV().length);
        distTo = new double[graph.V()];
        edgeTo = new DirectedEdge[graph.V()];
        this.source = source;
        for (int i = 0; i< graph.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }

        distTo[source] = 0.0;
        indexedMinPQ.insert(source, 0.0);
        path(graph);
    }

    private void path(EdgeWeightedDiGraph graph) {
        while (!indexedMinPQ.isEmpty()) {
            int v = indexedMinPQ.delMin();

            for (DirectedEdge directedEdge: graph.getV()[v]){
                relax(directedEdge);
            }
        }
    }

    private void relax(DirectedEdge directedEdge){
        int v = directedEdge.from();
        int w = directedEdge.to();

        if(distTo[w] > distTo[v] + directedEdge.weight()) {
            distTo[w] = distTo[v] + directedEdge.weight();
            edgeTo[w] = directedEdge;
            if(indexedMinPQ.contains(w)) {
                indexedMinPQ.decreaseKey(w, directedEdge.weight());
            } else {
                indexedMinPQ.insert(w, directedEdge.weight());
            }
        }

    }


    public MyStack<Integer> getPath(int v) {
        MyStack<Integer> myStack = new MyStack<>();
        for (int x = v; x != source && edgeTo[x]!=null; x = edgeTo[x].from()) {
            myStack.push(x);
        }
        myStack.push(source);
        return myStack;
    }

    public double getDistanceTo(int v) {
        return distTo[v];
    }



}
