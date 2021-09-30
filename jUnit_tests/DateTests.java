import org.junit.jupiter.api.Test;
import org.python.Object;
import org.python.exceptions.BaseException;
import org.python.stdlib.datetime.Date;
import org.python.types.Int;
import org.python.types.Str;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;

import static java.time.LocalDateTime.now;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.python.types.Int.getInt;


public class DateTests {

    private final org.python.Object[] args1 = {getInt(2020), getInt(5), getInt(2)};
    private final Date date1 = new Date(args1, Collections.EMPTY_MAP);

    @Test
    public void test_argument_1() {
        org.python.Object[] args = {getInt(2020), getInt(5), getInt(2)};
        try {
            Date td = new Date(args, Collections.EMPTY_MAP);
            assertEquals("2020", td.__year__().toString());
            assertEquals("5", td.__month__().toString());
            assertEquals("2", td.__day__().toString());
        } catch (BaseException e) {
            assertEquals("Function takes at most 3 arguments", e.getMessage());
        }
    }

    @Test
    public void test_argument_2() {
        org.python.Object[] args = {getInt(2020), getInt(5), getInt(2), getInt(1)};
        try {
            Date td = new Date(args, Collections.EMPTY_MAP);
            assertEquals("2020", td.__year__().toString());
            assertEquals("5", td.__month__().toString());
            assertEquals("2", td.__day__().toString());
        } catch (BaseException e) {
            assertEquals("function takes at most 3 arguments (" + args.length + " given)", e.getMessage());
        }
    }

    @Test
    public void test_argument_3() {
        org.python.Object[] args = {getInt(2020), getInt(5)};
        try {
            Date td = new Date(args, Collections.EMPTY_MAP);
            assertEquals("2020", td.__year__().toString());
            assertEquals("5", td.__month__().toString());
            assertEquals("2", td.__day__().toString());
        } catch (BaseException e) {
            assertEquals("function missing required argument 'day' (pos 3)", e.getMessage());
        }
    }

    @Test
    public void test_constructor_1() {
        java.util.Map<java.lang.String, org.python.Object> kwargs = new HashMap<>();
        org.python.Object[] args = {getInt(5), getInt(2)};
        kwargs.put("year", getInt(2020));
        try {
            Date date = new Date(args, kwargs);
            assertEquals("2020", date.__year__().toString());
            assertEquals("5", date.__month__().toString());
            assertEquals("2", date.__day__().toString());
        } catch (BaseException e) {
            assertEquals("positional argument follows keyword argument", e.getMessage());
        }
    }

    @Test
    public void test_constructor_2() {
        java.util.Map<java.lang.String, org.python.Object> kwargs = new HashMap<>();
        org.python.Object[] args = {getInt(5), getInt(2)};
        kwargs.put("year", getInt(2020));
        try {
            Date date = new Date(args, kwargs);
            assertEquals("2020", date.__year__().toString());
            assertEquals("5", date.__month__().toString());
            assertEquals("2", date.__day__().toString());
        } catch (BaseException e) {
            assertEquals("positional argument follows keyword argument", e.getMessage());
        }
    }

    @Test
    public void test_constructor_3() {
        java.util.Map<java.lang.String, org.python.Object> kwargs = new HashMap<>();
        org.python.Object[] args = new Object[0];
        kwargs.put("year", getInt(2020));
        kwargs.put("month", getInt(5));
        try {
            Date date = new Date(args, kwargs);
        } catch (BaseException e) {
            assertEquals("function missing required argument 'day' (pos 3)", e.getMessage());
        }
    }

    @Test
    public void test_constructor_4() {
        java.util.Map<java.lang.String, org.python.Object> kwargs = new HashMap<>();
        org.python.Object[] args = new Object[0];
        kwargs.put("year", getInt(2020));
        kwargs.put("day", getInt(5));
        try {
            Date date = new Date(args, kwargs);
        } catch (BaseException e) {
            assertEquals("function missing required argument 'month' (pos 2)", e.getMessage());
        }
    }

    @Test
    public void test_constructor_5() {
        java.util.Map<java.lang.String, org.python.Object> kwargs = new HashMap<>();
        org.python.Object[] args = new Object[0];
        kwargs.put("day", getInt(2));
        kwargs.put("month", getInt(5));
        try {
            Date date = new Date(args, kwargs);
        } catch (BaseException e) {
            assertEquals("function missing required argument 'year' (pos 1)", e.getMessage());
        }
    }

    @Test
    public void test_wrong_type_arg() {
        assertThrows(org.python.exceptions.TypeError.class, () -> {
            org.python.Object[] args1 = {new org.python.types.Str("test")};
            Date date = new Date(args1, Collections.EMPTY_MAP);
        });
    }

    @Test
    public void test_wrong_type_kwarg() {
        assertThrows(org.python.exceptions.TypeError.class, () -> {
            org.python.Object[] args1 = {getInt(1)};
            java.util.Map<java.lang.String, org.python.Object> kwargs = new HashMap();
            kwargs.put("year", new org.python.types.Str("test"));
            Date date = new Date(args1, kwargs);
        });
    }

    @Test
    public void test_negative_year() {
        org.python.Object[] args = {getInt(-1999), getInt(2), getInt(5)};
        try {
            Date date = new Date(args, Collections.EMPTY_MAP);
        } catch (BaseException e) {
            assertEquals("year " + args[0] + " is out of range", e.getMessage());
        }
    }

    @Test
    public void test_float_year() {
        org.python.Object[] args = {new org.python.types.Float(2020.2), getInt(2), getInt(5)};
        try {
            Date date = new Date(args, Collections.EMPTY_MAP);
        } catch (BaseException e) {
            assertEquals("integer argument expected, got float", e.getMessage());
        }
    }

    @Test
    public void test_str_year() {
        org.python.Object[] args = {new org.python.types.Str("2020"), getInt(2), getInt(5)};
        try {
            Date date = new Date(args, Collections.EMPTY_MAP);
        } catch (BaseException e) {
            assertEquals("integer argument expected, got str", e.getMessage());
        }
    }

    @Test
    public void test_range_month() {
        org.python.Object[] args = {getInt(2020), getInt(13), getInt(2)};
        try {
            Date date = new Date(args, Collections.EMPTY_MAP);
        } catch (BaseException e) {
            assertEquals("month must be in 1..12", e.getMessage());
        }
    }

    @Test
    public void test_range_day() {
        org.python.Object[] args = {getInt(2020), getInt(5), getInt(200)};
        try {
            Date date = new Date(args, Collections.EMPTY_MAP);
        } catch (BaseException e) {
            assertEquals("day is out of range for month", e.getMessage());
        }
    }


    @Test
    public void test_month() {
        assertEquals("5", date1.__month__().toString());
    }

    @Test
    public void test_days() {
        assertEquals("2", date1.__day__().toString());
    }

    @Test
    public void test_str() {
        assertEquals(new org.python.types.Str("2020-05-02"), date1.__str__());
    }

    @Test
    public void test_ctime() {
        Object[] args = {getInt(2020), getInt(5), getInt(2)};
        Date date = new Date(args, Collections.EMPTY_MAP);
        Str ctime = (org.python.types.Str) date.ctime();
        assertEquals(ctime.value, "Sat May  2 00:00:00 2020");
    }

    @Test
    public void test_constant_4() {
        Int date = (Int) Date.constant_4();
        assertEquals(date.value, 4);
    }

    @Test
    public void test_repr_() {
        Object[] args = {Int.getInt(2020), Int.getInt(5), Int.getInt(2)};
        Date date = new Date(args, Collections.EMPTY_MAP);
        Str str = (Str) date.__repr__();
        assertEquals(str.value, "2020-05-02");
    }


    @Test
    public void testToday() {
        LocalDateTime currentTime = now();
        int year = currentTime.getYear();
        int month = currentTime.getMonthValue();
        int day = currentTime.getDayOfMonth();
        Date today = (Date) Date.today();
        assertEquals(((Int) today.year).value, year);
        assertEquals(((Int) today.month).value, month);
        assertEquals(((Int) today.day).value, day);
    }

    @Test
    public void test_weekday() {
        Object[] args = {getInt(2020), getInt(5), getInt(2)};
        Date date = new Date(args, Collections.EMPTY_MAP);
        Int i = (Int) date.weekday();
        assertEquals(i.value, 5);
    }

    @Test
    public void test_equal_true() {
        org.python.Object[] args1 = {getInt(2020), getInt(2), getInt(3)};
        Date td1 = new Date(args1, Collections.EMPTY_MAP);
        org.python.Object[] args2 = {getInt(2020), getInt(2), getInt(3)};
        Date td2 = new Date(args2, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Bool.TRUE, td1.__eq__(td2));
    }

    @Test
    public void test_equal_false() {
        org.python.Object[] args1 = {getInt(2020), getInt(6), getInt(3)};
        Date td1 = new Date(args1, Collections.EMPTY_MAP);
        org.python.Object[] args2 = {getInt(2020), getInt(2), getInt(3)};
        Date td2 = new Date(args2, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Bool.FALSE, td1.__eq__(td2));
    }

    @Test
    public void test_equal_int() {
        org.python.Object[] args1 = {getInt(2020), getInt(6), getInt(3)};
        Date td1 = new Date(args1, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Bool.FALSE, td1.__eq__(getInt(5)));
    }

    @Test
    public void test_gt_true() {
        org.python.Object[] args1 = {getInt(2020), getInt(6), getInt(3)};
        Date td1 = new Date(args1, Collections.EMPTY_MAP);
        org.python.Object[] args2 = {getInt(2019), getInt(6), getInt(3)};
        Date td2 = new Date(args2, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Bool.TRUE, td1.__gt__(td2));
    }

    @Test
    public void test_gt_false() {
        org.python.Object[] args1 = {getInt(2020), getInt(6), getInt(3)};
        Date td1 = new Date(args1, Collections.EMPTY_MAP);
        org.python.Object[] args2 = {getInt(2020), getInt(6), getInt(3)};
        Date td2 = new Date(args2, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Bool.FALSE, td1.__gt__(td2));
    }

    @Test
    public void test_gt_int() {
        assertThrows(org.python.exceptions.TypeError.class, () -> {
            org.python.Object[] args1 = {getInt(2020), getInt(6), getInt(3)};
            Date td1 = new Date(args1, Collections.EMPTY_MAP);
            td1.__gt__(getInt(3));
        });
    }

    @Test
    public void test_lt_true() {
        org.python.Object[] args1 = {getInt(2019), getInt(6), getInt(3)};
        Date td1 = new Date(args1, Collections.EMPTY_MAP);
        org.python.Object[] args2 = {getInt(2020), getInt(6), getInt(3)};
        Date td2 = new Date(args2, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Bool.TRUE, td1.__lt__(td2));
    }

    @Test
    public void test_lt_false() {
        org.python.Object[] args1 = {getInt(2020), getInt(6), getInt(3)};
        Date td1 = new Date(args1, Collections.EMPTY_MAP);
        org.python.Object[] args2 = {getInt(2019), getInt(6), getInt(3)};
        Date td2 = new Date(args2, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Bool.FALSE, td1.__lt__(td2));
    }

    @Test
    public void test_lt_int() {
        assertThrows(org.python.exceptions.TypeError.class, () -> {
            org.python.Object[] args1 = {getInt(2020), getInt(6), getInt(3)};
            Date td1 = new Date(args1, Collections.EMPTY_MAP);
            td1.__lt__(getInt(3));
        });
    }

    @Test
    public void test_ge() {
        org.python.Object[] args1 = {getInt(2020), getInt(6), getInt(3)};
        Date td1 = new Date(args1, Collections.EMPTY_MAP);
        org.python.Object[] args2 = {getInt(2020), getInt(6), getInt(3)};
        Date td2 = new Date(args2, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Bool.TRUE, td1.__ge__(td2));
    }

    @Test
    public void test_ge_int() {
        assertThrows(org.python.exceptions.TypeError.class, () -> {
            org.python.Object[] args1 = {getInt(2020), getInt(6), getInt(3)};
            Date td1 = new Date(args1, Collections.EMPTY_MAP);
            td1.__ge__(getInt(3));
        });
    }

    @Test
    public void test_le() {
        org.python.Object[] args1 = {getInt(2020), getInt(6), getInt(3)};
        Date td1 = new Date(args1, Collections.EMPTY_MAP);
        org.python.Object[] args2 = {getInt(2020), getInt(6), getInt(3)};
        Date td2 = new Date(args2, Collections.EMPTY_MAP);
        assertEquals(org.python.types.Bool.TRUE, td1.__le__(td2));
    }


}
