import org.junit.Assert;
import org.junit.Test;
import problems._String;

/**
 * Created by kiryl_zayets on 8/16/18.
 */
public class TestString {

    @Test
    public void testExpression() {
        double exp_result = _String.calculateExpression("5+(3*2)+(4*2)+((3-2)" +
                "+(3*2))");
        double exp_result2 = _String.calculateExpression("((5-(3*2))-(4*2))+(" +
                "(3/2)+(2-3))");
        Assert.assertEquals(exp_result, 26, 0.0);
        Assert.assertEquals(exp_result2, -8.5, 0.0);
    }

}
