public class City {
    String name;
    Connection[] neighbours;

    public City(){
    }

    public City(String nameA){
        name = nameA;
        neighbours = new Connection[1];
    }

    public void connect(City nxt, int dst){
        if(neighbours[0] == null){
            neighbours[0] = new Connection(nxt, dst);
            return;
        }
        Connection [] neigh = new Connection[neighbours.length + 1];

        for(int i = 0; i < neighbours.length; i++){
            neigh[i] = neighbours[i];
        }
        neigh[neigh.length-1] = new Connection(nxt, dst);
        neighbours = neigh;
    }
}
