package tree;

public class Trie<Value> {

    private static final int R = 256;

    private static class Node<Value> {
        private Value value;
        private Node[] next = new Node[R];
    }

    private Node root = new Node();

    public void put(String key, Value value) {
        root = put(root, key, value, 0);
    }

    private Node put(Node x, String key, Value value, int d) {
        if (x == null) {
            x = new Node();
        }
        if (d == key.length() - 1) {
            x.value = value;
            return x;
        }
        char item = key.charAt(d);
        x.next[item] = put(x.next[item], key, value, d + 1);
        return x;
    }

    public Value get(String key) {
        return get(root, key, 0);
    }

    private Value get(Node x, String key, int d) {

        if (x == null) {
            return null;
        }

        if (d == key.length()) {
            return (Value) x.value;
        }

        char item = key.charAt(d);

        return get(x.next[item], key, d + 1);
    }
}
