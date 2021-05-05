import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    @Test(expected = NumberFormatException.class)
    public void test_empty() {
        Integer.decode("");
    }

    @Test
    public void test_symbol() {
        assertEquals(1, Integer.decode("+1"));
        assertEquals(1, Integer.decode("1"));
        assertEquals(-1, Integer.decode("-1"));
    }

    @Test(expected = NumberFormatException.class)
    public void test_wrong_position_symbol() {
        Integer.decode("0x-1");
        Integer.decode("0x+1");
        Integer.decode("--");
        Integer.decode("0X1-1");
    }

    @Test
    public void test_zero() {
        assertEquals(0, Integer.decode("0"));
        assertEquals(0, Integer.decode("+0"));
        assertEquals(0, Integer.decode("-0"));
    }

    @Test
    public void test_hex() {
        assertEquals(32, Integer.decode("0x20"));
        assertEquals(32, Integer.decode("0X20"));
        assertEquals(32, Integer.decode("#20"));
        assertEquals(-32, Integer.decode("-#20"));
    }

    @Test
    public void test_oct() {
        assertEquals(32, Integer.decode("040"));
        assertEquals(-32, Integer.decode("-040"));
    }

    @Test(expected = NumberFormatException.class)
    public void test_wrong_format() {
        Integer.decode("some non-integer string");
        Integer.decode(" ");
        Integer.decode("1.25");
        Integer.decode("1,25");
    }

    @Test
    public void test_min_value() {
        assertEquals(Integer.MIN_VALUE, Integer.decode(String.valueOf(Integer.MIN_VALUE)));
        assertEquals(-Integer.MIN_VALUE, Integer.decode(String.valueOf(-Integer.MIN_VALUE)));
    }
}
