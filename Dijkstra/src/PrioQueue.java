public class PrioQueue<T extends Object>{
    public Node first;

    public class Node {
        T Obj;
        int item;
        Node next;

        private Node(T newObj, int item, Node nextNode) {
            this.Obj = newObj;
            this.item = item;
            this.next = nextNode;
        }
    }

    public PrioQueue() {
        first = null;
    }

    public void add(T newObj, int item) {
        Node newNode = new Node(newObj, item, null);
        Node current = first;
        Node prev = null;

        if(first == null){
            first = newNode;
            return;
        }

        while(current != null && current.item < newNode.item){
            prev = current;
            current = current.next;
        }

        if(prev == null){
            newNode.next = first;
            first = newNode;
            return;
        }

        prev.next = newNode;
        newNode.next = current;
    }

    public T removeTop() {
        Node ret = first;
        first = first.next;
        ret.next = null;
        return ret.Obj;
    }
    public boolean isEmpty(){
        return first == null;
    }

    public int TopPrio() {
        return first.item;
    }

    public void remove(T removedObj){
        Node rem = first;
        if(rem.Obj == removedObj)
            removeTop();

        while(rem.next != null){
            if(rem.next.Obj == removedObj){
                rem.next = rem.next.next;
                //rem.next.next = null;
                return;
            }
        rem = rem.next;
        }
    }

    public Integer retrievePrio(T removedObj){
        Node rem = first;
        while(rem != null){
            if(rem.Obj == removedObj){
                return rem.item;
            }
        }
        System.out.println("oops");
        return null;
    }
}