import org.junit.jupiter.api.Test;
import org.python.stdlib.datetime.TimeDelta;

import java.sql.Time;
import java.util.Collections;
import java.util.HashMap;

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
    public void test_2_arguments() {
        org.python.Object[] args = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(2) };
        TimeDelta td = new TimeDelta(args, Collections.EMPTY_MAP);
        assertEquals(new org.python.types.Str("1"), td.__days__());
        assertEquals(new org.python.types.Str("2"), td.__seconds__());
        assertEquals(new org.python.types.Str("0"), td.__microseconds__());
    }

    @Test
    public void test_1_argument() {
        org.python.Object[] args = { org.python.types.Int.getInt(1) };
        TimeDelta td = new TimeDelta(args, Collections.EMPTY_MAP);
        assertEquals(new org.python.types.Str("1"), td.__days__());
        assertEquals(new org.python.types.Str("0"), td.__seconds__());
        assertEquals(new org.python.types.Str("0"), td.__microseconds__());
    }

    @Test
    public void test_kwargs() {
        org.python.Object[] args = { org.python.types.Int.getInt(1) };
        java.util.Map<java.lang.String, org.python.Object> kwargs = new HashMap();
        kwargs.put("minutes", org.python.types.Int.getInt(1));
        TimeDelta td = new TimeDelta(args, kwargs);
        assertEquals(new org.python.types.Str("1"), td.__days__());
        assertEquals(new org.python.types.Str("60"), td.__seconds__());
        assertEquals(new org.python.types.Str("0"), td.__microseconds__());
    }

    @Test
    public void test_many_kwargs() {
        org.python.Object[] args = { org.python.types.Int.getInt(1) };
        java.util.Map<java.lang.String, org.python.Object> kwargs = new HashMap();
        kwargs.put("milliseconds", org.python.types.Int.getInt(1));
        kwargs.put("minutes", org.python.types.Int.getInt(1));
        kwargs.put("hours", org.python.types.Int.getInt(1));
        kwargs.put("weeks", org.python.types.Int.getInt(1));
        TimeDelta td = new TimeDelta(args, kwargs);
        assertEquals(new org.python.types.Str("8"), td.__days__());
        assertEquals(new org.python.types.Str("3660"), td.__seconds__());
        assertEquals(new org.python.types.Str("1000"), td.__microseconds__());
    }

    @Test
    public void test_all_args() {
        org.python.Object[] args = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(1), org.python.types.Int.getInt(1), org.python.types.Int.getInt(1), org.python.types.Int.getInt(1), org.python.types.Int.getInt(1), org.python.types.Int.getInt(1) };
        TimeDelta td = new TimeDelta(args, Collections.EMPTY_MAP);
        assertEquals(new org.python.types.Str("8"), td.__days__());
        assertEquals(new org.python.types.Str("3661"), td.__seconds__());
        assertEquals(new org.python.types.Str("1001"), td.__microseconds__());
    }

    @Test
    public void test_negative_argument() {
        org.python.Object[] args = { org.python.types.Int.getInt(-1) };
        TimeDelta td = new TimeDelta(args, Collections.EMPTY_MAP);
        assertEquals(new org.python.types.Str("-1"), td.__days__());
        assertEquals(new org.python.types.Str("0"), td.__seconds__());
        assertEquals(new org.python.types.Str("0"), td.__microseconds__());
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
