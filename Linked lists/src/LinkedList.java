class LinkedList {
    Cell first;

    private class Cell {
        int head;
        Cell tail;

        Cell(int val, Cell tl) {
            this.head = val; // the value in this cell
            this.tail = tl; //tail points to the next cell
        }
    }

    public LinkedList(){
        this.first = null;
    }

    public void add(int item){
        Cell newCell = new Cell(item, first);
        this.first = newCell;
    }

    public int length(){
        Cell current = this.first;
        int length = 0;
        while(current != null){
            length++;
            current = current.tail;
        }
        return length;
    }
/*
    public boolean find(int item){
        Cell current = this.first;
        while(current != null){
            if(current.head == item)
            return true;
            current = current.tail;
        }
        return false;
    }
*/

    public boolean find(int item){
        Cell current = this.first;
        while(current != null){
            if(current.head != item)
            current = current.tail;
            else
            return true;

        }
        return false;
    }

    public void remove(int item){ 
        Cell current = this.first;
        Cell prev = null;
        while (current != null){
            if(current.head == item){
                prev.tail = current.tail;
                return;
            }
            prev = current;
            current = current.tail;
        }
        return;
    }

    public void append(LinkedList b) {
        Cell current = this.first;
        Cell prev = null;
        while (current.tail != null) {
            prev = current;
            current = current.tail;
        }
        current.tail = b.first;
        b.first = null;
    }
}