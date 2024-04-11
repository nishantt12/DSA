package graph;

import common.MyQueue;
import common.MyStack;

public class BFS {

    private final boolean marked[];
    private final int edgeTo[];
    private final int s;

    private final MyQueue<Integer> myQueue;

    public BFS(Graph G, int source) {
        s = source;
        marked = new boolean[G.getV().length];
        edgeTo = new int[G.getV().length];
        myQueue = new MyQueue();
        myQueue.enqueue(source);
        bfs(G);
    }

    private void bfs(Graph G) {
        while (!myQueue.isEmpty()){
            int value = myQueue.dequeue();
            System.out.println("Value: "+value);
            marked[value] = true;
            for (int i : G.getConnectedVertices(value)) {
                if (!marked[i]) {
                    edgeTo[i] = value;
                    marked[i] = true;
                    System.out.println("i: "+i+"  "+value);
                    myQueue.enqueue(i);
                }
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
