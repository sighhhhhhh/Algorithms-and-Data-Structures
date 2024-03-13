public class ArrayQueue <Obj extends Object>{
    Integer firstIndex = 0;
    Integer lastIndex = 0;
    Obj[] array;
    int size = 10;

    public ArrayQueue() {
        array = (Obj[]) new Object[size];
    }

    public void add(Obj item) {
        if(lastIndex==firstIndex - 1 || (firstIndex==0 && lastIndex==size-1)){
            System.out.println("queue is full lol");
            return;
        }

        if(lastIndex == size-1){
            lastIndex = 0;
            array[lastIndex] = item;
            return;
        }

        array[lastIndex++] = item;
    }

    public Obj remove() {

        if(array[firstIndex] == null){
            System.out.println("queue is empty nothing to add lol");
            return null;
        }

        Obj ret = array[firstIndex];
        array[firstIndex] = null;

        if(firstIndex == size-1){
            firstIndex = 0;
        }

        else{
            firstIndex++;
        }

        return ret;
    }

    public boolean empty () {
        return ( firstIndex == lastIndex);
    }

    public Obj firstItem() {
        return array[firstIndex];
    }
}