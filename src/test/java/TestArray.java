import problems._Array;
import org.junit.Assert;
import org.junit.Test;

/**
 * Basic tests for array manipulations
 */

public class TestArray {
    _Array array = new _Array();

    @Test
    public void testMax(){
        int[] arr1 = new int[] {10,2,4,22,6,7,8,24};
        array.findMax(arr1);
    }

    @Test
    public void testReverse(){
        int[] arr1 = new int[] {10,2,4,22,6,7,8,24};
        int[] t = array.reverse(arr1);
        Assert.assertArrayEquals(t, new int[]{24,8,7,6,22,4,2,10});
    }

    @Test
    public void testBinarySearch (){
        int[] arr1 = new int[] {1,2,4,10,16,17,18,24};

        Assert.assertEquals(array.binarySearch(arr1,24, 0, arr1.length), 24);
        Assert.assertEquals(array.binarySearch(arr1, 23, 0, arr1.length), -1);
    }
}

