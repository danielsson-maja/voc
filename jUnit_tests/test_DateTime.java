package voc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.python.Object;
import org.python.exceptions.*;
import org.python.stdlib.datetime.*;
import org.python.types.*;

import java.time.LocalDate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class test_DateTime {


    public org.python.types.Int[] date_time_args (int year, int month, int day, int hour, int minute, int second, int microsecond) {
        org.python.types.Int[] args = new org.python.types.Int[]{Int.getInt(year), Int.getInt(month), Int.getInt(day), Int.getInt(hour), Int.getInt(minute), Int.getInt(second), Int.getInt(microsecond)};
        return args;
    }


    public Map<String,Object> date_time_kwargs (int year, int month, int day, int hour, int minute, int second, int microsecond) {
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
    public void test_year_error () {
        Assertions.assertThrows(ValueError.class, () -> {
            org.python.types.Int[] args = date_time_args(-2021,9,15,10,00,00,00);
            java.util.Map<java.lang.String, org.python.Object> kwargs;
            kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
            DateTime test = new DateTime(args, kwargs);
        });
    }

    @Test
    public void test_month_error () {
        Assertions.assertThrows(ValueError.class, () -> {
            org.python.types.Int[] args = new org.python.types.Int[]{};
            java.util.Map<java.lang.String, org.python.Object> kwargs = date_time_kwargs(2021,20,15,0,0,0,0);
            DateTime test = new DateTime(args, kwargs);
        });
    }

    @Test
    public void test_day_error () {
        Assertions.assertThrows(ValueError.class, () -> {
            org.python.types.Int[] args = date_time_args(2021,9,0,10,00,00,00);
            java.util.Map<java.lang.String, org.python.Object> kwargs;
            kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
            DateTime test = new DateTime(args, kwargs);
        });
    }

    @Test
    public void test_microseconds_error () {
        Assertions.assertThrows(ValueError.class, () -> {
            org.python.types.Int[] args = date_time_args(2021,9,15,10,00,00,10000000);
            java.util.Map<java.lang.String, org.python.Object> kwargs;
            kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
            DateTime test = new DateTime(args, kwargs);
        });
    }

    @Test
    public void test_args_success () {
        org.python.types.Int[] args = date_time_args(2021,9,15,10,00,01,2759);
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args, kwargs);
        assertEquals("2021-09-15 10:00:01.002759",test.__str__().toString());
    }

    @Test
    public void test_kwargs_success () {
        org.python.types.Int[] args = new org.python.types.Int[]{};
        java.util.Map<java.lang.String, org.python.Object> kwargs = date_time_kwargs(2021,9,15,10,0,01,2759);
        DateTime test = new DateTime(args, kwargs);
        assertEquals("2021-09-15 10:00:01.002759",test.__str__().toString());
    }


    @Test
    public void test_conflict_error () {
        Assertions.assertThrows(SyntaxError.class, () -> {
            org.python.types.Int[] args = date_time_args(2021,9,15,10,00,01,2759);
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
    public void test_few_args () {
        Assertions.assertThrows(TypeError.class, () -> {
            org.python.types.Int[] args = new org.python.types.Int[]{Int.getInt(2021), Int.getInt(9)};
            java.util.Map<java.lang.String, org.python.Object> kwargs;
            kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
            DateTime test = new DateTime(args, kwargs);
        });
    }

    @Test
    public void test_few_kwargs () {
        Assertions.assertThrows(TypeError.class, () -> {
            org.python.types.Int[] args = new org.python.types.Int[]{};
            java.util.Map<java.lang.String, org.python.Object> kwargs;
            kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
            kwargs.put("year", Int.getInt(2021));
            kwargs.put("month", Int.getInt(9));
            DateTime test = new DateTime(args, kwargs);
        });
    }

    @Test
    public void test_empty () {
        Assertions.assertThrows(TypeError.class, () -> {
            org.python.types.Int[] args = new org.python.types.Int[]{};
            java.util.Map<java.lang.String, org.python.Object> kwargs;
            kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
            DateTime test = new DateTime(args, kwargs);
        });
    }

    @Test
    public void test_get_args () {
        org.python.types.Int[] args = date_time_args(2021,9,15,10,0,01,2759);
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
    public void test_date () {
        org.python.types.Int[] args = date_time_args(2021,9,15,0,0,0,0);
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args,kwargs);
        assertEquals("2021-09-15",test.date().__str__().toString());
    }

    @Test
    public void test_today () {
        Object test = (DateTime) DateTime.today();
        Date today = (Date) ((DateTime) test).date();
        assertEquals(LocalDate.now().toString(),today.__str__().toString());
    }

    @Test
    public void test_weekday () {
        org.python.types.Int[] args = date_time_args(2021,9,15,0,0,0,0);
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args,kwargs);
        assertEquals("2",test.weekday().toString());
    }

    @Test
    public void test_lt_false () {
        org.python.types.Int[] args = date_time_args(2021,9,15,0,0,0,0);
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args,kwargs);
        assertEquals(Bool.FALSE,DateTime.__lt__((DateTime) DateTime.today(),test));
    }

    @Test
    public void test_lt_true () {
        org.python.types.Int[] args = date_time_args(2021,9,15,0,0,0,0);
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args,kwargs);
        assertEquals(Bool.TRUE,DateTime.__lt__(test,(DateTime) DateTime.today()));
    }

    @Test
    public void test_gt_false () {
        org.python.types.Int[] args = date_time_args(2021,9,15,0,0,01,0);
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args,kwargs);
        assertEquals(Bool.FALSE,DateTime.__gt__(test,(DateTime) DateTime.today()));
    }

    @Test
    public void test_gt_true () {
        org.python.types.Int[] args = date_time_args(2021,9,15,0,0,01,0);
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args,kwargs);
        assertEquals(Bool.TRUE,DateTime.__gt__((DateTime) DateTime.today(),test));
    }

    @Test
    public void test_eq_false () {
        org.python.types.Int[] args = date_time_args(2021,9,15,10,0,01,2759);
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args,kwargs);
        org.python.types.Int[] args2 = new org.python.types.Int[]{};
        java.util.Map<java.lang.String, org.python.Object> kwargs2 = date_time_kwargs(2021,9,15,10,0,01,2758);
        DateTime test2 = new DateTime(args2,kwargs2);
        assertEquals(Bool.FALSE,DateTime.__eq__(test,test2));
    }

    @Test
    public void test_eq_true () {
        org.python.types.Int[] args = date_time_args(2021,9,15,10,0,01,2759);
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args,kwargs);
        org.python.types.Int[] args2 = new org.python.types.Int[]{};
        java.util.Map<java.lang.String, org.python.Object> kwargs2 = date_time_kwargs(2021,9,15,10,0,01,2759);
        DateTime test2 = new DateTime(args2,kwargs2);
        assertEquals(Bool.TRUE,DateTime.__eq__(test,test2));
    }

    @Test
    public void test_from_ordinal () {
        org.python.types.Int[] args = new org.python.types.Int[]{Int.getInt(2021), Int.getInt(9), Int.getInt(19)};
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args,kwargs);
        long ordinal = 738052;
        assertEquals("2021-09-19", test.fromordinal(ordinal));
    }

    @Test
    public void test_from_ordinal_leap () {
        org.python.types.Int[] args = new org.python.types.Int[]{Int.getInt(2020), Int.getInt(9), Int.getInt(19)};
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args,kwargs);
        long ordinal = 737687;
        assertEquals("2020-09-19", test.fromordinal(ordinal));
    }

    @Test
    public void test_to_ordinal () {
        org.python.types.Int[] args = new org.python.types.Int[]{Int.getInt(2021), Int.getInt(9), Int.getInt(19)};
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args,kwargs);
        assertEquals("738052",test.toordinal(test));
    }

    @Test
    public void test_to_ordinal_leap () {
        org.python.types.Int[] args = new org.python.types.Int[]{Int.getInt(2020), Int.getInt(9), Int.getInt(19)};
        java.util.Map<java.lang.String, org.python.Object> kwargs;
        kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        DateTime test = new DateTime(args,kwargs);
        assertEquals("737687",test.toordinal(test));
    }






}
