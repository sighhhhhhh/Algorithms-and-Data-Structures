public class Main {
    public static void main(String[] args) throws Exception {
        LinkedList singleList = new LinkedList();
        DoublyLinkedList doubleList = new DoublyLinkedList();
        int n = 1000000;
        int k = n/5;
        int index = 0;
        Cell doubleArray[] = new Cell [5];
        Cell singleArray[] = new Cell [5];

        for(int i = 0; i < n; i++){
            singleList.add(i);
            doubleList.add(i);
            if((i+1)%k == k-1){    
                singleArray[index] = singleList.first;
                doubleArray[index] = doubleList.first;
                index++;
            }
        }

        long n0 = System.nanoTime();

        for(int i = 0; i < 5; i++){
            singleList.unlink(doubleArray[i]);
            singleList.link(doubleArray[i]);
        }

        long n1 = System.nanoTime();
        
        long time = n1 - n0;

        System.out.println(time + " nanoseconds");
    } 


}
