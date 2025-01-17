package org.python.stdlib.datetime;

import org.python.types.Bool;

import java.util.Collections;

public class DateTime extends org.python.types.Object {
    private final int YEAR_INDEX = 0;
    private final int MONTH_INDEX = 1;
    private final int DAY_INDEX = 2;
    private final int HOUR_INDEX = 3;
    private final int MINUTE_INDEX = 4;
    private final int SECOND_INDEX = 5;
    private final int MICROSECOND_INDEX = 6;

    private final int MIN_YEAR = 1;
    private final int MAX_YEAR = 9999;

    private Long[] timeUnits = { 0l, 0l, 0l, 0l, 0l, 0l, 0l };

    @org.python.Attribute
    public final org.python.Object year;

    @org.python.Attribute
    public final org.python.Object month;

    @org.python.Attribute
    public final org.python.Object day;

    @org.python.Attribute
    public final org.python.Object hour;

    @org.python.Attribute
    public final org.python.Object minute;

    @org.python.Attribute
    public final org.python.Object second;

    @org.python.Attribute
    public final org.python.Object microsecond;

    @org.python.Attribute
    public static final org.python.Object min = __min__();

    @org.python.Attribute
    public static final org.python.Object max = __max__();

    public DateTime(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs) {
        super();
        String[] keys = { "year", "month", "day", "hour", "minute", "second", "microsecond" };
        boolean kwargsIsUsed = false;
        int keyIndex = 0;
        int argIndex = 0;

        for (String key : keys) {
            if (kwargs.get(key) != null) {
            this.timeUnits[keyIndex] = ((org.python.types.Int) kwargs.get(key)).value;
            kwargsIsUsed = true;
            } else if (args.length > argIndex) {
            if (kwargsIsUsed)
                throw new org.python.exceptions.SyntaxError("positional argument follows keyword argument");
            this.timeUnits[keyIndex] = ((org.python.types.Int) args[argIndex]).value;
            argIndex++;
            } else if (keyIndex < 3) {
            throw new org.python.exceptions.TypeError("Required argument '" + keys[keyIndex] + "' (pos " + (keyIndex + 1) + ") not found");
            }
            keyIndex++;
        }

        if (this.timeUnits[YEAR_INDEX] < MIN_YEAR || this.timeUnits[YEAR_INDEX] > MAX_YEAR) {
            throw new org.python.exceptions.ValueError("year " + this.timeUnits[YEAR_INDEX] + "is out of range");
        }

        if (this.timeUnits[MONTH_INDEX] < 1 || this.timeUnits[MONTH_INDEX] > 12) {
            throw new org.python.exceptions.ValueError("month " + this.timeUnits[MONTH_INDEX] + "is out of range");
        }
        if (this.timeUnits[DAY_INDEX] < 1 || this.timeUnits[DAY_INDEX] > 31) {
            throw new org.python.exceptions.ValueError("day " + this.timeUnits[DAY_INDEX] + "is out of range");
        }

        if (this.timeUnits[HOUR_INDEX] < 0 || this.timeUnits[HOUR_INDEX] > 24) {
            throw new org.python.exceptions.ValueError("hour " + this.timeUnits[HOUR_INDEX] + "is out of range");
        }

        if (this.timeUnits[MINUTE_INDEX] < 0 || this.timeUnits[MINUTE_INDEX] > 60) {
            throw new org.python.exceptions.ValueError("minute " + this.timeUnits[MINUTE_INDEX] + "is out of range");
        }

        if (this.timeUnits[SECOND_INDEX] < 0 || this.timeUnits[SECOND_INDEX] > 60) {
            throw new org.python.exceptions.ValueError("second " + this.timeUnits[SECOND_INDEX] + "is out of range");
        }

        if (this.timeUnits[MICROSECOND_INDEX] < 0 || this.timeUnits[MICROSECOND_INDEX] > 1000000) {
            throw new org.python.exceptions.ValueError("microsecond " + this.timeUnits[MICROSECOND_INDEX] + "is out of range");
        }

        this.year = __year__();
        this.month = __month__();
        this.day = __day__();
        this.hour = __hour__();
        this.minute = __minute__();
        this.second = __second__();
        this.microsecond = __microsecond__();
    }

    public org.python.types.Str __str__() {
        String year = Long.toString(this.timeUnits[YEAR_INDEX]);
        while (year.length() < 4)
            year = "0" + year;

        String month = Long.toString(this.timeUnits[MONTH_INDEX]);
        while (month.length() < 2)
            month = "0" + month;

        String day = Long.toString(this.timeUnits[DAY_INDEX]);
        while (day.length() < 2)
            day = "0" + day;

        String hour = this.timeUnits[HOUR_INDEX] != 0 ? Long.toString(this.timeUnits[HOUR_INDEX]) : "00";
        while (hour.length() < 2)
            hour = "0" + hour;

        String minute = this.timeUnits[MINUTE_INDEX] != 0 ? Long.toString(this.timeUnits[MINUTE_INDEX]) : "00";
        while (minute.length() < 2)
            minute = "0" + minute;

        String second = this.timeUnits[SECOND_INDEX] != 0 ? Long.toString(this.timeUnits[SECOND_INDEX]) : "00";
        while (second.length() < 2)
            second = "0" + second;

        String microsecond = this.timeUnits[MICROSECOND_INDEX] != 0 ? Long.toString(this.timeUnits[MICROSECOND_INDEX]) : "";
        while (microsecond.length() < 6 && microsecond.length() != 0)
            microsecond = "0" + microsecond;

        String returnStr = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;

        returnStr += microsecond.length() > 0 ? "." + microsecond : "";
        return new org.python.types.Str(returnStr);
    }

    @org.python.Method(__doc__ = "")
    public org.python.Object date() {
	    org.python.Object[] args = { org.python.types.Int.getInt(this.timeUnits[YEAR_INDEX]), org.python.types.Int.getInt(this.timeUnits[MONTH_INDEX]),
		org.python.types.Int.getInt(this.timeUnits[DAY_INDEX]) };
	    return new Date(args, Collections.emptyMap());
    }

    @org.python.Method(__doc__ = "")
    public static org.python.Object today() {
	    java.time.LocalDateTime today = java.time.LocalDateTime.now();
	    org.python.Object[] args = { org.python.types.Int.getInt(today.getYear()), org.python.types.Int.getInt(today.getMonth().getValue()),
		org.python.types.Int.getInt(today.getDayOfMonth()), org.python.types.Int.getInt(today.getHour()), org.python.types.Int.getInt(today.getMinute()),
		org.python.types.Int.getInt(today.getSecond()), org.python.types.Int.getInt(today.getNano() / 1000) };
	    return new DateTime(args, Collections.emptyMap());
    }

    @org.python.Method(__doc__ = "returns year")
    public org.python.types.Str __year__() {
	    return new org.python.types.Str(this.timeUnits[YEAR_INDEX] + "");
    }

    @org.python.Method(__doc__ = "returns month")
    public org.python.types.Str __month__() {
	    return new org.python.types.Str(this.timeUnits[MONTH_INDEX] + "");
    }

    @org.python.Method(__doc__ = "returns day")
    public org.python.types.Str __day__() {
	    return new org.python.types.Str(this.timeUnits[DAY_INDEX] + "");
    }

    @org.python.Method(__doc__ = "returns hour")
    public org.python.types.Str __hour__() {
	    return new org.python.types.Str(this.timeUnits[HOUR_INDEX] + "");
    }

    @org.python.Method(__doc__ = "returns minute")
    public org.python.types.Str __minute__() {
	    return new org.python.types.Str(this.timeUnits[MINUTE_INDEX] + "");
    }

    @org.python.Method(__doc__ = "returns second")
    public org.python.types.Str __second__() {
	    return new org.python.types.Str(this.timeUnits[SECOND_INDEX] + "");
    }

    @org.python.Method(__doc__ = "returns microsecond")
    public org.python.types.Str __microsecond__() {
	    return new org.python.types.Str(this.timeUnits[MICROSECOND_INDEX] + "");
    }

    @org.python.Method(__doc__ = "")
    private static org.python.Object __min__() {
        org.python.types.Int year = org.python.types.Int.getInt(1);
        org.python.types.Int month = org.python.types.Int.getInt(1);
        org.python.types.Int day = org.python.types.Int.getInt(1);

        org.python.Object[] args = { year, month, day };
        return new DateTime(args, Collections.emptyMap());
    }

    @org.python.Method(__doc__ = "")
    private static org.python.Object __max__() {
        org.python.types.Int year = org.python.types.Int.getInt(9999);
        org.python.types.Int month = org.python.types.Int.getInt(12);
        org.python.types.Int day = org.python.types.Int.getInt(31);
        org.python.types.Int hour = org.python.types.Int.getInt(23);
        org.python.types.Int minute = org.python.types.Int.getInt(59);
        org.python.types.Int second = org.python.types.Int.getInt(59);
        org.python.types.Int microsecond = org.python.types.Int.getInt(999999);

        org.python.Object[] args = { year, month, day, hour, minute, second, microsecond };
        return new DateTime(args, Collections.emptyMap());
    }

    private static double [] get_values (DateTime date) {
        double year = ((org.python.types.Int) date.year.__int__()).value;
        double month = ((org.python.types.Int) date.month.__int__()).value;
        double day = ((org.python.types.Int) date.day.__int__()).value;
        double hour = ((org.python.types.Int) date.hour.__int__()).value;
        double minute = ((org.python.types.Int) date.minute.__int__()).value;
        double second = ((org.python.types.Int) date.second.__int__()).value;
        double microsecond = ((org.python.types.Int) date.microsecond.__int__()).value;
        double [] values = new double[]{year,month,day,hour,minute,second,microsecond};
        return values;
    }

    @org.python.Method(__doc__ = "")
    public org.python.Object weekday() {
        double [] values = get_values(this);
        double y = values[0];
        double m = values[1];
        double d = values[2];

        java.util.Date myCalendar = new java.util.GregorianCalendar((int) y, (int) m - 1, (int) d).getTime();
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(myCalendar);
        int day = c.get(java.util.Calendar.DAY_OF_WEEK);
        int[] convertToPython = { 6, 0, 1, 2, 3, 4, 5 };
        return org.python.types.Int.getInt(convertToPython[day - 1]);
    }

    public String fromordinal (long ordinal){
        int [] months = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        int month = 1;
        int year = get_year(ordinal);
        ordinal = ordinal - (((year-1) * 365) + check_how_many_leap_year(year));
        if (check_leap(year)){
            months[1] = 29;
        }

        for(int m = 0; m<12; m++){
            if (ordinal - months[m] <= 0){
                break;
            }
            ordinal -= months[m];
            month += 1;

        }
        return year + "-" + String.format("%02d", month) + "-" + String.format("%02d", ordinal);
    }

    private int get_year (long ordinal){
        int days = 0;
        int year = 0;
        for (int i = 1; i < 9999; i++ ){
            if (check_leap(i)){
                days = 366;
            } else {
                days = 365;
            }

            if (ordinal - days <= 0){
                year = i;
                break;
            }

            ordinal -= days;
        }
        return year;
    }

    private boolean check_leap (long year){
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    private int check_days_in_month (long month, long year){
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            return 31;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11){
            return 30;
        }
        if (month == 2 && check_leap(year)){
            return 29;
        }
        return 28;
    }

    private int check_days_before_month(long month, long year){
        int numberOfDays = 0;
        for (int d = 1; d<month; d++){
            numberOfDays += check_days_in_month(d, year);
        }
        return numberOfDays;
    }

    private int check_how_many_leap_year(long year){
        int count_leap_years = 0;
        for (int y = 0; y < year; y+=4){
            if (check_leap(y)){
                count_leap_years += 1;
            }
        }
        return count_leap_years-1;
    }

    public String toordinal (DateTime date) {
        long year = ((org.python.types.Int) date.year.__int__()).value;
        long month = ((org.python.types.Int) date.month.__int__()).value;
        long day = ((org.python.types.Int) date.day.__int__()).value;
        long dayInNormalYear = 365;

        return String.valueOf((year-1)*dayInNormalYear + check_days_before_month(month,year) + day + check_how_many_leap_year(year));
    }

    public static org.python.types.Bool __lt__ (DateTime date, DateTime date2) {
        double [] values = get_values(date);
        double [] values2 = get_values(date2);
        if (values[0] > values2[0]) {
            return Bool.FALSE;
        } else if (values[1] > values2[1]) {
            return Bool.FALSE;
        } else if (values[2] > values2[2]) {
            return Bool.FALSE;
        } else if (values[3] > values2[3]) {
            return Bool.FALSE;
        } else if (values[4] > values2[4]) {
            return Bool.FALSE;
        } else if (values[5] > values2[5]) {
            return Bool.FALSE;
        } else if (values[6] > values2[6]) {
            return Bool.FALSE;
        }
        return Bool.TRUE;
    }

    public static org.python.types.Bool __eq__ (DateTime date, DateTime date2) {
        double [] values = get_values(date);
        double [] values2 = get_values(date2);
        if (values[0] != values2[0]) {
            return Bool.FALSE;
        } else if (values[1] != values2[1]) {
            return Bool.FALSE;
        } else if (values[2] != values2[2]) {
            return Bool.FALSE;
        } else if (values[3] != values2[3]) {
            return Bool.FALSE;
        } else if (values[4] != values2[4]) {
            return Bool.FALSE;
        } else if (values[5] != values2[5]) {
            return Bool.FALSE;
        } else if (values[6] != values2[6]) {
            return Bool.FALSE;
        }
        return Bool.TRUE;
    }

    public static org.python.types.Bool __gt__ (DateTime date, DateTime date2) {
        double [] values = get_values(date);
        double [] values2 = get_values(date2);
        if (values[0] < values2[0]) {
            return Bool.FALSE;
        } else if (values[1] < values2[1]) {
            return Bool.FALSE;
        } else if (values[2] < values2[2]) {
            return Bool.FALSE;
        } else if (values[3] < values2[3]) {
            return Bool.FALSE;
        } else if (values[4] < values2[4]) {
            return Bool.FALSE;
        } else if (values[5] < values2[5]) {
            return Bool.FALSE;
        } else if (values[6] < values2[6]) {
            return Bool.FALSE;
        }
        return Bool.TRUE;
    }

}
