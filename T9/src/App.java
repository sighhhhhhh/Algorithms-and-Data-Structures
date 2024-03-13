import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        T9 Words = new T9("kelly.csv");
        ArrayList<String> PossibleWords = Words.decode("616");

        for (int i=0; i<PossibleWords.size(); i++) {
            String curr = PossibleWords.get(i);
            System.out.println(curr);
          }
    }
}
