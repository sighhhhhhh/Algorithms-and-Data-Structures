public class App {
    public static void main(String[] args) throws Exception {
        Map Europe = new Map("europe.csv");
        int mins = 0;
        long time = 1000000000;

        String City1 = "Malmö";
        String City2 = "Kiruna";
        for(int i = 0; i < 1; i++){
        Dijkstra PlsWork = new Dijkstra(Europe);
        long n0 = System.nanoTime();
        mins = PlsWork.DijkstraAlgorithm(Europe.lookup2(City1), Europe.lookup2(City2));
        long n1 = System.nanoTime();
        if((n1 - n0)< time)
            time = (n1 - n0);
        }

        System.out.println("Shortest route between " + City1 + " and " + City2 +
        " is " + mins + " minutes " + "\n" + "search took " +  time + " ms");
    }
}
