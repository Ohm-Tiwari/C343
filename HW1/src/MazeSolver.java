import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class MazeSolver {
    static char[][] maze;
    static int m, n; // dimensions of the maze; row and col

    /*
    TODO: setMaze - sets up the board
    This method will take in a String, file, which is the path of the file we want to look at.
    Using BufferedReader and FileReader, write this method so that it sets the rows, m, and columns, n,
    to the first line of input. Then it fills the maze with the maze from the file.
     */
    public static void setMaze(String file) throws IOException {
        // modify
        BufferedReader in = new BufferedReader(new FileReader(file));

        String size = in.readLine();
        int spaceCount = 0;
        int count = 0;
        for (int i = 0; i < size.length(); i++) {
            char c = size.charAt(i);
            if (c == ' ') {
                spaceCount = count;
            }
            count++;
        }
        m = Integer.parseInt(size.substring(0, spaceCount));
        n = Integer.parseInt(size.substring(spaceCount + 1, size.length()));

        maze = new char[m][n];

        for (int i = 0 ; i < m ; i++){
            String l = in.readLine();
            for (int k = 0; k < n ; k++){
                maze[i][k] = l.charAt(k);
            }
        }

    }



    /*
    TODO: isValid - checks if a position on the board has not been visited and is within bounds
     */
    /*
    check if position on board is within bounds:
    x < m and y < n
    check if position has not been visited
     */

    public static boolean isValid(int x, int y) {
        if (x >= 0 && y >= 0 && x < m && y < n){
            if (maze[x][y] == '=' ||  maze[x][y] == '#' || maze[x][y] == 'S' ){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }

    }

    /*
    TODO: solveMaze - recursive function which will traverse the maze and find whether it's solveable S -> G
    The input is the index that we want to check: x = row, y = column
    ------ Hint -------
    Cell(i,j) is "#" return false
    Cell(i,j) is ‘G’ return true
    Otherwise, mark cell(i,j) as visited (maybe make it a wall) and
    return if you can find a way out from the top, bottom, left, or right…
     */
    public static boolean solveMaze(int x, int y) {

        if (maze[x][y] == 'G'){
            return true;
        }
        else if (maze[x][y] == '.'){
            maze[x][y] = '=';
        }
        return (isValid(x-1, y) && solveMaze(x-1, y)) ||
                (isValid(x+1, y) && solveMaze(x+1, y)) ||
                (isValid(x, y-1) && solveMaze(x, y-1)) ||
                (isValid(x, y+1) && solveMaze(x, y+1));
    }

    /*
    TODO: solve - sets the maze up, solves the board, print whether it can be solved or not, returns whether its solvable or not
     */
    public static boolean solve(String file) throws IOException {
        // modify
        setMaze(file); // sets the maze up

        int x = 0;
        int y = 0;

        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                if (maze[i][k] == 'S') {
                    x = i;
                    y = k;
                }
            }
        }
        boolean canSolve = solveMaze(x,y);

        System.out.println("Maze can solve: " + (canSolve));
        return canSolve;
    }

}


