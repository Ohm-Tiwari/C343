import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class SearchEngineTest {
    // TODO: accuracy tests + 1 efficiency test to make sure both hashtables build in under a minute
    @Test
    public void searchEngineExceptionTest() throws IOException {

        //Tests the exception
        try {
            SearchEngine e = new SearchEngine(24);
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
        }

    }

    @Test
    public void buildListTest() throws IOException{
        SearchEngine HTOA = new SearchEngine(5);
        HTOA.buildList();
        assertEquals(4, HTOA.getNodeTree());

        SearchEngine HTC = new SearchEngine(6);
        HTC.buildList();
        assertEquals(4, HTC.getNodeTree());
    }


    @Test
    public void HTOAsearchTest() throws IOException{
        SearchEngine HTOA = new SearchEngine(5);
        HTOA.buildList();
        ArrayList<String> urls = HTOA.search("computer");
        assertEquals(1, urls.size());
        assertEquals("https://en.wikipedia.org/wiki/Computer_Science", urls.get(0));
    }

    @Test
    public void HTCsearchTest() throws IOException{
        SearchEngine HTC = new SearchEngine(6);
        HTC.buildList();
        ArrayList<String> urls = HTC.search("computer");
        assertEquals(1, urls.size());
        assertEquals("https://en.wikipedia.org/wiki/Computer_Science", urls.get(0));

    }

    @Test
    public void searchNullTest() throws IOException{
        SearchEngine searchEngine = new SearchEngine(5);
        searchEngine.buildList();
        ArrayList<String> urls = searchEngine.search(null);
        assertTrue(urls.isEmpty());

    }


    @Test
    public void EfficiencyTest() throws IOException{
        SearchEngine HTOA = new SearchEngine(5);
        long start = System.currentTimeMillis();
        HTOA.buildList();
        long end = System.currentTimeMillis();
        long HTOATime =  end - start;
        System.out.println(HTOATime);

        SearchEngine HTC = new SearchEngine(6);
        long HTCstart = System.currentTimeMillis();
        HTC.buildList();
        long HTCend = System.currentTimeMillis();
        long HTCTime = end - start;
        System.out.println(HTCTime);

        assertTrue(HTOATime < HTCTime);

    }


}