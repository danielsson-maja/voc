import org.junit.jupiter.api.Test;
import org.python.stdlib.datetime.TimeDelta;

import java.sql.Time;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeDeltaTest {

    private final org.python.Object[] args1 = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(2), org.python.types.Int.getInt(3) };
    private final TimeDelta td1 = new TimeDelta(args1, Collections.EMPTY_MAP);

    private final org.python.Object[] args2 = { org.python.types.Int.getInt(2), org.python.types.Int.getInt(6), org.python.types.Int.getInt(0) };
    private final TimeDelta td2 = new TimeDelta(args2, Collections.EMPTY_MAP);

    @Test
    public void test_days() {
        assertEquals(new org.python.types.Str("1"), td1.__days__());
    }

    @Test
    public void test_seconds() {
        assertEquals(new org.python.types.Str("2"), td1.__seconds__());
    }

    @Test
    public void test_microseconds() {
        assertEquals(new org.python.types.Str("3"), td1.__microseconds__());
    }

    @Test
    public void test_total_seconds() {
        assertEquals(new org.python.types.Str("86402.000003"), td1.total_seconds());
    }

    @Test
    public void test_add() {
        TimeDelta td_added = (TimeDelta)td1.__add__(td2);
        assertEquals(new org.python.types.Str("3"), td_added.__days__());
        assertEquals(new org.python.types.Str("8"), td_added.__seconds__());
        assertEquals(new org.python.types.Str("3"), td_added.__microseconds__());
    }

    @Test
    public void test_str() {
        assertEquals(new org.python.types.Str( "days: 1, seconds: 2, microseconds: 3"), td1.__str__());
    }


}
