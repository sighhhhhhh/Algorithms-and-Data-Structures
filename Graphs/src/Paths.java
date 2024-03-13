public class Paths {
    City[] path;
    int sp;

    public Paths() {
        path = new City[54];
        sp = 0;
    }


    public static void main(String[] args) {
        Map map = new Map("trains.csv");

        String from = "Malmö";
        String to = "Kiruna";
        Paths paths = new Paths();
        long t0 = System.nanoTime();
        Integer dist = paths.shortest2(map.lookup2(from), map.lookup2(to), null);
        long time = (System.nanoTime() - t0)/1_000_000;

        System.out.println("shortest: " + dist + " min (" + time + " ms)");
    }

    public Integer shortest(City from, City to) {
        if (from == to)
            return 0;
        Integer shoort = null;

        for (int i = 0; i < sp; i++) {
            if (path[i] == from)
            return null;
        }

        for (int i = 0; i < from.neighbours.length; i++) {
            path[sp++] = from;
            if (from.neighbours[i] != null) {
                Connection conn = from.neighbours[i];
                Integer maybeShort = shortest(conn.city, to);
                if(shoort == null && maybeShort != null || (maybeShort != null && maybeShort + conn.minutes < shoort)){
                    shoort = maybeShort + conn.minutes;
                }
            }
            path[sp--] = null;
        }

        if(shoort == null)
            return null;

        return shoort;
    }

    public Integer shortest2(City from, City to, Integer Max) {
        
        if (Max != null && Max < 0)
            return null;
        if (from == to)
            return 0;
        Integer shoort = null;

        for (int i = 0; i < sp; i++) {
            if (path[i] == from)
            return null;
        }

        for (int i = 0; i < from.neighbours.length; i++) {
            path[sp++] = from;
            if (from.neighbours[i] != null) {
                Connection conn = from.neighbours[i];
                Integer maybeShort = 0;

                if(shoort == null)
                    maybeShort = shortest2(conn.city, to, null);
                else
                    maybeShort = shortest2(conn.city, to, shoort - conn.minutes);

                if(shoort == null && maybeShort != null || (maybeShort != null && maybeShort + conn.minutes < shoort)){
                    shoort = maybeShort + conn.minutes;
                }
            }
            path[sp--] = null;
        }

        if(shoort == null)
            return null;

        return shoort;
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
                System.out.println("from: " + from.name + " to: " + conn.city.name);
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
