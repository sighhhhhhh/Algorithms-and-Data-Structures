import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryTree implements Iterable<Integer>{
    private class Node {
        public Integer key;
        public Integer value;
        public Node left, right;
    
        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }
    
        public void print() {
            if(left != null)
                left.print();
            System.out.println(" key: " + key + "\tvalue: " + value);
            if(right != null)
                right.print();
        }
    }

    Node root;

    public BinaryTree() {
        root = null;
    }

//adds a new node (leaf) to the
//tree that maps the key to the value. If the key is already present we
//update the value of the node. Note that the tree should still be sorted.
    public void add(Integer key, Integer value){
    Node newNode = new Node(key, value);
    Node current = root;
        if (root == null){
            root = newNode;
            return;
        }
        while(true){
        if(key < current.key){
            if(current.left == null){
                current.left = newNode;
                return;
            }
            current = current.left;
            continue;
        }
        if(key > current.key){
            if(current.right == null){
                current.right = newNode;
                return;
            }
            current = current.right;
            continue;
        }
        if(key == current.key){
            current.value = value;
            return;
        }
        }
    }

//find and return the value associate to the
//key. If the key is not found we return null.
    public Integer lookup(Integer key){
        Node current = root;
        while(true){
        if(key < current.key){
            if(current.left == null){
                return null;
            }
            current = current.left;
            continue;
        }
        else if(key > current.key){
            if(current.right == null){
                return null;
            }
            current = current.right;
            continue;
        }
        else if(key == current.key){
            return current.value;
        }
        }
    }

public Iterator<Integer> iterator() {
        return new TreeIterator();
    }


//Iterator part
public class TreeIterator implements Iterator<Integer> {   
    
    private Node next;
    private LinkedListStack<Node> stack;

    public TreeIterator() {
        stack = new LinkedListStack<Node>();
        Node current = root;
        while (current != null){
            stack.push(current);
            current = current.left;
        }
        next = stack.head();
    }

    @Override
    public Integer next() {
        if (hasNext()==false){
            throw new NoSuchElementException();
        }

        Node current = stack.head();
        Node ret = stack.pop();

        if(current.right != null){
            current = current.right;
            while (current != null){
                stack.push(current);
                current = current.left;
            }
        }
        if(stack.isEmpty()){
            next = null;
        }
        else{
            next = stack.head();
        }

        return ret.value;
    }

    @Override
    public boolean hasNext() {
        if(next == null){
            return false;
        }
        return true;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
}