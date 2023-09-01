import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class SearchEngineTest {
    /*
    TODO: Write an efficiency test which asserts that the SortedArrayTest is faster than the ArrayList. Be sure to test for edge cases.
    Also be sure to write tests that check whether your SearchEngine has accurate results.
     */
    @Test
    public void ArrayListTest() throws IOException{
        SearchEngine engine1 = new SearchEngine(1);
        long start1 = System.currentTimeMillis();
        engine1.buildList();
        long end1 = System.currentTimeMillis();
        long ArrayListTime =  end1 - start1;
        System.out.println(ArrayListTime);


    }

    @Test
    public void SortedArrayListTest() throws IOException{
        SearchEngine engine2 = new SearchEngine(2);
        long start1 = System.currentTimeMillis();
        engine2.buildList();
        long end1 = System.currentTimeMillis();
        long SortedArrayListTime = end1 - start1;
        System.out.println(SortedArrayListTime);

    }






}
