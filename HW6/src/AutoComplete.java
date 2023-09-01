import java.io.IOException;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AutoComplete {
    private Trie trie;
    private String file = "dataset.txt"; // hardcoded for our testing purposes :p

    public AutoComplete() throws IOException {
        this.trie = new Trie();
        buildTrie();
    }

    public AutoComplete(String file) throws IOException {
        this.trie = new Trie();
        this.file = file;
        buildTrie();
    }

    public Trie getTrie(){
        return this.trie;
    }


    // TODO: Build the trie from the words from the file.
    public void buildTrie() throws IOException {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.file));
            System.out.print(file + " loaded. ");
            Instant start = Instant.now();
            String line;
            int wordCount = 0;
            while((line = reader.readLine()) != null){
                String text = line.toLowerCase();
                text = text.replaceAll("\\p{Punct}", "");
                String[] words = text.split("\\s+"); // splits by whitespace
                for(String word: words){
                    // TODO: add here lol
                    TrieNode cur = trie.getRoot();
                    char[] chars = word.toCharArray();
                    for (int i = 0; i < chars.length; i++) {
                        char c = chars[i];
                        if (!cur.children.containsKey(c)) {
                            cur.children.put(c, new TrieNode());
                        }
                        cur = cur.children.get(c);
                    }
                    cur.isWord = true;
                    cur.frequency++;
                    wordCount++;
                }
            }
            Instant end = Instant.now();
            long time = Duration.between(start, end).toMillis();
            System.out.print(wordCount + " words loaded into Trie in " + time + " ms\n");
        } catch (IOException e){
            throw e;
        }

    }


    // TODO: Returns a list of the top 6 ranked (frequency) words starting with the
    //       given prefix (must use BubbleSort)
    //       Hint: don't overthink this.
    public ArrayList<Entry> autoComplete(String prefix){
        ArrayList<Entry> entries = trie.generateWordsFromPrefix(prefix);
        bubbleSort(entries);
        ArrayList<Entry> result = new ArrayList<>();
        for (int i = 0 ; i < Math.min(6, entries.size()); i++){
            result.add(entries.get(i));
        }
        return result;
    }

    // TODO: Implement BubbleSort. Sort by frequency of the Entry. Return the list of entries sorted.
    //     Hint: https://media.geeksforgeeks.org/wp-content/cdn-uploads/gq/2014/02/bubble-sort1.png
    public ArrayList<Entry> bubbleSort(ArrayList<Entry> ls){
        for(int i = 0; i < ls.size() - 1; i++ ) {
            for (int j = 0; j < ls.size() - i - 1; j++) {
                if(ls.get(j).getFrequency() < ls.get(j+1).getFrequency()) {
                    Entry temp = ls.get(j);
                    ls.set(j,ls.get(j+1));
                    ls.set(j + 1,temp);
                }
            }
        }
        return ls;
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String file = input.nextLine();
        AutoComplete a = new AutoComplete(file);
        String answer = "y";
        while (answer.equals("y")) {
            System.out.print("Enter word to find prefix (0 to quit program): ");
            String term = input.nextLine();
            if(term.equals("0")){
                System.out.println("buh bye");
                break;
            }
            for(Entry e : a.autoComplete(term)){
                System.out.println(e);
            }
            System.out.println("==========================================");
        }
        input.close();

    }
}
