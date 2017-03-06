package vv.tree;

/**
 * Created by vasudvis on 1/28/2017.
 */
public class BinarySearchTree<T extends Comparable, P> {
    Node<T,P> root;

    public void put(T key, P value){
         this.root = put(this.root, key, value);
    }

    public Node<T,P> put(Node<T,P> node, T key, P value){
        if(node == null){
            return new Node(key, value, null, null);
        }
        int diff = node.getKey().compareTo(key);
        if(diff > 0){
            node.setLeft(put(node.getLeft(),key, value));
        }else if(diff < 0){
            node.setRight(put(node.getRight(), key, value));
        }else{
            node.value = value;
        }
        return node;
    }


    public P min(){
        return min(this.root);
    }


    public P min(Node<T, P> node){
       Node<T,P> tmp = node;
        if(tmp == null){
            return null;
        }else{
            while(tmp.getLeft() != null){
                tmp = tmp.getLeft();
            }
            return tmp.getValue();
        }
    }

    public void removeMin(){
        Node<T, P> tmp = this.root;
        if(tmp == null) return ;

        if(tmp.getLeft() == null){
            this.root = tmp.getRight();
            return;
        }
        Node<T, P> prev = null;

        while(tmp.getLeft() != null){
            prev = tmp;
            tmp = tmp.getLeft();
        }
        prev.setLeft(null);
    }

    public P max(){
        return max(this.root);
    }
    public P max(Node<T, P> node){
        Node<T, P> tmp = node;
        if(tmp == null) return null;
        else{
            while (tmp.getRight() != null){
                tmp = tmp.getRight();
            }
            return tmp.getValue();
        }
    }

    public void show(){
         show(this.root);
    }

    public void show(Node<T,P> node){
        if(node == null) return;
        show(node.getLeft());
        System.out.println("(" + node.getKey() + "," + node.getValue()+ ")");
        show(node.getRight());
    }

    public static void main(String[] args){
        BinarySearchTree<Integer,String> tree = new BinarySearchTree<Integer, String>();
        tree.put(2, "Two");
        tree.put(3,"Three");
//        tree.put(4, "Four");
//        tree.put(8, "Eight");
//        tree.put(9, "Nine");
//        tree.put(5, "Five");
//        tree.put(6, "Six");
//        tree.put(7, "Seven");
        //tree.put(1, "One");

        tree.show();

        System.out.println("Min " + tree.min());
        System.out.println("Max " + tree.max());

        tree.removeMin();
        tree.show();
    }
}
