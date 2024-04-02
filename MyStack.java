public class MyStack<T> {

	private Node<T> first;

	private static class Node<T> {
		T item;
		Node<T> nextNode;

		public Node(T item) {
				this.item = item;
		}
	}

	public void push(T item) {
		Node<T> oldFirst = first;
		first = new Node<T>(item);
		first.nextNode = oldFirst;
	}

	public T pop(){
		if(first == null) {
			throw new IllegalStateException("Stack is empty");
		}
		Node oldFirst = first;
		first = oldFirst.nextNode;
		return (T) oldFirst.item;
	} 


	public void printTop() {
		System.out.println("First: "+first.item);
	}


}