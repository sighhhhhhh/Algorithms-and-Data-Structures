public class SortedLinkedListQueue{
    public Node first;

    public class Node {
        int item;
        Node next;

        private Node(int item, Node nextNode) {
            this.item = item;
            this.next = nextNode;
        }
    }

    public SortedLinkedListQueue() {
        first = null;
    }

    public void add(int item) {
        Node newNode = new Node(item, null);
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

    public int remove() {
        Node ret = first;
        first = first.next;
        ret.next = null;
        return ret.item;
    }
}
