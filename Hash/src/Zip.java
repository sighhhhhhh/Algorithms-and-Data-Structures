import java.io.BufferedReader;
import java.io.FileReader;
public class Zip {
    Node[] data;
    int max;
    Integer[] keys;
    Integer mod = 13513;
    Node[][] HashTable;
    Node[] HashTable2;
    public class Node {
        Integer code;
        String name;
        Integer pop;

        public Node(Integer code, String name, Integer pop){
            this.code = code;
            this.name = name;
            this.pop = pop;
        }
    }

    public Zip(String file) {
        data = new Node[100000];
        keys = new Integer[100000];
        HashTable = new Node[mod][1];
        HashTable2 = new Node [200000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                bucketAdd(new Node(code, row[1], Integer.valueOf(row[2])));
                bucketAdd2(new Node(code, row[1], Integer.valueOf(row[2])));
                keys[i++] = code;
                data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
       }
    }

    public String linear (Integer zip){
        int index = 0;

        while(true){
            int cmp = zip - data[index].code;
            if (cmp == 0){
                return data[index].name;
            }
            if (index == max){
                return null;
            }
            index++;
        }

    }

    public void bucketAdd(Node node){
        int hashIndex = node.code%mod;
        
        if (HashTable[hashIndex][0] == null){
            HashTable[hashIndex][0] = node;
            return;
        }

        Node[] bucket = new Node[HashTable[hashIndex].length + 1];

        for(int i = 0; i < HashTable[hashIndex].length; i++){
            bucket[i] = HashTable[hashIndex][i];
        }
        bucket[bucket.length-1] = node;
        HashTable[hashIndex] = bucket;
    }

    public void bucketAdd2(Node node){
        int HashIndex = (node.code%mod);
        while(HashTable2[HashIndex] != null){
            HashIndex++;
        }
        HashTable2[HashIndex] = node;
    }
    
    public String binary (Integer zip){
        int mn = 0;
        int mx = max ;
        while ( true ) {
            int index = ( mn + mx )/2;
            int cmp = zip - data[index].code;
            if ( cmp == 0) {
                return data [ index ]. name ;
            }
            if(cmp < 0){
                mx = index - 1;
            }
            else{
                mn = index + 1;
            }
            if(mn == mx)
                break;
        }
        return null ;
    }


    public String lookup (Integer zip){
        if (zip == data[zip].code)
            return data[zip].name;
        return null;
    }

    public String Hashlookup (Integer zip){
        int a = 1;
        int hashIndex = zip%mod;
        for(int i = 0; i < HashTable[hashIndex].length; i++){
            if(HashTable[hashIndex][i].code - zip == 0){
                System.out.println(HashTable[hashIndex][i].name);
                System.out.println("lookup1 looked through " + a + " elements");
                return HashTable[hashIndex][i].name;
            }
        a++;
        }
        return null;
    }

    public String Hashlookup2 (Integer zip){
        int a = 1;
        int HashIndex = (zip%mod);
        while(HashTable2[HashIndex] != null && HashIndex < HashTable2.length){
            if (HashTable2[HashIndex].code - zip == 0){
                System.out.println(HashTable2[HashIndex].name);
                System.out.println("lookup 2 looked through " + a + " elements");
                return HashTable2[HashIndex].name;
            }
            HashIndex++;
            a++;
        }
        return null;
    }

    public void collisions(int mod) {
        int[] data = new int[mod];
        int[] cols = new int[10];
        for (int i = 0; i < max; i++) {
            Integer index = keys[i] % mod;
            cols[data[index]]++;
            data[index]++;
        }
        System.out.print(mod);
        for (int i = 0; i < 10; i++) {
        System.out.print("\t" + cols[i]);
        }
        System.out.println();
        }
}