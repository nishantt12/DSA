package graph;

import common.MyStack;

public class DirectedDFS<T> {

    T[] arr;
    private boolean marked[];
    private boolean recursionStack[];
    private int edgeTo[];

    private int s;

    public DirectedDFS(DiGraph G, int source) {
        s = source;
        arr = (T[]) new Object[10];
        int length = G.getV().length;
        marked = new boolean[length];
        recursionStack = new boolean[length];
        edgeTo = new int[length];
        for (int i =0; i<length; i++){
            if(!marked[i]){
                dfs(G, i);
            }

        }

    }

    private void dfs(DiGraph G, int v) {
        marked[v] = true;
        recursionStack[v] = true;
        for (int i : G.getConnectedVertices(v)) {
            if (!marked[i]) {
                edgeTo[i] = v;
                dfs(G, i);
            } else if (recursionStack[i]){
                System.out.println("Cycle detected: "+v +" to: "+i);
                return;
            }
        }
        recursionStack[v] = false;
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
