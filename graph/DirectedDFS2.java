package graph;

import common.MyStack;

import java.util.ArrayList;

public class DirectedDFS2 {

    private boolean marked[];
    private int edgeTo[];

    private int s;

    public DirectedDFS2(DiGraph G, int source) {
        s = source;
        marked = new boolean[G.getV().length];
        edgeTo = new int[G.getV().length];
        dfs(G, source);

    }

    public DirectedDFS2(DiGraph G, ArrayList<Integer> sources) {
        marked = new boolean[G.getV().length];
        edgeTo = new int[G.getV().length];
        for (int i : sources){
            dfs(G, i);
        }
    }

    private void dfs(DiGraph G, int v) {
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


    public boolean marked(int v) {
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
