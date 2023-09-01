import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AutoCompleteTest {
    // TODO: accuracy tests

    @Test
    void autoCompleteTest() throws IOException {
        AutoComplete a = new AutoComplete("random.txt");
        ArrayList<Entry> e = new ArrayList<>();
        e.add(new Entry(1,"carboxylation"));
        e.add(new Entry(1, "cat"));
        e.add(new Entry(1, "california"));
        e.add(new Entry(1, "called"));
        e.add(new Entry(1, "calloway"));
        e.add(new Entry(1, "cant"));


        assertEquals(e,a.autoComplete("ca"));
        assertEquals(0,a.autoComplete("sdfbisudfbk").size());

    }


    @Test
    void bubbleSortTest() throws IOException {
        ArrayList<Entry> res = new ArrayList<>();
        res.add(new Entry(3, "cat"));
        res.add(new Entry(1, "cant"));
        res.add(new Entry(2, "calf"));
        AutoComplete a = new AutoComplete("dataset.txt");
        a.bubbleSort(res);
        ArrayList<Entry> list = new ArrayList<Entry>();
        list.add(new Entry(3,"cat"));
        list.add(new Entry(2,"calf"));
        list.add(new Entry(1,"cant"));
        assertArrayEquals(res.toArray(), list.toArray());

    }
}
