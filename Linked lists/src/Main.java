public class Main {
    public static void main(String[] args) throws Exception {
        LinkedList myListA = new LinkedList();
        LinkedList myListB = new LinkedList();
        long time;
        int n = 1000;

        myListA.add(5);
        myListA.add(25);


        /*
        for (int i = 0; i < n; i++) {
            myListB.add(i);
        }

        long n0 = System.nanoTime();
        myListA.append(myListB);
        long n1 = System.nanoTime();
        
        time = n1 - n0;
*/
        myListA.remove(5);
        System.out.println(myListA.find(25) + " nanoseconds");
    } 

}
