package vv.tree;
/**
 * Created by vasudvis on 1/28/2017.
 */
public class Node<T extends Comparable, P> {
    T key;
    P value;
    Node<T, P> left;
    Node<T,P> right;

    public Node(T key, P value, Node<T, P> left, Node<T, P> right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public T getKey() {
        return key;
    }

    public P getValue() {
        return value;
    }

    public Node<T, P> getLeft() {
        return left;
    }

    public Node<T, P> getRight() {
        return right;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public void setValue(P value) {
        this.value = value;
    }

    public void setLeft(Node<T, P> left) {
        this.left = left;
    }

    public void setRight(Node<T, P> right) {
        this.right = right;
    }
}
