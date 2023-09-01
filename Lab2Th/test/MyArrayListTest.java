import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {

    /*
    TODO: tests
    - Make sure you have 100% code coverage '
    - Make sure you test the full functionality of this class...think edge cases
    - Use JUnit
    - Feel free to add more test methods
     */

    @Test //tests insert and get
    public void InsertAndGetTest(){
        //Given
        MyArrayList m = new MyArrayList(4);

        //tests regular insert
        m.insert(0,24);
        m.insert(1,1);
        m.insert(2,2);
        m.insert(3,3);
        m.insert(4,4);
        m.insert(5,5);
        assertEquals(m.get(5),5);





    }

    @Test
    public void deleteTest(){
        MyArrayList m = new MyArrayList(3);
        m.insert(0,24);
        m.insert(1,1);
        m.insert(2,2);
        m.insert(3,3);
        m.delete(1);
        assertEquals(m.get(1),2);


    }




    @Test //If the value is found in the index
    public void searchTest(){
        MyArrayList m = new MyArrayList(3);
        m.insert(0,24);
        m.insert(1,1);
        m.insert(2,2);
        m.insert(3,3);
        assertEquals(m.search(2),2);
        assertEquals(m.search(500),-1);


    }

    @Test
    public void ExceptionTest(){
        MyArrayList m = new MyArrayList(4);
        m.insert(0,0);
        m.insert(1,1);
        m.insert(2,2);
        m.insert(3,3);
        m.insert(4,4);
        m.insert(5,5); //INSERT EXCEPTION
        assertEquals(m.get(4),4); //GET EXCEPTION
        m.delete(-1); // DELETE EXCEPTION




    }




    }

