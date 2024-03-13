import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        int n = 100000;
        int A []= new int [n];
        int B [] = new int[n];
        for(int i = 0; i < n; i++){
            A[i] = 2*i;
            B[i] = 2*i+1;
        }
        long time = Long.MAX_VALUE;
        boolean Boo = false;

        for(int i=0; i<100; i++){
            long n0 = System.nanoTime();
            Stack Duplicates =Step_Duplicate_Search(A, B);
            long n1 = System.nanoTime();
            if(n1-n0 < time){
                time = n1 - n0;
            }
        }
        System.out.println(time + " nanoseconds");
    }

    public static boolean search_unsorted(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                return true;
            }
        }
        return false;
    }

    public static boolean search_sorted(int[] array, int key) {
        for (int index = 0; index < array.length && array[index] <= key ; index++) {
            if (array[index] == key) {
                return true;
            }
        }
        return false;
    }    

    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n ; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }
        return array;
    }

    public static boolean binary_search(int[] array, int key) {
        int first = 0;
        int last = array.length-1;
        while (true) {
            int index = (first + last)/2 ;  
            if (array[index] == key) {
                return true;
            }
            if (last == first + 1){
                return false;
            }
            if (array[index] < key && index < last) {
                first = index;
                continue;
            }
            if (array[index] > key && index > first) {
                last = index;
                continue;
            }
        }
    }

    public static Stack Linear_Duplicate_Search(int [] ArrayA, int [] ArrayB){
        Stack dup = new Stack();
        for(int i=0; i < ArrayA.length; i++){
            for(int j=0; j < ArrayB.length; j++){
                if(ArrayA[i] == ArrayB[j]){
                    dup.push(ArrayA[i]);
                }
            }
        }
        return dup;
    }

    public static Stack Binary_Duplicate_Search(int [] ArrayA, int [] ArrayB){
        Stack dup = new Stack();
        for(int i=0; i < ArrayA.length; i++){
            if(binary_search(ArrayB, ArrayA[i])==true){
                dup.push(ArrayA[i]);
            }
        }
        return dup;
    }    
    
    public static Stack Step_Duplicate_Search(int [] ArrayA, int [] ArrayB){
        Stack dup = new Stack();
        int IndexA = 0;
        int IndexB = 0;

        while(IndexA<ArrayA.length-1 && IndexA<ArrayB.length-1){
            if(ArrayA[IndexA+1] > ArrayB[IndexB+1]){
                IndexB++;
                continue;
            }

            if(ArrayA[IndexA+1] < ArrayB[IndexB+1]){
                IndexA++;
                continue;
            }

            if(ArrayA[IndexA+1] == ArrayB[IndexB+1]){
                dup.push(ArrayA[IndexA+1]);
                IndexA++;
                IndexB++;
            }
        }
        return dup;
    }    
}

