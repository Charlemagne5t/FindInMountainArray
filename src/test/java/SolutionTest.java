import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void findInMountainArrayTest1() {
        int[] array = {1, 2, 3, 4, 5, 3, 1};
        int target = 3;
        int expected = 2;
        int actual = new Solution().findInMountainArray(target, new Mountain(array));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findInMountainArrayTest2() {
        int[] array = {0, 1, 2, 4, 2, 1};
        int target = 3;
        int expected = -1;
        int actual = new Solution().findInMountainArray(target, new Mountain(array));

        Assert.assertEquals(expected, actual);
    }
}
