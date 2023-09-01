import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class SearchEngineTest {
    // TODO: efficiency test and accuracy test


    @Test
    public void testBSTBuildList() throws IOException {
        SearchEngine engine = new SearchEngine(3); // create a BST search engine
        engine.buildList();
        assertEquals(3, engine.getNodeTree().size());
    }

    @Test
    public void BSTEfficiencyTest() throws IOException{
        SearchEngine BSTengine = new SearchEngine(3);
        long startTime = System.currentTimeMillis();
        BSTengine.buildList();
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Time: " + totalTime);
        assertFalse(totalTime < 10000);

    }

    @Test
    public void BSTtestSearch() throws IOException {
        SearchEngine engine = new SearchEngine(3); // create a BST search engine
        engine.buildList();
        ArrayList<String> urls = engine.search("computer");
        assertEquals(1, urls.size());
        assertEquals("https://en.wikipedia.org/wiki/Computer_Science", urls.get(0));
    }

    @Test
    public void testAVLBuildList() throws IOException {
        SearchEngine engine = new SearchEngine(4); // create a AVL search engine
        engine.buildList();
        assertEquals(4, engine.getNodeTree().size());
    }

    @Test
    public void AVLEfficiencyTest() throws IOException{
        SearchEngine AVLengine = new SearchEngine(4);
        long startTime = System.currentTimeMillis();
        AVLengine.buildList();
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Time: " + totalTime);
        assertFalse(totalTime < 10000);

    }

    @Test
    public void AVLtestSearch() throws IOException {
        SearchEngine engine = new SearchEngine(4); // create a AVL search engine
        engine.buildList();
        ArrayList<String> urls = engine.search("computer");
        assertEquals(1, urls.size());
        assertEquals("https://en.wikipedia.org/wiki/Computer_Science", urls.get(0));
    }


}
