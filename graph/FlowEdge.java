package graph;

public class FlowEdge {

    private double flow;

    private final double capacity;

    private final int v, w;

    public FlowEdge(double capacity, int v, int w) {
        this.capacity = capacity;
        this.v = v;
        this.w = w;
    }

    public double flow() {
        return flow;
    }

    public double getCapacity() {
        return capacity;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public int other(int vertex) {
        if (vertex == v) return w;
        if (vertex == w) return v;

        throw new IllegalStateException("Value not present");
    }

    public double residualCapacityTo(int vertex) {
        if (vertex == v) {
            return flow;
        }
        if (vertex == w) {
            return capacity - flow;
        }
        throw new IllegalStateException("Value not present");

    }

    public void addResidualFlowTo(int vertex, double delta) {
        if (vertex == v) {
            flow -= delta;
        }
        if (vertex == w) {
            flow += delta;
        }
    }
}
