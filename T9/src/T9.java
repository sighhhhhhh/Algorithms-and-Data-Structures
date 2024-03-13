import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class T9 {
    Node root;
    private class Node {
        public Node[] next;
        public boolean valid;

        public Node() {
            next = new Node[27];
            valid = false;
        }

        public void add(String word, int i){
            char chr = word.charAt(i);
            int ind = code(chr);            
            if (next[ind] == null)
                next[ind] = new Node();
            
            if(word.length() == i + 1){
                next[ind].valid = true;
                return;
            }

            next[ind].add(word, i + 1);
        }
    }

    
    public T9(){
        root = new Node();
    }

    public T9(String file){
        root = new Node();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                add(line);
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    private static int code(char w) {
        switch (w) {
        case 'a' :
            return 0;
        case 'b' :
            return 1;
        case 'c' :
            return 2;
        case 'd' :
            return 3;
        case 'e' :
            return 4;
        case 'f' :
            return 5;
        case 'g' :
            return 6;
        case 'h' :
            return 7;
        case 'i' :
            return 8;
        case 'j' :
            return 9;
        case 'k' :
            return 10;
        case 'l' :
            return 11;
        case 'm' :
            return 12;
        case 'n' :
            return 13;
        case 'o' :
            return 14;
        case 'p' :
            return 15;
        case 'r' :
            return 16;
        case 's' :
            return 17;
        case 't' :
            return 18;
        case 'u' :
            return 19;
        case 'v' :
            return 20;
        case 'x' :
            return 21;
        case 'y' :
            return 22;
        case 'z' :
            return 23;
        case 'å' :
            return 24;
        case 'ä' :
            return 25;
        case 'ö' :
            return 26;
        }
        return -1;
    }

    private static Character character(int a) {
        switch (a) {
        case 0 :
            return 'a';
        case 1 :
            return 'b';
        case 2 :
            return 'c';
        case 3 :
            return 'd';
        case 4 :
            return 'e';
        case 5 :
            return 'f';
        case 6 :
            return 'g';
        case 7 :
            return 'h';
        case 8 :
            return 'i';
        case 9 :
            return 'j';
        case 10 :
            return 'k';
        case 11 :
            return 'l';
        case 12 :
            return 'm';
        case 13 :
            return 'n';
        case 14 :
            return 'o';
        case 15 :
            return 'p';
        case 16 :
            return 'r';
        case 17 :
            return 's';
        case 18 :
            return 't';
        case 19 :
            return 'u';
        case 20 :
            return 'v';
        case 21 :
            return 'x';
        case 22 :
            return 'y';
        case 23 :
            return 'z';
        case 24 :
            return 'å';
        case 25 :
            return 'ä';
        case 26 :
            return 'ö';
        }
        return null;
    }

    public static int index(int key){
        return key - 1;
    }

    public void add(String word){
        root.add(word, 0);
    }

    public ArrayList<String> decode(String wordnum){
        ArrayList<String> allWords = new ArrayList<String>();
        collect(root, wordnum, "", 0, allWords);
        return allWords;
    }

    public void collect(Node nod, String sequence, String possibleWord, int i, ArrayList<String> list){
        System.out.println(i);
        if(i == sequence.length()){
            if(nod.valid == true)
                list.add(possibleWord);
            return;
        }
        
        int index = index(Character.getNumericValue(sequence.charAt(i)));

        Node node0 = nod.next[index*3];
        Node node1 = nod.next[index*3 + 1];
        Node node2 = nod.next[index*3 + 2];

        if(node0 != null){
            String pword = possibleWord + character(index*3);
            collect(node0, sequence, pword, i + 1, list);
        }

        if(node1 != null){
            String pword = possibleWord + character(index*3 + 1);
            collect(node1, sequence, pword, i + 1, list);
        }

        if(node2 != null){
            String pword = possibleWord + character(index*3 + 2);
            collect(node2, sequence, pword, i + 1, list);
        }
    
    }
}

