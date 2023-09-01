import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchEngine {
    private int mode;
    private Dictionary<String, Node> nodeTable;

    // build everything bahahah
    // TODO: mode 5 = Openaddressing mode 6 = Chaining; build
    public SearchEngine(int mode) throws IOException {
        this.mode = mode;
        if (mode != 5 && mode != 6) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (mode == 5) {
            nodeTable = new HashTableOpenAddressing<>();
        } else {
            nodeTable = new HashTableWithChaining<>();

        }
        buildList();
    }

    public Dictionary<String, Node> getNodeTree(){
        return this.nodeTable;
    }

    // TODO: assumes that the file exists already
    public void buildList() throws IOException {
        System.out.println("reading");
        BufferedReader reader = new BufferedReader(new FileReader("dataset.txt"));
        String url;
        while((url = reader.readLine()) != null){
            Document doc = Jsoup.connect(url).get();
            String text = doc.body().text().toLowerCase();

            String[] words = text.split("\\s+"); // splits by whitespace
            int count = 0;
            for (String word : words) {
                // TODO:
                Node node = nodeTable.get(word);
                if (node == null){
                    node = new Node(word);
                    nodeTable.put(word, node);
                }
                node.insertReference(url);
            }
        }
        reader.close();
        System.out.println("Finished reading through all URLs");
    }

    // TODO: return the results from one term
    public ArrayList<String> search(String term) throws IOException{
        System.out.println("Searching for " + term + " using data structure mode " + mode + "...");
        Node node = nodeTable.get(term);


        if (nodeTable.containsKey(term)) {
            ArrayList<String> reference = nodeTable.get(term).getReferences();
            System.out.println("Displaying results for " + term + ":");
            for (int i = 0; i < reference.size(); i++) {
                System.out.println(reference.get(i));
            }
            return reference;
        }

        return null;


    }

    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);

        System.out.println("Enter mode as in what data structure to use:");
        System.out.println("    5. HashTableOpenAddressing ");
        System.out.println("    6. HashTableWithChaining");

        int mode = input.nextInt();

        System.out.println("Building Search Engine...");
        SearchEngine engine = new SearchEngine(mode);

        String answer = "y";
        while (answer.equals("y")) {
            input.nextLine(); // consume the remaining newline character
            System.out.print("Search (enter a term to query): ");
            String term = input.nextLine();
            engine.search(term);
            System.out.print("Would you like to search another term (y/n)? ");
            answer = input.nextLine();
        }
        input.close();
    }
}