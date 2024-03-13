public class Main {
    /*
    public static void main(String[] args) {
        // 10 + 2 * 5
        // 10 2 5 * + in reversed Polish notation
        Item[] expr = {
        Item.Value(10),
        Item.Value(2),
        Item.Value(5),
        Item.Mul(),
        Item.Add()
        };
        Calculator calc = new Calculator(expr);
        int res = calc.run();
        System.out.println(" Calculator: res = " + res);
    }
*/
    public static void main(String[] args) {
        Stack bigstack = new Stack(1024);
        long Total = 0;
        for(int j=0; j < 1000; j++){
            long n0 = System.nanoTime();
            for(int i=0; i<1000; i++){
                bigstack.push(i);
            }
            for(int i=0; i<1000; i++){
                bigstack.pop();
            }
            long n1 = System.nanoTime();
       
            Total = Total + (n1 - n0);            
        }
    System.out.println("average:" + Total/1000 + " nanoseconds");
    }
}