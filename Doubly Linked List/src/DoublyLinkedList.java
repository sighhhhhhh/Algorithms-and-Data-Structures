class DoublyLinkedList {
    Cell first;

    public DoublyLinkedList(){
        first = null;
    }

    public void add(int item){
        Cell newCell = new Cell(item, first);
        if(first == null){
            first = newCell;
            newCell.next = null;

        }
        else{
            newCell.next.previous = newCell;
            first = newCell;
        }
    }

    public void link(Cell linkCell){
        linkCell.next = first;
        linkCell.next.previous = linkCell;
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

    public boolean find(int item){
        Cell current = first;
        while(current != null){
            if(current.head == item)
            return true;
            current = current.next;
        }
        return false;
    }
    
    public void remove(int item){ 
        Cell current = first;
        while (current != null){
            if(current.head == item){
                current.previous.next = current.next;
                current.next.previous = current.previous;
                return;
            }
            current = current.next;
        }
    }

    public void unlink(Cell unlinkCell){        
        unlinkCell.next.previous = unlinkCell.previous;
        unlinkCell.previous.next = unlinkCell.next;  
    }
}