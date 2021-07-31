package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class IteratorTest {
    private static final String[] STRINGS = {"Petar", "Sandra", "Daniel"};
    private static final String[] STRINGS_WITH_ONE_ELEMENT = {"Petar"};
    private static final String[] NULL_STRINGS = null;
    private static int currentIndex;
    private static ListIterator listIterator;

    // Create Object using @Before
    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator(STRINGS);
        currentIndex = 0;
    }

    //1. Constructor test:
    // 1 -> test if null object throws
    @Test(expected = OperationNotSupportedException.class)
    public void testIfCreatingObjectWithNullObjectThrows() throws OperationNotSupportedException {
        new ListIterator(NULL_STRINGS);
    }

    //2. Test method hasNext()
    //1 -> test hasNext returns true
    @Test
    public void testHasNextMethodReturnsTrue() {
        Assert.assertTrue(listIterator.hasNext());
    }

    // 2 -> test hasNext returnsFalse
    @Test
    public void testHastNextMethodReturnsFalse() throws OperationNotSupportedException {
        listIterator = new ListIterator(STRINGS_WITH_ONE_ELEMENT);
        Assert.assertFalse(listIterator.hasNext());
    }

    //3. Test move() method
    //1 -> test if hasNext returns true
    @Test
    public void testIfMoveReturnsTrueWhenHasNextElement() {
        Assert.assertTrue(listIterator.move());
    }

    //2 -> test if hasNext returns false
    @Test
    public void testIfMoveReturnsFalseWhenHasNoNextElement() throws OperationNotSupportedException {
        listIterator = new ListIterator(STRINGS_WITH_ONE_ELEMENT);
        Assert.assertFalse(listIterator.move());
    }

    //4. Test print Method
    //1 -> test if print() throws
    @Test(expected = IllegalStateException.class)
    public void testPrintMethodThrowsWhenHasNoElements() throws OperationNotSupportedException {
        new ListIterator().print();
    }

    @Test
    public void testPrintMethodReturnsTheCorrectString() {
       while (listIterator.hasNext()){
           Assert.assertEquals(listIterator.print(),STRINGS[currentIndex++]);
           listIterator.move();
       }
    }
}
