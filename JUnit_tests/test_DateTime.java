import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.python.Object;
import org.python.exceptions.ValueError;
import org.python.stdlib.datetime.DateTime;
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
        org.python.types.Int[] args = new org.python.types.Int[]{Int.getInt(2021), Int.getInt(20), Int.getInt(15), Int.getInt(10), Int.getInt(00), Int.getInt(01)};
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args,kwargs);
        assertEquals("2021-09-15 10:00:01",test.__str__().toString());
    }

    @Test
    public void testDayFail () {
        org.python.types.Int[] args = new org.python.types.Int[]{Int.getInt(2021), Int.getInt(9), Int.getInt(0), Int.getInt(10), Int.getInt(00), Int.getInt(01)};
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args,kwargs);
        assertEquals("2021-09-15 10:00:01",test.__str__().toString());
    }

    @Test
    public void testMicrosecondsFail () {
        org.python.types.Int[] args = new org.python.types.Int[]{Int.getInt(2021), Int.getInt(9), Int.getInt(15), Int.getInt(10), Int.getInt(00), Int.getInt(01), Int.getInt(10000000)};
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args,kwargs);
        assertEquals("2021-09-15 30:00:01 10000000",test.__str__().toString());
    }

    @Test
    public void testInstanceSuccess () {
        org.python.types.Int[] args = new org.python.types.Int[]{Int.getInt(2021), Int.getInt(9), Int.getInt(15), Int.getInt(10), Int.getInt(00), Int.getInt(01), Int.getInt(2759)};
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args, kwargs);
        assertEquals("2021-09-15 10:00:01.002759",test.__str__().toString());
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
    public void testWeekdayFail () {
        org.python.types.Int[] args = new org.python.types.Int[]{Int.getInt(2021), Int.getInt(9), Int.getInt(15)};
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args,kwargs);
        assertEquals(1,test.weekday());
    }





}
