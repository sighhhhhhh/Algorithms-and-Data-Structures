public class LinkedList{
    Node first;
    Node last;


    public class Node {
        public int value;
        public Node next;
    
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public LinkedList(){
        first = null;
        last = null;
    }

    public void QuickSort(){
        if(this.first == null || this.first.next == null)
            return;

        LinkedList smaller = new LinkedList();
        LinkedList bigger = new LinkedList();
        
        Node pivot = this.first;
        Node current = this.first.next;
        pivot.next = null;

        this.last = pivot;

        while(current != null){
            if(current.value < pivot.value)
                smaller.add(current.value);
            else if (current.value >= pivot.value)
                bigger.add(current.value);
            current = current.next;
        }

        smaller.QuickSort();
        bigger.QuickSort();

        this.append(bigger);
        this.prepend(smaller);
    }

    public void add(int item){
        Node newNode = new Node(item, first);
        if(first == null){
            this.last = newNode;
        }
        this.first = newNode;
    }

    public void remove(int item){ 
        Node current = this.first;
        Node prev = null;
        while (current != null){
            if(current.value == item){
                if(current == last){
                    last = prev;
                    prev.next = null;
                    return;
                }

                prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void append(LinkedList b) {
        if(this.first == null || b.first == null)
            return;
        
        this.last.next = b.first;
        this.last = b.last;
    }

    public void prepend(LinkedList b) {
        if(this.first == null || b.first == null)
            return;

        b.last.next = this.first;
        this.first = b.first;
    }
    
    public void Print(){
        Node current = this.first;

        while(current != null){
            System.out.println(current.value);
            current = current.next;
        }
    }
}