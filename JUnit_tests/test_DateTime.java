import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.python.Object;
import org.python.exceptions.*;
import org.python.stdlib.datetime.DateTime;
import org.python.types.Bool;
import org.python.types.Int;

import java.time.LocalTime;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/* Changes made so far on dateTime.java file:
- change MAXYEAR 999 -> 9999 (did the same in Date.java)
- change condition microseconds 100000 -> 1000000
- possible change in week day because of tyoes cast
- add __int__ to objects in weekday()

Possible implementations/functions:
- operations <,>,= to compare dates (check lt,le,eq,... in Int.java)
- now(), utcnow(), fromtimestamp(timestamp)
- time()
 */


public class test_DateTime {


    public Int[] dateTimeArgs (int year, int month, int day, int hour, int minute, int second, int microsecond) {
        org.python.types.Int[] args = new org.python.types.Int[]{Int.getInt(year), Int.getInt(month), Int.getInt(day), Int.getInt(hour), Int.getInt(minute), Int.getInt(second), Int.getInt(microsecond)};
        return args;
    }

    public Map<String,Object> dateTimeKwargs (int year, int month, int day, int hour, int minute, int second, int microsecond) {
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        kwargs.put("year",Int.getInt(year));
        kwargs.put("month",Int.getInt(month));
        kwargs.put("day",Int.getInt(day));
        kwargs.put("hour",Int.getInt(hour));
        kwargs.put("minute",Int.getInt(minute));
        kwargs.put("second",Int.getInt(second));
        kwargs.put("microsecond",Int.getInt(microsecond));
        return kwargs;
    }

    @Test
    public void testYearError () {
        Assertions.assertThrows(ValueError.class, () -> {
            org.python.types.Int[] args = dateTimeArgs(-2021,9,15,10,00,00,00);
            java.util.Map<java.lang.String, org.python.Object> kwargs;
            kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
            DateTime test = new DateTime(args, kwargs);
        });
    }

    @Test
    public void testMonthError () {
        Assertions.assertThrows(ValueError.class, () -> {
            org.python.types.Int[] args = new org.python.types.Int[]{};
            java.util.Map<java.lang.String, org.python.Object> kwargs = dateTimeKwargs(2021,20,15,0,0,0,0);
            DateTime test = new DateTime(args, kwargs);
        });
    }

    @Test
    public void testDayError () {
        Assertions.assertThrows(ValueError.class, () -> {
            org.python.types.Int[] args = dateTimeArgs(2021,9,0,10,00,00,00);
            java.util.Map<java.lang.String, org.python.Object> kwargs;
            kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
            DateTime test = new DateTime(args, kwargs);
        });
    }

    @Test
    public void testMicrosecondsError () {
        Assertions.assertThrows(ValueError.class, () -> {
            org.python.types.Int[] args = dateTimeArgs(2021,9,15,10,00,00,10000000);
            java.util.Map<java.lang.String, org.python.Object> kwargs;
            kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
            DateTime test = new DateTime(args, kwargs);
        });
    }

    @Test
    public void testInstanceSuccess1 () {
        org.python.types.Int[] args = dateTimeArgs(2021,9,15,10,00,01,2759);
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args, kwargs);
        assertEquals("2021-09-15 10:00:01.002759",test.__str__().toString());
    }

    @Test
    public void testInstanceSuccess2 () {
        org.python.types.Int[] args = new org.python.types.Int[]{};
        java.util.Map<java.lang.String, org.python.Object> kwargs = dateTimeKwargs(2021,9,15,10,0,01,2759);
        DateTime test = new DateTime(args, kwargs);
        assertEquals("2021-09-15 10:00:01.002759",test.__str__().toString());
    }

    @Test
    public void testInstanceError1 () {
        Assertions.assertThrows(SyntaxError.class, () -> {
            org.python.types.Int[] args = dateTimeArgs(2021,9,15,10,00,01,2759);
            //java.util.Map<java.lang.String, org.python.Object> kwargs = dateTimeKwargs(2021,9,16,10,00,01,2759);
            java.util.Map<java.lang.String, org.python.Object> kwargs;
            kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
            kwargs.put("year", Int.getInt(2021));
            kwargs.put("month", Int.getInt(9));
            kwargs.put("day", Int.getInt(16));
            kwargs.put("hour", Int.getInt(10));
            kwargs.put("minute", Int.getInt(00));
            kwargs.put("seconds", Int.getInt(01));
            kwargs.put("microseconds", Int.getInt(2759));
            DateTime test = new DateTime(args, kwargs);
        });
    }

    @Test
    public void testInstanceError2 () {
        Assertions.assertThrows(TypeError.class, () -> {
            org.python.types.Int[] args = new org.python.types.Int[]{Int.getInt(2021), Int.getInt(9)};
            java.util.Map<java.lang.String, org.python.Object> kwargs;
            kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
            DateTime test = new DateTime(args, kwargs);
        });
    }


    @Test
    public void testGetSuccess () {
        org.python.types.Int[] args = dateTimeArgs(2021,9,15,10,0,01,2759);
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args,kwargs);
        assertEquals("2021",test.__year__().toString());
        assertEquals("9",test.__month__().toString());
        assertEquals("15",test.__day__().toString());
        assertEquals("10",test.__hour__().toString());
        assertEquals("0",test.__minute__().toString());
        assertEquals("1",test.__second__().toString());
        assertEquals("2759",test.__microsecond__().toString());
    }

    @Test
    public void testDateSuccess () {
        org.python.types.Int[] args = dateTimeArgs(2021,9,15,0,0,0,0);
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args,kwargs);
        assertEquals("2021-09-15",test.date().__str__().toString());
    }

    @Test
    public void testTodayFail () {
        Object test = (DateTime) DateTime.today();
        assertEquals("2021-09-15 " + LocalTime.now().toString(),test.__str__().toString());
    }

    @Test
    public void testWeekdaySuccess () {
        org.python.types.Int[] args = dateTimeArgs(2021,9,15,0,0,0,0);
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args,kwargs);
        assertEquals("2",test.weekday().toString());
    }

    @Test
    public void testLt () {
        org.python.types.Int[] args = dateTimeArgs(2021,9,15,0,0,0,0);
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args,kwargs);
        assertEquals(Bool.FALSE,DateTime.__lt__((DateTime) DateTime.today(),test));
    }

    @Test
    public void testGt () {
        org.python.types.Int[] args = dateTimeArgs(2021,9,15,0,0,01,0);
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args,kwargs);
        org.python.types.Int[] args2 = new org.python.types.Int[]{};
        java.util.Map<java.lang.String, org.python.Object> kwargs2 = dateTimeKwargs(2021,9,15,10,0,0,0);
        DateTime test2 = new DateTime(args2,kwargs2);
        assertEquals(Bool.TRUE,DateTime.__gt__(test,test2));
    }

    @Test
    public void testEq () {
        org.python.types.Int[] args = dateTimeArgs(2021,9,15,10,0,01,2759);
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args,kwargs);
        org.python.types.Int[] args2 = new org.python.types.Int[]{};
        java.util.Map<java.lang.String, org.python.Object> kwargs2 = dateTimeKwargs(2021,9,15,10,0,01,2759);
        DateTime test2 = new DateTime(args2,kwargs2);
        assertEquals(Bool.TRUE,DateTime.__eq__(test,test2));
    }

    @Test
    public void testFromOrdinal () {
        DateTime test = (DateTime) DateTime.today();
        long ordinal = 738052;
//        Equivalent to 2021-09-19 -> 738052
        assertEquals("2021-09-19", test.fromOrdinal(ordinal));
    }

    @Test
    public void testToOrdinal () {
        DateTime test = (DateTime) DateTime.today();
        assertEquals("738053",test.toOrdinal(test));
    }






}
