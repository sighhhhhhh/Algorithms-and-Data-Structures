public class Naive {

    public static void main(String[] args) {
        Map map = new Map("trains.csv");

        String from = "Malmö";
        String to = "Kiruna";
        Integer max = 1000;

        long t0 = System.nanoTime();
        Integer dist = shortest(map.lookup2(from), map.lookup2(to), max);
        long time = (System.nanoTime() - t0)/1_000_000;

        System.out.println("shortest: " + dist + " min (" + time + " ms)");
    }

    private static Integer shortest(City from, City to, Integer max) {
        if (max < 0)
            return null;
        if (from == to)
            return 0;
        Integer shoort = null;
        for (int i = 0; i < from.neighbours.length; i++) {
            if (from.neighbours[i] != null) {
                Connection conn = from.neighbours[i];
                int timeLeft = max - conn.minutes;
                Integer maybeShort = shortest(conn.city, to, timeLeft);
                if(shoort == null && maybeShort != null || (maybeShort != null && maybeShort + conn.minutes < shoort)){
                    shoort = maybeShort + conn.minutes;
                }
            }
        }
        if(shoort == null)
            return null;

        return shoort;
    }

}
