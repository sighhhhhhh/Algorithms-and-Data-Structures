import java.io.BufferedReader;
import java.io.FileReader;

public class Map {
    private City[] cities;
    private final int mod = 5683;
    public int size = 0;

    public Map(String file) {
        cities = new City[mod];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                if(lookup(row[0]) == 0){
                    cities[hash(row[0])] = new City(row[0], size);
                    size++;
                }
                if(lookup(row[1]) == 0){
                    cities[hash(row[1])] = new City(row[1], size);
                    size++;
                }
                cities[hash(row[0])].connect(cities[hash(row[1])], Integer.valueOf(row[2]));
                cities[hash(row[1])].connect(cities[hash(row[0])], Integer.valueOf(row[2]));

            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }
    }

    public Integer lookup (String name){ //1 means we already added the city, 0 means we have not, -1 means theres a collision
        int hashIndex = hash(name);
        if(cities[hashIndex] == null){
            return 0;}

        if(cities[hashIndex].name.equals(name)){
            return 1;}

        System.out.println("collision");
        System.out.println("current: " + cities[hashIndex].name);
        System.out.println("new: " + name);
        return -1; 
    }

    public City lookup2 (String name){ //0 means we already added the city, 1 means we have not, -1 means theres a collision
        int hashIndex = hash(name);
        if(cities[hashIndex] == null){
            return null;}

        if(cities[hashIndex].name.equals(name)){
            return cities[hashIndex];}

        System.out.println("collision");
        System.out.println("current: " + cities[hashIndex].name);
        System.out.println("new: " + name);
        return cities[hashIndex];    
    }

    public Integer hash(String name) {
        int hash = 0;
        for (int i = 0; i < name.length(); i++) {
        hash = (hash*31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }
}
