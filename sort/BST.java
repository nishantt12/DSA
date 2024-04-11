package sort;

import common.Comparable;

public class BST<Key extends Comparable<Key>, Value> {

    private Node<Key, Value> root;

    private static class Node<Key extends Comparable<? super Key>, Value> {
        Key key;
        Value value;
        Node<Key, Value> left, right;

        public Node(Key key, Value value){
            this.key = key;
            this.value = value;
        }
    }

    public void put(Key key, Value value){
        root = put(key, value, root);
    }

    private Node<Key, Value> put(Key key, Value value, Node<Key, Value> node){
        if (node == null) {
            return new Node(key, value);
        }
        if (key.compareTo(node.key) > 0){
            node.right = put(key, value, node.right);
        } else if (key.compareTo(node.key) < 0 ) {
            node.left = put(key, value, node.left);
        } else{
            node.value = value;
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
