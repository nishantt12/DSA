public class HashMap<Key, Value> {

    private static class Node <Key, Value>{

        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private static final int M = 97;
    private final Node[] nodes = new Node[M];

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key){
        int hash = hash(key);
        for (Node node = nodes[hash]; node!=null; node = node.next){
            if (node.key == key){
                return (Value) node.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value){
        int hash = hash(key);
        for (Node node = nodes[hash]; node!=null; node = node.next){
            if (node.key == key){
                node.value = value;
                return;
            }
        }
        nodes[hash] = new Node<>(key, value, nodes[hash]);
    }




}
