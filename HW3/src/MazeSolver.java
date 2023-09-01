import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// Feel free to reuse from HW1

public class MazeSolver {
    static char[][] maze;
    static int m, n; // dimensions of the maze

    /*
    TODO: setMaze - sets up the board
    This method will take in a String, file, which is the path of the file we want to look at.
    Using BufferedReader and FileReader, write this method so that it sets the rows, m, and columns, n,
    to the first line of input. Then it fills the maze with the maze from the file.
     */
    public static void setMaze(String file) throws IOException {
        FileReader input = new FileReader(file);
        BufferedReader in = new BufferedReader(input);
        String size = in.readLine();
        int spaceCount = 0;
        int count = 0;
        for (char c : size.toCharArray()) {
            if (c == ' ') {
                spaceCount = count;
            }
            count++;
        }
        m = Integer.parseInt(size.substring(0, spaceCount));
        n = Integer.parseInt(size.substring(spaceCount + 1, size.length()));
        maze = new char[m][n];
        for (int i = 0; i < m; i++) {
            String nLine = in.readLine();
            for (int k = 0; k < n; k++) {
                maze[i][k] = nLine.charAt(k);
            }
        }
    }

    /*
    TODO: isValid - checks if a position on the board has not been visited and is within bounds
     */
    public static boolean isValid(int x, int y) {
        if (x >= 0 && y >= 0 && x < m && y < n) {
            if (maze[x][y] == '#' || maze[x][y] == 'S' || maze[x][y] == '=') {
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }

    //Helper function to help store x and y coordinates in the maze.
    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /*
    TODO: Using a stack, solve the maze WITHOUT recursion.
    Pseudo:
    1) Push start position onto Stack.
    2) While it's not empty;
        3) Pop from the stack to get the current considered location
        4) If it's already explored ignore
        5) If it's the goal, return true
        6) If it's not the goal, then explore it.
        7) You will need to compute all the possible neighbors. Then push those on the stack
    8) Return false
     */

    public static boolean solveMazeStack(int x, int y) throws EmptyStackE, EmptyListE {
        Stack<Coord> s = new Stack<>();
        s.push(new Coord(x, y));
        while (s.size() != 0) {
            Coord curr = s.pop();
            x = curr.getX();
            y = curr.getY();
            if (isValid(x,y) && maze[x][y] == 'G') {
                return true;
            }
            else {
                maze[x][y] = '=';
            }
            if (isValid(x + 1, y)){
                s.push(new Coord(x + 1, y));
            }
            if (isValid(x, y + 1)){
                s.push(new Coord(x, y + 1));
            }
            if (isValid(x - 1, y)){
                s.push(new Coord(x - 1, y));
            }
            if (isValid(x, y - 1)){
                s.push(new Coord(x, y - 1));
            }
        }
        return false;
    }

    // TODO: Using a queue, solve the maze. Be sure to explain your algorithm for full points.
    public static boolean solveMazeQueue(int x, int y) throws EmptyQueueE, EmptyListE {
        Queue<Coord> q = new Queue<>();
        q.enqueue(new Coord(x, y));

        while (q.size() != 0) {
            Coord curr = q.dequeue();
            x = curr.getX();
            y = curr.getY();
            if (isValid(x, y) && maze[x][y] == 'G') {
                return true;
            }
            else {
                maze[x][y] = '=';
            }
            if (isValid(x + 1, y)){
                q.enqueue(new Coord(x + 1, y));
            }
            if (isValid(x, y + 1)){
                q.enqueue(new Coord(x, y + 1));
            }
            if (isValid(x - 1, y)){
                q.enqueue(new Coord(x - 1, y));
            }
            if (isValid(x, y - 1)){
                q.enqueue(new Coord(x, y - 1));
            }
        }

        return false;

    }

    // TODO: Solve the board. Mode 1 = stack solving. Mode 2 = queue solving.
    // 1: stack
    // 2: queue
    public static boolean solve(String file, int mode) throws IOException, EmptyStackE, EmptyQueueE, EmptyListE {
        setMaze(file);
        int x = 0;
        int y = 0;
        for (int i = 0 ; i < m ; i++) {
            for (int k = 0; k < n; k++) {
                if (maze[i][k] == 'S') {
                    x = i;
                    y = k;
                }
            }
        }
        boolean solve;
        if (mode == 1) {
            solve = solveMazeStack(x, y);
        } else {
            solve = solveMazeQueue(x, y);
        }
        System.out.println("Maze can be solved: " + (solve));
        return solve;
    }
}