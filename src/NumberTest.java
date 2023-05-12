import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NumberTest {
    private final double DELTA = 0.0000001;
    private Number num;
    @Before
    public void init() {
        num = new Number(17.0);
    }

    @Test
    public void testGetValue() {
        double result = num.getValue();
        assertEquals(17.0, result, DELTA);
    }

    @Test
    public void testEvaluate() {
        double result = num.evaluate();
        assertEquals(17.0, result, DELTA);
    }

    @Test
    public void testToString() {
        String result = num.toString();
        assertEquals("17.0", result);
    }
}