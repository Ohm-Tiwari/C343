// Used to compile the TrieNode children into one singular Entry

public class Entry {
    private int frequency;
    private String name;

    public Entry(int freq, String name){
        this.frequency = freq;
        this.name = name;
    }

    public void setFrequency(int frequency){
        this.frequency = frequency;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getFrequency(){
        return this.frequency;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return name + " (frequency: " + frequency +")";
    }

    public boolean equals(Object o)
    {
        Entry temp = (Entry) o;
        return temp.name.equals(this.name) && temp.frequency == this.frequency;
    }
}
