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


    @Test
    public void testYearFail () {
        Assertions.assertThrows(ValueError.class, () -> {
            org.python.types.Int[] args = new org.python.types.Int[]{Int.getInt(-2021), Int.getInt(9), Int.getInt(15), Int.getInt(10), Int.getInt(00), Int.getInt(01)};
            java.util.Map<java.lang.String, org.python.Object> kwargs;
            kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
            DateTime test = new DateTime(args, kwargs);
        });
    }

    @Test
    public void testMonthFail () {
        Assertions.assertThrows(ValueError.class, () -> {
            org.python.types.Int[] args = new org.python.types.Int[]{};
            java.util.Map<java.lang.String, org.python.Object> kwargs;
            kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
            kwargs.put("year", Int.getInt(2021));
            kwargs.put("month", Int.getInt(20));
            kwargs.put("day", Int.getInt(15));
            DateTime test = new DateTime(args, kwargs);
        });
    }

    @Test
    public void testDayFail () {
        Assertions.assertThrows(ValueError.class, () -> {
            org.python.types.Int[] args = new org.python.types.Int[]{Int.getInt(2021), Int.getInt(9), Int.getInt(0), Int.getInt(10), Int.getInt(00), Int.getInt(01)};
            java.util.Map<java.lang.String, org.python.Object> kwargs;
            kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
            DateTime test = new DateTime(args, kwargs);
        });
    }

    @Test
    public void testMicrosecondsFail () {
        Assertions.assertThrows(ValueError.class, () -> {
            org.python.types.Int[] args = new org.python.types.Int[]{Int.getInt(2021), Int.getInt(9), Int.getInt(15), Int.getInt(10), Int.getInt(00), Int.getInt(01), Int.getInt(10000000)};
            java.util.Map<java.lang.String, org.python.Object> kwargs;
            kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
            DateTime test = new DateTime(args, kwargs);
        });
    }

    @Test
    public void testInstanceSuccess1 () {
        org.python.types.Int[] args = new org.python.types.Int[]{Int.getInt(2021), Int.getInt(9), Int.getInt(15), Int.getInt(10), Int.getInt(00), Int.getInt(01), Int.getInt(2759)};
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args, kwargs);
        assertEquals("2021-09-15 10:00:01.002759",test.__str__().toString());
    }

    @Test
    public void testInstanceSuccess2 () {
        org.python.types.Int[] args = new org.python.types.Int[]{};
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        kwargs.put("year",Int.getInt(2021));
        kwargs.put("month",Int.getInt(9));
        kwargs.put("day",Int.getInt(15));
        kwargs.put("hour",Int.getInt(10));
        kwargs.put("minute",Int.getInt(00));
        kwargs.put("second",Int.getInt(01));
        kwargs.put("microsecond",Int.getInt(2759));
        DateTime test = new DateTime(args, kwargs);
        assertEquals("2021-09-15 10:00:01.002759",test.__str__().toString());
    }

    @Test
    public void testInstanceFail1 () {
        Assertions.assertThrows(SyntaxError.class, () -> {
            org.python.types.Int[] args = new org.python.types.Int[]{Int.getInt(2021), Int.getInt(9), Int.getInt(15), Int.getInt(10), Int.getInt(00), Int.getInt(01), Int.getInt(2759)};
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
    public void testInstanceFail2 () {
        Assertions.assertThrows(TypeError.class, () -> {
            org.python.types.Int[] args = new org.python.types.Int[]{Int.getInt(2021), Int.getInt(9)};
            java.util.Map<java.lang.String, org.python.Object> kwargs;
            kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
            DateTime test = new DateTime(args, kwargs);
        });
    }


    @Test
    public void testGetSuccess () {
        org.python.types.Int[] args = new org.python.types.Int[]{Int.getInt(2021), Int.getInt(9), Int.getInt(15), Int.getInt(10), Int.getInt(00), Int.getInt(01), Int.getInt(2759)};
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
        org.python.types.Int[] args = new org.python.types.Int[]{Int.getInt(2021), Int.getInt(9), Int.getInt(15)};
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
        org.python.types.Int[] args = new org.python.types.Int[]{Int.getInt(2021), Int.getInt(9), Int.getInt(15)};
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args,kwargs);
        assertEquals("2",test.weekday().toString());
    }

    @Test
    public void testLt () {
        org.python.types.Int[] args = new org.python.types.Int[]{Int.getInt(2021), Int.getInt(9), Int.getInt(15)};
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args,kwargs);
        assertEquals(Bool.FALSE,DateTime.__lt__((DateTime) DateTime.today(),test));
    }

    @Test
    public void testGt () {
        org.python.types.Int[] args = new org.python.types.Int[]{Int.getInt(2021), Int.getInt(9), Int.getInt(15), Int.getInt(10), Int.getInt(00), Int.getInt(01)};
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args,kwargs);
        org.python.types.Int[] args2 = new org.python.types.Int[]{};
        java.util.Map<java.lang.String, org.python.Object> kwargs2;
        kwargs2 = new java.util.HashMap<java.lang.String, org.python.Object>();
        kwargs2.put("year", Int.getInt(2021));
        kwargs2.put("month", Int.getInt(9));
        kwargs2.put("day", Int.getInt(15));
        kwargs2.put("hour", Int.getInt(10));
        kwargs2.put("minute", Int.getInt(00));
        DateTime test2 = new DateTime(args2,kwargs2);
        assertEquals(Bool.TRUE,DateTime.__gt__(test,test2));
    }

    @Test
    public void testEq () {
        org.python.types.Int[] args = new org.python.types.Int[]{Int.getInt(2021), Int.getInt(9), Int.getInt(15), Int.getInt(10), Int.getInt(00), Int.getInt(01), Int.getInt(2759)};
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args,kwargs);
        org.python.types.Int[] args2 = new org.python.types.Int[]{};
        java.util.Map<java.lang.String, org.python.Object> kwargs2;
        kwargs2 = new java.util.HashMap<java.lang.String, org.python.Object>();
        kwargs2.put("year", Int.getInt(2021));
        kwargs2.put("month", Int.getInt(9));
        kwargs2.put("day", Int.getInt(15));
        kwargs2.put("hour", Int.getInt(10));
        kwargs2.put("minute", Int.getInt(00));
        kwargs2.put("second", Int.getInt(01));
        kwargs2.put("microsecond", Int.getInt(2759));
        DateTime test2 = new DateTime(args2,kwargs2);
        assertEquals(Bool.TRUE,DateTime.__eq__(test,test2));
    }

    @Test
    public void testFromOrdinal () {
        //assertEquals(Bool.FALSE,DateTime.__lt__((DateTime) DateTime.today(),test));
    }

    @Test
    public void testToOrdinal () {
        //assertEquals(Bool.FALSE,DateTime.__lt__((DateTime) DateTime.today(),test));
    }






}
