import java.util.*;

public class Main {

	public static void main(String[] args) {
		hashMap();
	}

	private static void hashMap(){
		HashMap<String, String> hashMap = new HashMap<>();

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

//		System.out.println(bst.get(new MyInteger(2)));
//		System.out.println(bst.get(new MyInteger(5)));
//		System.out.println(bst.get(new MyInteger(9)));
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

//		System.out.println(bst.get(new MyInteger(2)));
//		System.out.println(bst.get(new MyInteger(5)));
//		System.out.println(bst.get(new MyInteger(9)));
		bst.inOrder();
		System.out.println("Depth: "+bst.depth());
	}

	private static void heapSort() {
//		MyInteger[] test = new MyInteger[]{
//				new MyInteger(1),
//				new MyInteger(2),
//				new MyInteger(0),
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
		BinaryHeap<MyInteger> binaryHeap = new BinaryHeap<>(10);

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
//		System.out.println(Arrays.toString(binaryHeap.getHeap()));


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
//		MyStack<String> stack = new MyStack();
//		stack.push("N");
//		stack.push("I");
//		stack.push("S");
//		stack.printTop();
//		stack.pop();
//		stack.push("H");
//
//		stack.printTop();
//
//		MyStack<Integer> stackInt = new MyStack();
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
}