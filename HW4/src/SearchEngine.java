import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchEngine {
    private int mode;
    private Tree<Node> nodeTree; // List -> Tree

    // build everything bahahah
    // TODO: mode 3 = BST mode 4 = AVL
    public SearchEngine(int mode) throws IOException {
        this.mode = mode;
        if (mode != 3 && mode != 4) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (mode == 3) {
            nodeTree = new BST<>();
        } else {
            nodeTree = new AVL<>();
        }
    }


    public Tree<Node> getNodeTree(){
        return this.nodeTree;
    }

    // assumes that the file exists already
    // TODO: tweak logic so that it builds the proper tree
    public void buildList() throws IOException {
        System.out.println("reading");
        BufferedReader reader = new BufferedReader(new FileReader("dataset.txt"));
        String url;
        while((url = reader.readLine()) != null){
            Document doc = Jsoup.connect(url).get();
            String text = doc.body().text().toLowerCase();
            String[] words = text.split("\\s+"); // splits by whitespace
            for (String word : words) {
                // HERE
                Node newNode = new Node(word);
                newNode.insertReference(url);
                nodeTree.insert(newNode);
            }
        }
        reader.close();
        System.out.println("Finished reading through all URLs");
    }

    // ._.
    // TODO: Return the reference list of URLs
    public ArrayList<String> search(String term) throws IOException {
        System.out.println("Searching for " + term + " using data structure mode " + mode + "...");
        // Search logic goes here
        ArrayList<String> reference = null;

        Node targetNode = new Node(term);
        BinaryNode<Node> node = nodeTree.search(targetNode);

        if (node != null) {
            reference = node.data().getReferences();

        }
        System.out.println("Displaying results for " + term + ":");
        for (int i = 0; i < reference.size(); i++) {
            System.out.println(i + ". URL " + i + ": " + reference.get(i));
        }
        return reference;
    }


    public static void main(String[] args) throws IOException{
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