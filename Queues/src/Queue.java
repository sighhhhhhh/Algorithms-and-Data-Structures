public class Queue <Obj extends Object>{
    public Node first;
    public Node last;

    public class Node {
        Obj item;
        Node next;

        private Node(Obj item, Node list) {
            this.item = item;
            this.next = list;
        }
    }

    public Queue() {
        first = null;
        last = null;
    }

    public void add(Obj item) {
        Node newNode = new Node(item, null);

        if (first ==null){
            first = newNode;
            last = newNode;
        }

        else{
            last.next = newNode;
            last = newNode;
        }
    }

    public Obj remove() {
        Obj ret = first.item;
        first = first.next;
        return ret;
    }

    public Obj firstItem() {
        return first.item;
    }
}
