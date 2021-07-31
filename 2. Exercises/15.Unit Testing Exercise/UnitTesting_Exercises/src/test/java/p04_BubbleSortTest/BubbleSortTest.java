package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {
    private static final int[] arr = {2, 5, 1, 4, 6, 3};
    private static final int[] sortedArr = {1, 2, 3, 4, 5, 6};

    @Test
    public void testSortMethodCorrectSortingTheElements() {
        Bubble.sort(arr);
        Assert.assertArrayEquals(sortedArr, arr);
        for (int i = 0; i <sortedArr.length ; i++) {
            Assert.assertEquals(sortedArr[i],arr[i]);
        }
    }

}
