public class LinkedListStack{
Cell stackStart;

private class Cell {
    int head;
    Cell tail;

    Cell(int val, Cell tl) {
        this.head = val; // the value in this cell
        this.tail = tl; //tail points to the next cell
    }
}
    public LinkedListStack (){
        stackStart = null;
    }

    public void push(int item){
        stackStart = new Cell(item,stackStart);
    }

    public int pop() throws Exception{
        if(stackStart == null){
            throw new Exception("pop from empty stack");
        }
        int ret = stackStart.head;
        stackStart = stackStart.tail;
        return ret;
    }
}