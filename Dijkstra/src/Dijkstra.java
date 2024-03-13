public class Dijkstra{
    public Path[] done;
    public PrioQueue<City> queue;
    public Map map;
    public boolean[] inQueue;

    private class Path {
        private City city;
        private City prev;
        private Integer dist;
        private Integer index;

        private Path(City cty, City prv, Integer dst, Integer ind){
            city = cty;
            prev = prv;
            dist = dst;
            index = ind;
        }
    }

    public Dijkstra(Map map){
        int n = map.size;
        done = new Path[n];
        inQueue = new boolean[n];
        for(int i = 0; i < inQueue.length; i++)
            inQueue[i] = false;
        queue = new PrioQueue<City>();
    }

    public Integer DijkstraAlgorithm(City Start, City End){
        int citiesLookedAt = 0;
        queue.add(Start, 0);
        City currentCity = Start;

        done[Start.id] = new Path(currentCity, currentCity, 0, Start.id);
        citiesLookedAt++;

        while(!queue.isEmpty()){
        currentCity = queue.removeTop();
        if(currentCity == End)
            break;
        
        for(Connection Neighbour: currentCity.neighbours){
            if(Neighbour.city == Start)
                continue;
            
            
            int distance = done[currentCity.id].dist + Neighbour.distance;

            //bing bong
            //case 1: havent checked it yet
            if(done[Neighbour.city.id] == null){
                done[Neighbour.city.id] = new Path(Neighbour.city, currentCity, distance, Neighbour.city.id);
                queue.add(Neighbour.city, distance);
                inQueue[Neighbour.city.id] = true;
                citiesLookedAt++;
            }

            //case 2: have checked it
            if(done[Neighbour.city.id].dist > distance){
                queue.remove(Neighbour.city);
                queue.add(Neighbour.city, distance);
                done[Neighbour.city.id] = new Path(Neighbour.city, currentCity, distance, Neighbour.city.id);
            }
        }
        }
        System.out.println("citties visisted: " + citiesLookedAt);
        return done[End.id].dist;
    }

}
