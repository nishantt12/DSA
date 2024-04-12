package graph;

import common.MyQueue;

public class FordFulkerson {
    private boolean marked[];

    private FlowEdge[] edgeTo;

    private double value;

    public FordFulkerson(FlowNetwork G, int s, int t) {
        value = 0.0;

        while (hasAugmentingPath(G, s, t)) {
            double bottle = Double.POSITIVE_INFINITY;
            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));
            }

            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                edgeTo[v].addResidualFlowTo(v, bottle);
            }

            value += bottle;
        }
    }

    private boolean hasAugmentingPath(FlowNetwork G, int s, int t) {
        edgeTo = new FlowEdge[G.V()];
        marked = new boolean[G.V()];
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.enqueue(s);
        marked[s] = true;
        while (!myQueue.isEmpty()) {
            int v = myQueue.dequeue();
            for (FlowEdge flowEdge : G.adj(v)) {
                int w = flowEdge.other(v);
                if (flowEdge.residualCapacityTo(w) > 0 && !marked[w]) {
                    edgeTo[w] = flowEdge;
                    marked[w] = true;
                    myQueue.enqueue(w);
                }
            }
        }
        return marked[t];
    }

    public double getValue() {
        return value;
    }

    public boolean inCut(int v) {
        return marked[v];
    }
}
