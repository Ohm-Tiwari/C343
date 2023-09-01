import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Lab1Test {

    @Test
    public void Task1Simple(){
        Lab1.getDigitSum(126); // 9
    }

    @Test
    public void Task2Simple(){
        Lab1.countSevens(717); // 2
    }

    @Test
    public void Task3Simple(){
        System.out.println(Lab1.printInBinary(0));
        System.out.println(Lab1.printInBinary(6));
        Lab1.printInBinary(0); // 0
    }

    @Test
    public void Task4Simple(){
        // write a test for this one if you decide to do it
    }

}
