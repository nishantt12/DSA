import common.HashMap;
import common.MyInteger;
import common.MyIterator;
import common.MyQueue;
import graph.*;
import radix.KeyIndexCounting;
import radix.LCP;
import radix.LSD;
import search.KMP;
import search.NFA;
import sort.*;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		NFA();
	}

	private static void NFA() {
		NFA nfa = new NFA("((A*B|AC)D)");
		boolean isRecognized = nfa.recognizes1("AAABD");
		print(isRecognized);
	}

	private static void KMP() {

		KMP kmp = new KMP("HELLO");

		int textPointer = kmp.search("YELLhhhhWHELLOTELLO");

		print(textPointer);
	}

	private static void lcp() {

		String first = "ELLO";
		String second = "HELLOYOYO";
		print(LCP.lcp(first, second));
	}

	private static void lsd() {

		String array[] = {"Hello", "AAAAA", "DDDDD", "BBBBB", "CCCCC" ,"11111"};
		print(array);
		LSD.sort(array, 5);
		print(array);
	}

	private static void keyIndexCounting() {

		char array[] = {'b', 'a', 'c', 'a', 'b', 'b', 'c'};
		print(array);
		KeyIndexCounting.sort(array);
		print(array);
	}

	private static FlowNetwork getFlowNetWork() {
		FlowNetwork graph = new FlowNetwork(10);

		graph.addEdge(new FlowEdge(50, 0, 1));
		graph.addEdge(new FlowEdge(50, 1, 2));
		graph.addEdge(new FlowEdge(50, 1, 4));
		graph.addEdge(new FlowEdge(10, 2, 4));
		graph.addEdge(new FlowEdge(20, 3, 4));
		graph.addEdge(new FlowEdge(70, 0, 3));
		graph.addEdge(new FlowEdge(10, 6, 7));

		return graph;
	}

	private static void fordFulkerson() {
		FordFulkerson fordFulkerson = new FordFulkerson(getFlowNetWork(), 0, 4);

		print(fordFulkerson.getValue());
		print(fordFulkerson.inCut(4));
		print(fordFulkerson.inCut(6));
	}

	private static void dijkstraSP() {
		EdgeWeightedDiGraph graph = getEdgeWeightedDiGraph();

		DijkstraSP dfs = new DijkstraSP(graph, 0);

		MyIterator iterator4 = dfs.getPath(4).iterator();
		MyIterator iterator2 = dfs.getPath(2).iterator();
		while (iterator4.hasNext()){
			print("Path to 4: "+iterator4.next());
		}

		while (iterator2.hasNext()){
			print("Path to 3: "+iterator2.next());
		}

		print("Dist to 4: "+dfs.getDistanceTo(4));
		print("Dist to 2: "+dfs.getDistanceTo(2));

	}

	private static EdgeWeightedDiGraph getEdgeWeightedDiGraph() {
		EdgeWeightedDiGraph graph = new EdgeWeightedDiGraph(7);

		graph.addEdge(new DirectedEdge(0, 1, 2));
		graph.addEdge(new DirectedEdge(1, 2, 3));
		graph.addEdge(new DirectedEdge(1, 4, 1));
		graph.addEdge(new DirectedEdge(2, 4, 4));
		graph.addEdge(new DirectedEdge(3, 4, 1));
		graph.addEdge(new DirectedEdge(0, 3, 3));

		return graph;
	}

	private static void diDfs() {
		DiGraph graph = getDiGraph();

		DirectedDFS dfs = new DirectedDFS(graph, 0);

		print("has path: "+dfs.hasPathTo(5));
		print("has path: "+dfs.hasPathTo(3));
		MyIterator iterator = dfs.getPath(4).iterator();
		while (iterator.hasNext()){
			print("Path to 4: "+iterator.next());
		}

	}

	private static void bfs() {
		Graph graph = getGraph();

		BFS bfs = new BFS(graph, 0);

		print("has path: "+bfs.hasPathTo(5));
		print("has path: "+bfs.hasPathTo(3));
		MyIterator iterator = bfs.getPath(4).iterator();
		while (iterator.hasNext()){
			print("Path to 4: "+iterator.next());
		}

	}

	private static void dfs() {
		Graph graph = getGraph();

		DFS dfs = new DFS(graph, 0);

		print("has path: "+dfs.hasPathTo(5));
		print("has path: "+dfs.hasPathTo(3));
		MyIterator iterator = dfs.getPath(4).iterator();
		while (iterator.hasNext()){
			print("Path to 4: "+iterator.next());
		}

	}

	private static Graph getGraph() {
		Graph graph = new Graph(6);

		graph.addEdge(0, 1);
		graph.addEdge(2, 0);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);

		return graph;
	}

	private static DiGraph getDiGraph() {
		DiGraph graph = new DiGraph(7);

		graph.addEdge(0, 1);
		graph.addEdge(2, 0);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(5, 0);

		return graph;
	}

	private static void minPQ() {
		MinPQ<MyInteger> binaryHeap = new MinPQ<>(10);

		binaryHeap.insert(new MyInteger(4));
		binaryHeap.insert(new MyInteger(3));
		binaryHeap.insert(new MyInteger(7));
		binaryHeap.insert(new MyInteger(1));
		binaryHeap.insert(new MyInteger(9));
		binaryHeap.insert(new MyInteger(2));
		binaryHeap.insert(new MyInteger(0));

		System.out.println(Arrays.toString(binaryHeap.getHeap()));
		System.out.println(binaryHeap.deleteMin());
		System.out.println(binaryHeap.deleteMin());
		System.out.println(binaryHeap.deleteMin());
		System.out.println(Arrays.toString(binaryHeap.getHeap()));


	}

	private static void hashMap(){
		common.HashMap<String, String> hashMap = new HashMap<>();

		hashMap.put("Nishu", "Nishant");
		hashMap.put("Mannu", "Rishabh");
		hashMap.put("Bubu", "Shreena");

		print(hashMap.get("Bubu"));
		print(hashMap.get("Nishu"));
	}

	private static void RedBlackBST() {
		RedBlackBST<MyInteger, Integer> bst = new RedBlackBST<>();

		bst.put(new MyInteger(0), 0);
		bst.put(new MyInteger(1), 1);
		bst.put(new MyInteger(2), 2);
		bst.put(new MyInteger(3), 3);
		bst.put(new MyInteger(4), 4);
		bst.put(new MyInteger(5), 5);
		bst.put(new MyInteger(6), 6);

//		System.out.println(bst.get(new common.MyInteger(2)));
//		System.out.println(bst.get(new common.MyInteger(5)));
//		System.out.println(bst.get(new common.MyInteger(9)));
		bst.inOrder();
		System.out.println("Depth RED Black: "+bst.depth());
	}


	private static void BST() {
		BST<MyInteger, Integer> bst = new BST<>();

		bst.put(new MyInteger(0), 0);
		bst.put(new MyInteger(1), 1);
		bst.put(new MyInteger(2), 2);
		bst.put(new MyInteger(3), 3);
		bst.put(new MyInteger(4), 4);
		bst.put(new MyInteger(5), 5);
		bst.put(new MyInteger(6), 6);

//		System.out.println(bst.get(new common.MyInteger(2)));
//		System.out.println(bst.get(new common.MyInteger(5)));
//		System.out.println(bst.get(new common.MyInteger(9)));
		bst.inOrder();
		System.out.println("Depth: "+bst.depth());
	}

	private static void heapSort() {
//		common.MyInteger[] test = new common.MyInteger[]{
//				new common.MyInteger(1),
//				new common.MyInteger(2),
//				new common.MyInteger(0),
//		};
		MyInteger[] test = new MyInteger[]{
				new MyInteger(4),
				new MyInteger(3),
				new MyInteger(7),
				new MyInteger(1),
				new MyInteger(9),
				new MyInteger(2),
				new MyInteger(0),
		};
//		System.out.println(Arrays.toString(test));
		HeapSort.sort(test);
//		System.out.println(Arrays.toString(test));
	}
	private static void binaryHeap() {
		MaxPQ<MyInteger> binaryHeap = new MaxPQ<>(10);

		binaryHeap.insert(new MyInteger(4));
		binaryHeap.insert(new MyInteger(3));
		binaryHeap.insert(new MyInteger(7));
		binaryHeap.insert(new MyInteger(1));
		binaryHeap.insert(new MyInteger(9));
		binaryHeap.insert(new MyInteger(2));
		binaryHeap.insert(new MyInteger(0));

		System.out.println(Arrays.toString(binaryHeap.getHeap()));
//		System.out.println(binaryHeap.deleteMax());
//		System.out.println(binaryHeap.deleteMax());
		System.out.println(Arrays.toString(binaryHeap.getHeap()));


	}


	private static void insertionSort() {
		MyInteger[] test = new MyInteger[]{
				new MyInteger(4),
				new MyInteger(3),
				new MyInteger(7),
				new MyInteger(1),
				new MyInteger(9),
				new MyInteger(2),
				new MyInteger(0),
		};
		System.out.println(Arrays.toString(test));
		InsertionSort.sort(test);
		System.out.println(Arrays.toString(test));
	}
	private static void selectionSort() {
		MyInteger[] test = new MyInteger[]{
				new MyInteger(4),
				new MyInteger(3),
				new MyInteger(7),
				new MyInteger(1),
				new MyInteger(9),
				new MyInteger(2),
				new MyInteger(0),
		};
		System.out.println(Arrays.toString(test));
		SelectionSort.sort(test);
		System.out.println(Arrays.toString(test));
	}

	private static void queue() {
		System.out.println("Test");
//		common.MyStack<String> stack = new common.MyStack();
//		stack.push("N");
//		stack.push("I");
//		stack.push("S");
//		stack.printTop();
//		stack.pop();
//		stack.push("H");
//
//		stack.printTop();
//
//		common.MyStack<Integer> stackInt = new common.MyStack();
//		stackInt.push(0);
//		stackInt.push(1);
//		stackInt.push(2);
//		stackInt.printTop();
//		stackInt.pop();
//		stackInt.pop();
//		stackInt.pop();
//		stackInt.pop();
//		stackInt.pop();
//		stackInt.printTop();
//		stackInt.push(3);
//		stackInt.printTop();

		MyQueue<Integer> myQueue = new MyQueue<>();

		myQueue.enqueue(1);
		myQueue.enqueue(2);
		myQueue.enqueue(3);
		myQueue.enqueue(4);
//		System.out.println("Tail " +myQueue.dequeue());
		myQueue.enqueue(5);
//		myQueue.print();
		myQueue.enqueue(6);
		System.out.println("Tail " +myQueue.dequeue());
		myQueue.print();
	}


	private static void print(String value) {
		System.out.println(value);
	}

	private static void print(int value) {
		System.out.println(value);
	}

	private static void print(double value) {
		System.out.println(value);
	}

	private static void print(boolean value) {
		System.out.println(value);
	}

	private static  <T> void print(T[] value) {
		System.out.println(Arrays.toString(value));
	}

	private static void print(char[] value) {
		System.out.println(Arrays.toString(value));
	}

}