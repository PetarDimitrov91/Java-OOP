package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    private Database database;
    private static final Integer[] NUMBERS = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static final Integer NULL_ELEMENT = null;
    private static final Integer ELEMENT_TO_ADD = 11;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.database = new Database(NUMBERS);
    }

    //Constructor test:
    //1-> create valid Object
    @Test
    public void testConstructorCreateValidObject() {
        Integer[] elements = database.getElements();
        Assert.assertEquals(elements.length, NUMBERS.length);
        // for (int i = 0; i < elements.length; i++) {
        //     Assert.assertEquals(NUMBERS[i], elements[i]);//
        // }
        Assert.assertArrayEquals(NUMBERS, elements);
    }

    //2 -> elements > 16 throws
    @Test(expected = OperationNotSupportedException.class)
    public void testCreateDatabaseWithMoreThanSixteenElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new Database(numbers);
    }

    //3 -> elements < 1 throws
    @Test(expected = OperationNotSupportedException.class)
    public void testCreateDatabaseWithLessThanOneElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database(numbers);
    }

    //Test add method:
    //1 -> check if null element throws
    @Test(expected = OperationNotSupportedException.class)
    public void testIfNullElementThrows() throws OperationNotSupportedException {
        database.add(NULL_ELEMENT);
    }

    //2 -> check if last element is equal to ELEMENT_TO_ADD;
    @Test
    public void testLastElementIsEqualToElementThatIsAdded() throws OperationNotSupportedException {
        Integer[] elements1 = database.getElements();
        database.add(ELEMENT_TO_ADD);
        Integer[] elements = database.getElements();
        Integer element = elements[elements.length - 1];
        Assert.assertEquals(ELEMENT_TO_ADD, element);
        Assert.assertEquals(database.getElements().length,elements1.length + 1);
    }

    //Test remove method
    // Check if database whit 0 elements throws
    @Test(expected = OperationNotSupportedException.class)
    public void testIfDatabaseThrowsWhenItsLengthIsNull() throws OperationNotSupportedException {
        for (Integer number : NUMBERS) {
            database.remove();
        }
        database.remove();
    }

    //Check if remove method removes the correct element
    @Test
    public void testRemoveMethodRemovesTheCorrectElement() throws OperationNotSupportedException {
        Integer[] elements = database.getElements();
        database.remove();
        Assert.assertEquals(database.getElements().length, elements.length - 1);
        Assert.assertEquals(elements[elements.length-2], database.getElements()[database.getElements().length-1]);


    }


}
