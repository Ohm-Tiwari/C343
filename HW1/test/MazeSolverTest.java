import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;


import static org.junit.jupiter.api.Assertions.*;

public class MazeSolverTest {
    /*
    TODO - write JUnit tests testing the boards we gave you on the assignment
     */
    @Test
    public void IsValidTest(){
        MazeSolver m = new MazeSolver();
        //if x is less than 0
        assertFalse(m.isValid(-5, 3));
        //if x is greater than m
        assertEquals(m.isValid(50,3),false);
        //if y is less than 0
        assertEquals(m.isValid(2,-3),false);
        //if y is greater than n
        assertEquals(m.isValid(2,50),false);

    }

    @Test
    void solve() throws IOException {
        assertTrue(MazeSolver.solve("maze1.txt"));
        assertTrue(MazeSolver.solve("maze2.txt"));
        assertFalse(MazeSolver.solve("maze3.txt"));
    }
}




