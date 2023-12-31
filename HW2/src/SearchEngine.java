import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class SearchEngine {

    private int mode;
    private List<Node> nodeList;

    // TODO: build the SearchEngine's nodelist according to mode (1 = ArrayList; 2 = SortedArrayList); build the searchEngine
    public SearchEngine(int mode) throws IOException {
        if (mode != 1 && mode != 2){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        else if (mode == 1){
            nodeList = new ArrayList(10);
        }
        else {
            nodeList = new SortedArrayList(10);
        }
    }

    public List<Node> getNodeList(){
        return this.nodeList;
    }

    // TODO: Go through the dataset and then create a new Node if the word hasn't been seen before. Add the current URL to its references
    // if it hasn't been seen. If the node has been created already, add the current URL to its references. Add the Node to the the
    // SearchEngine's nodeList
    public void buildList() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("dataset.txt"));
        String url;
        while((url = reader.readLine()) != null){
            Document doc = Jsoup.connect(url).get();
            String text = doc.body().text().toLowerCase();
            String[] words = text.split("\\s+"); // splits by whitespace
            // logic here
            for (int i = 0; i < words.length; i++){
                Node n = null;
                boolean found = false;
                //String word = words[i];

                for (int k = 0 ; k < nodeList.size() ; k++) {
                    n = nodeList.get(k);
                    if (n.getKeyword().equals(i)) {

                        found = true;
                        break;
                    }
                }
                boolean referenceFound = false;
                List<String> references = n.getReferences();
                if (!referenceFound) {
                    n.getReferences().add(url);
                }
                if (!found) {
                    nodeList.add(n);
                }
            }
        }
        reader.close();
        System.out.println("Read through all URLs");
    }

    // TODO: Return the node's reference list - if the term isn't found, return an empty list
    public List<String> search(String term) {
        System.out.println("Searching for " + term + " using data structure mode " + mode + "...");
        // Search logic goes here
        List<String> reference = new ArrayList<>();
        for (int i = 0 ; i < nodeList.size() ; i++){
            Node n = nodeList.get(i);
            if(n.getKeyword().equals(term)){
                reference = n.getReferences();
                break;
            }
        }

        // Example code for displaying results
        System.out.println("Displaying results for " + term + ":");

        for (int i = 0; i < reference.size(); i++) {
            System.out.println(i + ". URL " + i + ": " + reference.get(i));
        }

        System.out.println("    1. URL 1: ");
        System.out.println("    2. URL 2: ");
        System.out.println("    3. URL 3: ");

        return reference;
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter mode as in what data structure to use:");
        System.out.println("    1. Array List ");
        System.out.println("    2. Sorted Array List");

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
