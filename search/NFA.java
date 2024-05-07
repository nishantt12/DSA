package search;

import graph.DiGraph;
import graph.DirectedDFS2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NFA {

    private char[] re;
    private DiGraph G;
    private int M;

    public NFA(String regexp) {
        M = regexp.length();
        re = regexp.toCharArray();
        G = buildEpsilonTransitionDigraph1();
        for (List<Integer> c: G.getV()){
            System.out.println("G: "+c);
        }

    }

    public boolean recognizes1(String txt) {
        ArrayList<Integer> pc = new ArrayList<Integer>();
        DirectedDFS2 dfs = new DirectedDFS2(G, 0);
        for (int v = 0; v < G.V(); v++)
            if (dfs.marked(v)) pc.add(v);
        for (int i = 0; i < txt.length(); i++)
        {
            ArrayList<Integer> states = new ArrayList<Integer>();
            for (int v : pc)
            {
                if (v == M) continue;
                if ((re[v] == txt.charAt(i)) || re[v] == '.')
                    states.add(v+1);
            }

            dfs = new DirectedDFS2(G, states);
            pc = new ArrayList<Integer>();
            for (int v = 0; v < G.V(); v++)
                if (dfs.marked(v)) pc.add(v);
        }
        for (int v : pc)
            if (v == M) return true;
        return false;
    }

    private DiGraph buildEpsilonTransitionDigraph1() {
        DiGraph G = new DiGraph(M+1);
        Stack<Integer> ops = new Stack<Integer>();
        for (int i = 0; i < M; i++) {
            int lp = i;

            if (re[i] == '(' || re[i] == '|') ops.push(i);

            else if (re[i] == ')') {
                int or = ops.pop();
                if (re[or] == '|') {
                    lp = ops.pop();
                    G.addEdge(lp, or+1);
                    G.addEdge(or, i);
                }
                else lp = or;
            }
            if (i < M-1 && re[i+1] == '*') {
                G.addEdge(lp, i+1);
                G.addEdge(i+1, lp);
            }

            if (re[i] == '(' || re[i] == '*' || re[i] == ')')
                G.addEdge(i, i+1);
        }
        return G;
    }

    public boolean recognizes(String text) {
        ArrayList<Integer> pc = new ArrayList<>();
        DirectedDFS2 dfs = new DirectedDFS2(G, 0);
        for (int v = 0; v < G.V(); v++) {
            if (dfs.marked(v)) {
                pc.add(v);
            }
        }

        for (int i = 0; i < text.length(); i++) {
            ArrayList<Integer> states = new ArrayList<>();

            for (int v : pc) {
                if (v == M) {
                    continue;
                }
                if ((re[v] == text.charAt(i)) || re[v] == '.') {
                    states.add(v + 1);
                }
            }

            dfs = new DirectedDFS2(G, states);
            pc = new ArrayList<>();
            for (int v = 0; v < G.V(); v++) {
                if (dfs.marked(v)) {
                    pc.add(v);
                }
            }
        }

        for (int v : pc) {
            if (v == M) {
                return true;
            }
        }
        return false;
    }

    private DiGraph buildEpsilonTransitionDigraph() {
        DiGraph G = new DiGraph(M + 1);
        Stack<Integer> ops = new Stack<>();
        for (int i = 0; i < M; i++) {
            int lp = i;
            if (re[i] == '(' || re[i] == '|') {
                ops.push(i);
            } else if (re[i] == ')') {
                int or = ops.pop();
                if (re[or] == '|') {
                    lp = ops.pop();
                    G.addEdge(lp, or + 1);
                    G.addEdge(or, i);
                } else {
                    lp = or;
                }
            }

            if (i < M-1 && re[i+1] == '*'){
                G.addEdge(lp, i+1);
                G.addEdge(i+1, lp);
            }

            if (re[i] == '(' || re[i] == '*' || re[i] == ')'){
                G.addEdge(i, i+1);
            }
        }
        return G;
    }
}
