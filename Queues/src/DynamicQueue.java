public class DynamicQueue <Obj extends Object>{
    Integer firstIndex = 0;
    Integer lastIndex = 0;
    Obj[] array;
    int size = 2;

    public DynamicQueue() {
        array = (Obj[]) new Object[size];
    }

    public void add(Obj item) {
        if(lastIndex==firstIndex - 1 || (firstIndex==0 && lastIndex==size-1)){
            Obj[] newArray = (Obj[]) new Object[size*2];
            if(firstIndex < lastIndex){
                for(int i = 0; i < lastIndex - firstIndex; i++){
                    newArray[i] = array[firstIndex + i];
                }
            }
            
            else if(firstIndex > lastIndex){
                for(int i = 0; i < size - firstIndex - 1; i++){
                    newArray[i] = array[firstIndex + i];
                }
                for(int i = size - firstIndex - 1; i < size - 1; i++){
                    newArray[i] = array[i - (size - firstIndex - 1)];
                }
            }
            firstIndex = 0;
            lastIndex = size - 1;
            size = 2*size;
            array = newArray;
            }

        if(lastIndex == size-1){
            lastIndex = 0;
            array[lastIndex] = item;
            return;
        }

        array[lastIndex++] = item;
    }

    public Obj remove() {

        if(empty()){
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