public class LinkedListStack<Obj extends Object>{
Cell stackStart;

public class Cell {
    Obj head;
    Cell tail;

    Cell(Obj val, Cell tl) {
        this.head = val; // the value in this cell
        this.tail = tl; //tail points to the next cell
    }
}
    public LinkedListStack (){
        stackStart = null;
    }

    public void push(Obj item){
        stackStart = new Cell(item,stackStart);
    }

    public Obj pop(){
        if(stackStart == null){
            return null;
        }
        Obj ret = stackStart.head;
        stackStart = stackStart.tail;
        return ret;
    }

    public Obj head(){
        return stackStart.head;
    }

    public boolean isEmpty(){
        if(stackStart == null)
            return true;
        return false;
    }


}