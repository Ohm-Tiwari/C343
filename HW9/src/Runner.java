import java.util.*;
import java.io.*;

public class Runner {

    public static void main(String[] args) throws IOException{
        // TODO: write the runner so that it follows the same format as the directions
        Scanner s = new Scanner(System.in);

        System.out.println("Please input an image:");
        String inFile = s.nextLine();


        System.out.println("Enter number of vertical seams to remove:");
        int NumOfVertSeams = s.nextInt();
        if (NumOfVertSeams <= 0) {
            System.out.println("Invalid number of vertical seams to remove: " + NumOfVertSeams);
            return;
        }

        System.out.println("Enter number of Horizontal seams to remove:");
        int NumOfHoriSeams = s.nextInt();
        if (NumOfHoriSeams <= 0) {
            System.out.println("Invalid number of vertical seams to remove: " + NumOfHoriSeams);
            return;
        }


        System.out.print("Enter the output file: ");
        String outFile = s.next();

        Picture inPicture = new Picture(inFile);
        inPicture.show();

        SeamCarver sc = new SeamCarver(inPicture);

        for(int i = 0; i < NumOfVertSeams ; i++){
            int[] seam = sc.findVerticalSeam();
            sc.removeVerticalSeam(seam);
        }

        for(int i = 0; i < NumOfHoriSeams ; i++){
            int[] seam = sc.findHorizontalSeam();
            sc.removeHorizontalSeam(seam);
        }

        File output = new File(outFile);
        sc.picture().show();
        sc.picture().save(output);
    }
}
