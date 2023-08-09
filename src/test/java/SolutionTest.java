import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void minimizeMaxTest1() {
        int[] nums = {10, 1, 2, 7, 1, 3};
        int p = 2;
        int expected = 1;
        int actual = new Solution().minimizeMax(nums, p);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minimizeMaxTest2() {
        int[] nums = {4, 2, 1, 2};
        int p = 1;
        int expected = 0;
        int actual = new Solution().minimizeMax(nums, p);
        Assert.assertEquals(expected, actual);
    }
}
