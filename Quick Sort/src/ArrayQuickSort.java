public class ArrayQuickSort {
    
    public static void smth (int[] array, int start, int end){
        int temp;
        int index;

        for(int i = start; i <= end; i++){
            index = i;
            temp = array[i];

            for(int j = i+1; j <= end; i++){
                if(array[j] < temp){
                    temp = array[j];
                    index = j;
                }
            }

            array[index] = array[i];
            array[i] = temp;
        }
    }

    public static int Partition(int[] array, int min, int max){

        int start = min;
        int end = max;
        int pivot = array[min];
        int temp;

        while(start < end){
            while(array[end] > pivot && end > start){
                end--;
            }

            while(array[start] <= pivot && end > start){
                start++;
            }

            if(start < end){
                temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
        
        array[min] = array[end];
        array[end] = pivot;

        return end;
    }

    public static void QuickSort(int[] array, int start, int end){
        if(start < end){
            int mid = Partition(array, start, end);
            
            QuickSort(array, start, mid);
            QuickSort(array, mid+1, end);
        }
    }


    public static void main(String[] args) throws Exception {
        int n = 160;
        int[] arr = new int[n];
        LinkedList list = new LinkedList();


        for(int i = 0; i < n; i++){
            arr[i] = (int)Math.floor(Math.random()*n*100);
        }        

        for(int i = 0; i < n; i++){
            list.add(arr[i]);
        }
        System.out.println("array sort time");
        
        long n0 =  System.nanoTime();
        QuickSort(arr, 0, arr.length-1);
        long n1 =  System.nanoTime();
        System.out.println(n1 - n0 + " nanoseconds");

    
        System.out.println("\n" + "list sort");

        long n2 =  System.nanoTime();
        list.QuickSort();
        long n3 =  System.nanoTime();
        System.out.println(n3 - n2 + " nanoseconds");


    }
}
