public class App {
    public static void main(String[] args) throws Exception {
        Heap LinkedHeap = new Heap();
        ArrayHeap ArrayHeap = new ArrayHeap();
        int n = 10000;
        int array[] = new int[n];

        for(int i = 0; i<n; i++){
            array[i] = (int)(Math.random() * n*n);
        }

        long n0 = System.nanoTime();
        for(int i = 0; i<n; i++){
            LinkedHeap.add(array[i]);
        }
        for(int i = 0; i < n/2; i++){
            LinkedHeap.root.dequeue();
        }
        long n1 = System.nanoTime();
        System.out.println("Linked Heap: " + (n1 - n0));

        long n2 = System.nanoTime();
        for(int i = 0; i<n; i++){
            ArrayHeap.bubble(array[i]);
        }
        for(int i = 0; i < n/2; i++){
            ArrayHeap.sink();
        }
        long n3 = System.nanoTime();
        System.out.println("Array Heap: " + (n3 - n2));





















/*
        Heap heap1 = new Heap();
        Heap heap2 = new Heap();
        int n = 10;
        int incr = (int)(Math.random() * 90) + 10;

        int array[] = new int[1023];

        for(int i = 0; i<1023; i++){
            array[i] = (int)(Math.random() * 10000);
        }

        for(int i = 0; i<1023; i++){
            heap1.add(array[i]);
            heap2.add(array[i]);
        }
        long n0 = System.nanoTime();
        int depth = heap1.push(incr);
        long n1 = System.nanoTime();

        System.out.println("depth: " + depth);
        System.out.println("heap1: " + (n1-n0));
        
        long n2 = System.nanoTime();
        incr = incr + heap2.root.dequeue();
        heap2.add(incr);
        long n3 = System.nanoTime();

        System.out.println("heap2: " + (n3-n2));

*/


    }
}
