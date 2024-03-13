public class Cell {
        int head;
        Cell next;
        Cell previous;

        Cell(int val, Cell nxt) {
            head = val; // the value in this cell
            next = nxt; //next points to the next cell
            previous = null; //previous points to the next cell
        }
    }
