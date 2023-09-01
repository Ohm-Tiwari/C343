import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class SeamCarverTest {
    // TODO: Provide accuracy tests on the methods marked with TODO && provide your own images to SeamCarve! (original + seamcarved)



    @Test
    void WhaleTest(){
        //checks width of old image vs new image
        Picture p = new Picture("whale.jpeg");
        SeamCarver s = new SeamCarver(p);
        assertEquals(1080,s.width());
        assertEquals(720,s.height());

        //after running the seam carver. This is the new image of whale.jpeg named "whale2.jpeg" carved 500x500
        Picture p2 = new Picture("whale2.jpeg");
        SeamCarver s2 = new SeamCarver(p2);
        assertEquals(580,s2.width());
        assertEquals(220,s2.height());

    }

    @Test
    void FishTest() throws IOException{
        //checks width of old image vs new image
        Picture p = new Picture("fish.jpeg");
        SeamCarver s = new SeamCarver(p);
        assertEquals(2000,s.width());
        assertEquals(1335,s.height());

        //after running the seam carver. This is the new image of whale.jpeg named "fish2.jpeg" carved 500x500
        Picture p2 = new Picture("fish2.jpeg");
        SeamCarver s2 = new SeamCarver(p2);
        assertEquals(1950,s2.width());
        assertEquals(1285,s2.height());


    }


}
