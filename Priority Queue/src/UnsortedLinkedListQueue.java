public class UnsortedLinkedListQueue{
    public Node first;

    public class Node {
        int item;
        Node next;

        private Node(int item, Node list) {
            this.item = item;
            this.next = list;
        }
    }

    public UnsortedLinkedListQueue() {
        first = null;
    }

    public void add(int item) {
        Node newNode = new Node(item, first);
        first = newNode;
    }

    public int remove() {
        Node small = first;
        Node smallPrev = null;

        Node current = first.next;
        Node prev = first;

        while (current != null){
            if(current.item < small.item){
                small = current;
                smallPrev = prev;
            }
            prev = current;
            current = current.next;
        }
    if(small == first){
        first = first.next;
        small.next = null;
        return small.item;
    }
    smallPrev.next = small.next;
    small.next = null;
    return small.item;
    }
}
