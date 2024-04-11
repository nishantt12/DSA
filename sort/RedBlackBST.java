package sort;

import common.Comparable;
public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private Node<Key, Value> root;

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private static class Node<Key extends Comparable<? super Key>, Value> {
        Key key;
        Value value;

        boolean color = RED;
        Node<Key, Value> left, right;

        public Node(Key key, Value value, boolean color){
            this.key = key;
            this.value = value;
            this. color = color;
        }
    }

    public void put(Key key, Value value){
        root = put(key, value, root);
    }


    boolean isRed(Node node){
        if(node==null) return BLACK;
        return  node.color == RED;
    }

    public int depth(){
        return depth(root);
    }

    private int depth(Node node){
        if(node == null){
            return 0;
        }
        int depth = Math.max(1+depth(node.left), 1+depth(node.right));
        return depth;
    }

    private Node<Key, Value> put(Key key, Value value, Node<Key, Value> node){
        if (node == null) {
            return new Node(key, value, RED);
        }
        if (key.compareTo(node.key) > 0){
            node.right = put(key, value, node.right);
        } else if (key.compareTo(node.key) < 0 ) {
            node.left = put(key, value, node.left);
        } else{
            node.value = value;
        }
        if(isRed(node.right) && !isRed(node.left)){
            node = rotateLeft(node);
        }
        if(isRed(node.left) && isRed(node.left.left)){
            node = rotateRight(node);
        }
        if(isRed(node.left) && isRed(node.right)){
            node = flipColors(node);
        }
        return node;
    }



    public Value get(Key key){
        if (root == null) {
            return null;
        }
        Node<Key, Value> node = get(key, root);
        return (node!=null) ? node.value : null;
    }

    public Node get(Key key,  Node<Key, Value> node){
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) > 0){
            return get(key, node.right);
        } else if (key.compareTo(node.key) < 0 ) {
           return get(key, node.left);
        } else {
            return node;
        }

    }

    private Node rotateLeft(Node node){
        Node r = node.right;
        Node leftLeft = r.left;
        r.left = node;
        node.right = leftLeft;
        r.color = node.color;
        node.color = RED;
        return r;
    }

    private Node rotateRight(Node node){
        Node left = node.left;
        node.left =  left.right;
        left.right = node;
        left.color = node.color;
        node.color = RED;
        return left;
    }

    private Node flipColors(Node node){
       node.color = RED;
       node.left.color = BLACK;
       node.right.color = BLACK;
       return node;
    }
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node==null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    public void postOrder(){}

}
