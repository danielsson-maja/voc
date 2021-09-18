import org.junit.jupiter.api.Test;
import org.python.stdlib.datetime.Date;

import java.util.Collections;
import java.util.HashMap;


public class DateTests {

    private final org.python.Object[] args1 = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(2), org.python.types.Int.getInt(3) };
    private final Date date1 = new Date(args1, Collections.EMPTY_MAP);

    private final org.python.Object[] args2 = { org.python.types.Int.getInt(2), org.python.types.Int.getInt(6), org.python.types.Int.getInt(0) };
    private final Date date2 = new Date(args2, Collections.EMPTY_MAP);

    @Test
    public void test_days() {
        assertEquals(org.python.types.Int.getInt(1), date1.__days__());
    }

    @Test
    public void test_1_argument() {
        org.python.Object[] args = { org.python.types.Int.getInt(1) };
        Date date = new Date(args, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Int.getInt(1), date.__year__());
        assertEquals(org.python.types.Int.getInt(0), date.__month__());
        assertEquals(org.python.types.Int.getInt(0), date.__day__());
    }

    @Test
    public void test_2_arguments() {
        org.python.Object[] args = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(2) };
        Date td = new Date(args, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Int.getInt(1), td.__days__());
        assertEquals(org.python.types.Int.getInt(2), td.__seconds__());
        assertEquals(org.python.types.Int.getInt(0), td.__microseconds__());
    }

    @Test
    public void test_4_args() {
        org.python.Object[] args = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(1), org.python.types.Int.getInt(1), org.python.types.Int.getInt(1) };
        Date td = new Date(args, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Int.getInt(1), td.__days__());
        assertEquals(org.python.types.Int.getInt(1), td.__seconds__());
        assertEquals(org.python.types.Int.getInt(1001), td.__microseconds__());
    }

    @Test
    public void test_5_args() {
        org.python.Object[] args = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(1), org.python.types.Int.getInt(1), org.python.types.Int.getInt(1), org.python.types.Int.getInt(1) };
        Date td = new Date(args, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Int.getInt(1), td.__days__());
        assertEquals(org.python.types.Int.getInt(61), td.__seconds__());
        assertEquals(org.python.types.Int.getInt(1001), td.__microseconds__());
    }

    @Test
    public void test_6_args() {
        org.python.Object[] args = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(1), org.python.types.Int.getInt(1), org.python.types.Int.getInt(1), org.python.types.Int.getInt(1), org.python.types.Int.getInt(1) };
        Date td = new Date(args, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Int.getInt(1), td.__days__());
        assertEquals(org.python.types.Int.getInt(3661), td.__seconds__());
        assertEquals(org.python.types.Int.getInt(1001), td.__microseconds__());
    }

    @Test
    public void test_7_args() {
        org.python.Object[] args = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(1), org.python.types.Int.getInt(1), org.python.types.Int.getInt(1), org.python.types.Int.getInt(1), org.python.types.Int.getInt(1), org.python.types.Int.getInt(1) };
        Date td = new Date(args, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Int.getInt(8), td.__days__());
        assertEquals(org.python.types.Int.getInt(3661), td.__seconds__());
        assertEquals(org.python.types.Int.getInt(1001), td.__microseconds__());
    }

    @Test
    public void test_wrong_type_arg() {
        assertThrows(org.python.exceptions.TypeError.class, () -> {
            org.python.Object[] args1 = { new org.python.types.Str("test") };
            Date td1 = new Date(args1, Collections.EMPTY_MAP);
        });
    }

    @Test
    public void test_wrong_type_kwarg() {
        assertThrows(org.python.exceptions.TypeError.class, () -> {
            org.python.Object[] args1 = { org.python.types.Int.getInt(1) };
            java.util.Map<java.lang.String, org.python.Object> kwargs = new HashMap();
            kwargs.put("minutes", new org.python.types.Str("test"));
            Date td1 = new Date(args1, kwargs);
        });
    }

    @Test
    public void test_mircoseconds_overflow() {
        org.python.Object[] args = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(1), org.python.types.Int.getInt(2000000) };
        Date td = new Date(args, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Int.getInt(1), td.__days__());
        assertEquals(org.python.types.Int.getInt(3), td.__seconds__());
        assertEquals(org.python.types.Int.getInt(0), td.__microseconds__());
    }

    @Test
    public void test_negative_mircoseconds() {
        org.python.Object[] args = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(2), org.python.types.Int.getInt(-5) };
        Date td = new Date(args, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Int.getInt(1), td.__days__());
        assertEquals(org.python.types.Int.getInt(1), td.__seconds__());
        assertEquals(org.python.types.Int.getInt(999995), td.__microseconds__());
    }

    @Test
    public void test_overflow_to_overflow() {
        org.python.Object[] args = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(0), org.python.types.Int.getInt(-5) };
        Date td = new Date(args, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Int.getInt(0), td.__days__());
        assertEquals(org.python.types.Int.getInt(86399), td.__seconds__());
        assertEquals(org.python.types.Int.getInt(999995), td.__microseconds__());
    }

    @Test
    public void test_overflow_with_negative_kwargs() {
        org.python.Object[] args = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(1), org.python.types.Int.getInt(1) };
        java.util.Map<java.lang.String, org.python.Object> kwargs = new HashMap();
        kwargs.put("milliseconds", org.python.types.Int.getInt(-1));
        Date td = new Date(args, kwargs);
        assertEquals(org.python.types.Int.getInt(1), td.__days__());
        assertEquals(org.python.types.Int.getInt(0), td.__seconds__());
        assertEquals(org.python.types.Int.getInt(999001), td.__microseconds__());
    }

    @Test
    public void test_1_kwargs() {
        org.python.Object[] args = { org.python.types.Int.getInt(1) };
        java.util.Map<java.lang.String, org.python.Object> kwargs = new HashMap();
        kwargs.put("minutes", org.python.types.Int.getInt(1));
        Date td = new Date(args, kwargs);
        assertEquals(org.python.types.Int.getInt(1), td.__days__());
        assertEquals(org.python.types.Int.getInt(60), td.__seconds__());
        assertEquals(org.python.types.Int.getInt(0), td.__microseconds__());
    }

    @Test
    public void test_4_kwargs() {
        org.python.Object[] args = { org.python.types.Int.getInt(1) };
        java.util.Map<java.lang.String, org.python.Object> kwargs = new HashMap();
        kwargs.put("milliseconds", org.python.types.Int.getInt(1));
        kwargs.put("minutes", org.python.types.Int.getInt(1));
        kwargs.put("hours", org.python.types.Int.getInt(1));
        kwargs.put("weeks", org.python.types.Int.getInt(1));
        Date td = new Date(args, kwargs);
        assertEquals(org.python.types.Int.getInt(8), td.__days__());
        assertEquals(org.python.types.Int.getInt(3660), td.__seconds__());
        assertEquals(org.python.types.Int.getInt(1000), td.__microseconds__());
    }

    @Test
    public void test_negative_days() {
        org.python.Object[] args = { org.python.types.Int.getInt(-1) };
        Date td = new Date(args, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Int.getInt(-1), td.__days__());
        assertEquals(org.python.types.Int.getInt(0), td.__seconds__());
        assertEquals(org.python.types.Int.getInt(0), td.__microseconds__());
    }

    @Test
    public void test_seconds() {
        assertEquals(org.python.types.Int.getInt(2), date1.__seconds__());
    }

    @Test
    public void test_microseconds() {
        assertEquals(org.python.types.Int.getInt(3), date1.__microseconds__());
    }

    @Test
    public void test_total_seconds() {
        assertEquals((new org.python.types.Float(86402.000003)), date1.total_seconds());
    }

    @Test
    public void test_add() {
        Date td_added = (Date) date1.__add__(date2);
        assertEquals(org.python.types.Int.getInt(3), td_added.__days__());
        assertEquals(org.python.types.Int.getInt(8), td_added.__seconds__());
        assertEquals(org.python.types.Int.getInt(3), td_added.__microseconds__());
    }

    @Test
    public void test_str() {
        assertEquals(new org.python.types.Str( "days: 1, seconds: 2, microseconds: 3"), date1.__str__());
    }

    @Test
    public void test_equal_true() {
        org.python.Object[] args1 = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(2), org.python.types.Int.getInt(3) };
        Date td1 = new Date(args1, Collections.EMPTY_MAP);
        org.python.Object[] args2 = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(2), org.python.types.Int.getInt(3) };
        Date td2 = new Date(args2, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Bool.TRUE, td1.__eq__(td2));
    }

    @Test
    public void test_equal_false() {
        org.python.Object[] args1 = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(6), org.python.types.Int.getInt(3) };
        Date td1 = new Date(args1, Collections.EMPTY_MAP);
        org.python.Object[] args2 = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(2), org.python.types.Int.getInt(3) };
        Date td2 = new Date(args2, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Bool.FALSE, td1.__eq__(td2));
    }

    @Test
    public void test_equal_int() {
        org.python.Object[] args1 = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(6), org.python.types.Int.getInt(3) };
        Date td1 = new Date(args1, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Bool.FALSE, td1.__eq__(org.python.types.Int.getInt(5)));
    }

    @Test
    public void test_gt_true() {
        org.python.Object[] args1 = { org.python.types.Int.getInt(2), org.python.types.Int.getInt(6), org.python.types.Int.getInt(3) };
        Date td1 = new Date(args1, Collections.EMPTY_MAP);
        org.python.Object[] args2 = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(6), org.python.types.Int.getInt(3) };
        Date td2 = new Date(args2, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Bool.TRUE, td1.__gt__(td2));
    }

    @Test
    public void test_gt_false() {
        org.python.Object[] args1 = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(6), org.python.types.Int.getInt(3) };
        Date td1 = new Date(args1, Collections.EMPTY_MAP);
        org.python.Object[] args2 = { org.python.types.Int.getInt(2), org.python.types.Int.getInt(6), org.python.types.Int.getInt(3) };
        Date td2 = new Date(args2, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Bool.FALSE, td1.__gt__(td2));
    }

    @Test
    public void test_gt_int() {
        assertThrows(org.python.exceptions.TypeError.class, () -> {
            org.python.Object[] args1 = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(6), org.python.types.Int.getInt(3) };
            Date td1 = new Date(args1, Collections.EMPTY_MAP);
            td1.__gt__(org.python.types.Int.getInt(3));
        });
    }

    @Test
    public void test_lt_true() {
        org.python.Object[] args1 = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(6), org.python.types.Int.getInt(3) };
        Date td1 = new Date(args1, Collections.EMPTY_MAP);
        org.python.Object[] args2 = { org.python.types.Int.getInt(2), org.python.types.Int.getInt(6), org.python.types.Int.getInt(3) };
        Date td2 = new Date(args2, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Bool.TRUE, td1.__lt__(td2));
    }

    @Test
    public void test_lt_false() {
        org.python.Object[] args1 = { org.python.types.Int.getInt(2), org.python.types.Int.getInt(6), org.python.types.Int.getInt(3) };
        Date td1 = new Date(args1, Collections.EMPTY_MAP);
        org.python.Object[] args2 = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(6), org.python.types.Int.getInt(3) };
        Date td2 = new Date(args2, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Bool.FALSE, td1.__lt__(td2));
    }

    @Test
    public void test_lt_int() {
        assertThrows(org.python.exceptions.TypeError.class, () -> {
            org.python.Object[] args1 = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(6), org.python.types.Int.getInt(3) };
            Date td1 = new Date(args1, Collections.EMPTY_MAP);
            td1.__lt__(org.python.types.Int.getInt(3));
        });
    }

    @Test
    public void test_ge_true() {
        org.python.Object[] args1 = { org.python.types.Int.getInt(2), org.python.types.Int.getInt(6), org.python.types.Int.getInt(3) };
        Date td1 = new Date(args1, Collections.EMPTY_MAP);
        org.python.Object[] args2 = { org.python.types.Int.getInt(2), org.python.types.Int.getInt(6), org.python.types.Int.getInt(3) };
        Date td2 = new Date(args2, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Bool.TRUE, td1.__ge__(td2));
    }

    @Test
    public void test_ge_false() {
        org.python.Object[] args1 = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(6), org.python.types.Int.getInt(3) };
        Date td1 = new Date(args1, Collections.EMPTY_MAP);
        org.python.Object[] args2 = { org.python.types.Int.getInt(2), org.python.types.Int.getInt(6), org.python.types.Int.getInt(3) };
        Date td2 = new Date(args2, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Bool.FALSE, td1.__ge__(td2));
    }

    @Test
    public void test_ge_int() {
        assertThrows(org.python.exceptions.TypeError.class, () -> {
            org.python.Object[] args1 = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(6), org.python.types.Int.getInt(3) };
            Date td1 = new Date(args1, Collections.EMPTY_MAP);
            td1.__ge__(org.python.types.Int.getInt(3));
        });
    }

    @Test
    public void test_le_true() {
        org.python.Object[] args1 = { org.python.types.Int.getInt(2), org.python.types.Int.getInt(6), org.python.types.Int.getInt(3) };
        Date td1 = new Date(args1, Collections.EMPTY_MAP);
        org.python.Object[] args2 = { org.python.types.Int.getInt(2), org.python.types.Int.getInt(6), org.python.types.Int.getInt(3) };
        Date td2 = new Date(args2, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Bool.TRUE, td1.__le__(td2));
    }

    @Test
    public void test_le_false() {
        org.python.Object[] args1 = { org.python.types.Int.getInt(2), org.python.types.Int.getInt(6), org.python.types.Int.getInt(3) };
        Date td1 = new Date(args1, Collections.EMPTY_MAP);
        org.python.Object[] args2 = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(6), org.python.types.Int.getInt(3) };
        Date td2 = new Date(args2, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Bool.FALSE, td1.__le__(td2));
    }

    @Test
    public void test_le_int() {
        assertThrows(org.python.exceptions.TypeError.class, () -> {
            org.python.Object[] args1 = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(6), org.python.types.Int.getInt(3) };
            Date td1 = new Date(args1, Collections.EMPTY_MAP);
            td1.__le__(org.python.types.Int.getInt(3));
        });
    }

    @Test
    public void test_diff() {
        org.python.Object[] args1 = { org.python.types.Int.getInt(2), org.python.types.Int.getInt(6), org.python.types.Int.getInt(3) };
        Date td1 = new Date(args1, Collections.EMPTY_MAP);
        org.python.Object[] args2 = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(2), org.python.types.Int.getInt(3) };
        Date td2 = new Date(args2, Collections.EMPTY_MAP);

        org.python.Object[] argsExpected = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(4), org.python.types.Int.getInt(0) };
        Date tdExpected = new Date(argsExpected, Collections.EMPTY_MAP);
        assertEquals(tdExpected, td1.__diff__(td2));
    }

    @Test
    public void test_diff_negative() {
        org.python.Object[] args1 = { org.python.types.Int.getInt(2), org.python.types.Int.getInt(2), org.python.types.Int.getInt(3) };
        Date td1 = new Date(args1, Collections.EMPTY_MAP);
        org.python.Object[] args2 = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(6), org.python.types.Int.getInt(4) };
        Date td2 = new Date(args2, Collections.EMPTY_MAP);

        org.python.Object[] argsExpected = { org.python.types.Int.getInt(0), org.python.types.Int.getInt(86395), org.python.types.Int.getInt(999999) };
        Date tdExpected = new Date(argsExpected, Collections.EMPTY_MAP);
        assertEquals(tdExpected, td1.__diff__(td2));
    }

    @Test
    public void test_mult() {
        org.python.Object[] args1 = { org.python.types.Int.getInt(2), org.python.types.Int.getInt(2), org.python.types.Int.getInt(3) };
        Date td1 = new Date(args1, Collections.EMPTY_MAP);
        org.python.Object[] args2 = { org.python.types.Int.getInt(1), org.python.types.Int.getInt(6), org.python.types.Int.getInt(4) };
        Date td2 = new Date(args2, Collections.EMPTY_MAP);

        org.python.Object[] argsExpected = { org.python.types.Int.getInt(2), org.python.types.Int.getInt(12), org.python.types.Int.getInt(12) };
        Date tdExpected = new Date(argsExpected, Collections.EMPTY_MAP);
        assertEquals(tdExpected, td1.__mult__(td2));
    }

    @Test
    public void test_mult_large_values() {
        org.python.Object[] args1 = { org.python.types.Int.getInt(2), org.python.types.Int.getInt(2), org.python.types.Int.getInt(2000000) };
        Date td1 = new Date(args1, Collections.EMPTY_MAP);
        org.python.types.Int i = org.python.types.Int.getInt(2);

        org.python.Object[] argsExpected = { org.python.types.Int.getInt(4), org.python.types.Int.getInt(8), org.python.types.Int.getInt(0) };
        Date tdExpected = new Date(argsExpected, Collections.EMPTY_MAP);
        assertEquals(tdExpected, td1.__mult__(i));
    }

    @Test
    public void test_mult_negative_values() {
        org.python.Object[] args1 = { org.python.types.Int.getInt(-2), org.python.types.Int.getInt(-2), org.python.types.Int.getInt(2000000) };
        Date td1 = new Date(args1, Collections.EMPTY_MAP);
        org.python.types.Int i = org.python.types.Int.getInt(2);

        org.python.Object[] argsExpected = { org.python.types.Int.getInt(-4) };
        Date tdExpected = new Date(argsExpected, Collections.EMPTY_MAP);
        assertEquals(tdExpected, td1.__mult__(i));
    }
}
