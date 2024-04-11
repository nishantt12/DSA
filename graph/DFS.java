package graph;

import common.MyStack;

public class DFS {

    private boolean marked[];
    private int edgeTo[];

    private int s;

    public DFS(Graph G, int source) {
        s = source;
        marked = new boolean[G.getV().length];
        edgeTo = new int[G.getV().length];
        dfs(G, source);

    }

    private void dfs(Graph G, int v) {
        marked[v] = true;

        for (int i : G.getConnectedVertices(v)) {
            if (!marked[i]) {
                edgeTo[i] = v;
                dfs(G, i);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }


    public MyStack<Integer> getPath(int v) {
        if(!marked[v]) {
            return null;
        }
        MyStack<Integer> myStack = new MyStack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            myStack.push(x);
        }
        myStack.push(s);
        return myStack;
    }

}
