import java.util.List;

public class MyQueue<T> implements MyIterable<T> {
    private static class Node<T> {
        T item;
        Node<T> nextNode;
    }

    private Node<T> tail;
    private Node<T> head;

    public void enqueue(T item) {
        Node<T> newHead = new Node<>();
        newHead.item = item;
        if (head != null) {
            head.nextNode = newHead;
        }
        head = newHead;
        if (tail == null) {
            tail = head;
        }
    }

    public T dequeue() {
        if (tail == null) {
            throw new IllegalStateException("Queue is empty");
        }
        Node<T> newTail = tail;
        tail = newTail.nextNode;
        return newTail.item;

    }

    public void print() {
        MyIterator iterator = iterator();
        while (iterator.hasNext()) {
            System.out.println("node: " + iterator.next());

        }

    }

    @Override
    public MyIterator<T> iterator() {
        return new MyListMyIterator();
    }

    public class MyListMyIterator implements MyIterator<T> {

        public Node<T> current = tail;

        @Override
        public boolean hasNext() {
            return current.nextNode != null;
        }

        @Override
        public T next() {
            T newItem = current.item;
            current = current.nextNode;
            return newItem;
        }
    }
}
