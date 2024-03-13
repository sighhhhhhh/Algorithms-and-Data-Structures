
public class App {
    public static void main(String[] args) throws Exception {
        Zip Sweden = new Zip("postnummer.csv");
        int zipcode = 58238;
        
        System.out.println("Zip Code: " + zipcode);
        Sweden.Hashlookup(zipcode);
        Sweden.Hashlookup2(zipcode);
    }
}
