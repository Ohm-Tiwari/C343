import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;





public class MazeSolverTest {

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
    public void solveMazeStackTest() throws EmptyStackE, EmptyListE{
        char[][] m = {{'S', ' ', 'G'},
                        {' ', ' ', ' '},
                        {' ', ' ', ' '}};
        MazeSolver.maze = m;
        MazeSolver.m = m.length;
        MazeSolver.n = m[0].length;
        assertTrue(MazeSolver.solveMazeStack(0, 0));
        char[][] m2 = {{'S', '#', 'G'},
                {' ', '#', ' '},
                {' ', '#', ' '}};
        MazeSolver.maze = m2;
        MazeSolver.m = m2.length;
        MazeSolver.n = m2[0].length;
        assertFalse(MazeSolver.solveMazeStack(0, 0));
    }

    @Test
    public void solveMazeQueueTest() throws EmptyQueueE, EmptyListE{
        char[][] m = {{'S', ' ', 'G'},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};
        MazeSolver.maze = m;
        MazeSolver.m = m.length;
        MazeSolver.n = m[0].length;
        assertTrue(MazeSolver.solveMazeQueue(0, 0));


    }

    @Test
    public void solveTest() throws EmptyStackE, EmptyQueueE, EmptyListE, IOException {
        assertFalse(MazeSolver.solve("maze3.txt", 1));
        assertFalse(MazeSolver.solve("maze3.txt", 2));

        assertTrue(MazeSolver.solve("maze1.txt", 1));
        assertTrue(MazeSolver.solve("maze1.txt", 2));

    }




}
