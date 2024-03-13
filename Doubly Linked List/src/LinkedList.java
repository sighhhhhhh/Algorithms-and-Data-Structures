class LinkedList {
    Cell first;

    public LinkedList(){
        first = null;
    }

    public void add(int item){
        Cell newCell = new Cell(item, first);
        first = newCell;
    }

    public void link(Cell linkCell){
        linkCell.next = first;
        first = linkCell;
    }

    public int length(){
        Cell current = first;
        int length = 0;
        while(current != null){
            length++;
            current = current.next;
        }
        return length;
    }

    /*public boolean find(int item){
        Cell current = this.first;
        while(current != null){
            if(current.head == item)
            return true;
            current = current.next;
        }
        return false;
    }
    */
    
    public void remove(int item){ 
        Cell current = first;
        Cell prev = null;
        while (current != null){
            if(current.head == item){
                prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
        return;
    }

    public void unlink(Cell unlinkCell){ 
        Cell current = first;
        Cell prev = null;
        while (current != null){
            if(current == unlinkCell){
                prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
        return;
    }

    public void append(LinkedList b) {
        Cell current = first;
        Cell prev = null;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        current.next = b.first;
        b.first = null;
    }

        public boolean find(int item){
        Cell current = first;
        while(current != null){
            if(current.head != item)
            current = current.next;
            else
            return true;
        }
        return false;
    }
}