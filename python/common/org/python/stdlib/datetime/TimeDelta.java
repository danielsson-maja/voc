package org.python.stdlib.datetime;

import org.python.types.Bool;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TimeDelta extends org.python.types.Object {

    @org.python.Attribute
    public org.python.Object days = __days__();

    @org.python.Attribute
    public org.python.Object seconds = __seconds__();

    @org.python.Attribute
    public org.python.Object microseconds = __microseconds__();

    @org.python.Attribute
    public org.python.Object min = __min__();
    @org.python.Attribute
    public org.python.Object max = __max__();
    @org.python.Attribute
    public org.python.Object resolution = __resolution__();

    @org.python.Method(__doc__ = "")
    public TimeDelta(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs) {
        super();

        this.days = org.python.types.Int.getInt(0);
        this.seconds = org.python.types.Int.getInt(0);
        this.microseconds = org.python.types.Int.getInt(0);

        if (args.length > 7) {
            throw new org.python.exceptions.TypeError("__new__() takes at most 7 arguments (" + args.length + " given)");
        }

        /*
        for (org.python.Object arg : args) {
            if (!(arg instanceof org.python.types.Int) ) {
                throw new org.python.exceptions.TypeError("unsupported type for timedelta days component: '"+ arg.typeName() +" '");
            }
        }

        for (java.util.Map.Entry<java.lang.String, org.python.Object> kwarg : kwargs.entrySet()){
            if (!(kwarg.getValue() instanceof org.python.types.Int) ) {
                throw new org.python.exceptions.TypeError("unsupported type for timedelta days component: '"+ kwarg.getValue().typeName() +" '");
            }
        }*/

        String[] allowed = {"days", "seconds", "microseconds", "milliseconds", "minutes", "hours", "weeks"};
        List<String> allowedList = Arrays.asList(allowed);
        if (!kwargs.isEmpty()) {
            boolean correct = true;
            for (java.lang.String key : kwargs.keySet()) {
                correct = allowedList.contains(key);
                if (!correct) {
                    throw new org.python.exceptions.TypeError(key + " is an invalid keyword argument for this function");
                }
            }
            if (args.length > 0) {
                if (kwargs.get("days") != null && args.length >= 1) {
                    throw new org.python.exceptions.TypeError("Argument given by name ('days') and position (1)");
                }

                if (kwargs.get("seconds") != null && args.length >= 2) {
                    throw new org.python.exceptions.TypeError("Argument given by name ('seconds') and position (2)");
                }

                if (kwargs.get("microseconds") != null && args.length >= 3) {
                    throw new org.python.exceptions.TypeError("Argument given by name ('microseconds') and position (3)");
                }
            }
        }

        if (args.length == 7) {
            long weeksToDays = ((org.python.types.Int) args[6]).value * 7;
            long days = ((org.python.types.Int) args[0]).value;
            this.days = org.python.types.Int.getInt(days + weeksToDays);
            long hoursToSeconds = ((org.python.types.Int) args[5]).value * 3600;
            long minutesToSeconds = ((org.python.types.Int) args[4]).value * 60;
            long seconds = ((org.python.types.Int) args[1]).value;
            this.seconds = org.python.types.Int.getInt(seconds + minutesToSeconds + hoursToSeconds);
            long milliToMicroSeconds = ((org.python.types.Int) args[3]).value * 1000;
            long microSeconds = ((org.python.types.Int) args[2]).value;
            this.microseconds = org.python.types.Int.getInt(microSeconds + milliToMicroSeconds);
        } else if (args.length == 6) {
            this.days = args[0];
            long hoursToSeconds = ((org.python.types.Int) args[5]).value * 3600;
            long minutesToSeconds = ((org.python.types.Int) args[4]).value * 60;
            long seconds = ((org.python.types.Int) args[1]).value;
            this.seconds = org.python.types.Int.getInt(seconds + minutesToSeconds + hoursToSeconds);
            long milliToMicroSeconds = ((org.python.types.Int) args[3]).value * 1000;
            long microSeconds = ((org.python.types.Int) args[2]).value;
            this.microseconds = org.python.types.Int.getInt(microSeconds + milliToMicroSeconds);
        } else if (args.length == 5) {
            this.days = args[0];
            long minutesToSeconds = ((org.python.types.Int) args[4]).value * 60;
            long seconds = ((org.python.types.Int) args[1]).value;
            this.seconds = org.python.types.Int.getInt(seconds + minutesToSeconds);
            long milliToMicroSeconds = ((org.python.types.Int) args[3]).value * 1000;
            long microSeconds = ((org.python.types.Int) args[2]).value;
            this.microseconds = org.python.types.Int.getInt(microSeconds + milliToMicroSeconds);
        } else if (args.length == 4) {
            this.days = args[0];
            this.seconds = args[1];
            long milliToMicroSeconds = ((org.python.types.Int) args[3]).value * 1000;
            long microSeconds = ((org.python.types.Int) args[2]).value;
            this.microseconds = org.python.types.Int.getInt(microSeconds + milliToMicroSeconds);
        } else if (args.length == 3) {
            this.days = args[0];
            this.seconds = args[1];
            this.microseconds = args[2];
        } else if (args.length == 2) {
            this.days = args[0];
            this.seconds = args[1];
            this.microseconds = org.python.types.Int.getInt(0);
        } else if (args.length == 1) {
            this.days = args[0];
            this.seconds = org.python.types.Int.getInt(0);
            this.microseconds = org.python.types.Int.getInt(0);
        }

        if (kwargs.get("weeks") != null) {
            long weeks = ((org.python.types.Int) kwargs.get("weeks")).value;
            long day = ((org.python.types.Int) this.days).value;
            day = day + weeks * 7;
            this.days = org.python.types.Int.getInt(day);
        }

        if (kwargs.get("hours") != null) {
            long hours = ((org.python.types.Int) kwargs.get("hours")).value;
            long second = ((org.python.types.Int) this.seconds).value;
            second = second + hours * 3600;
            this.seconds = org.python.types.Int.getInt(second);
        }

        if (kwargs.get("minutes") != null) {
            long minutes = ((org.python.types.Int) kwargs.get("minutes")).value;
            long minute = ((org.python.types.Int) this.seconds).value;
            minute = minute + minutes * 60;
            this.seconds = org.python.types.Int.getInt(minute);
        }

        if (kwargs.get("milliseconds") != null) {
            long millisecond = ((org.python.types.Int) kwargs.get("milliseconds")).value;
            long mili = ((org.python.types.Int) this.microseconds).value;
            mili = mili + millisecond * 1000;
            this.microseconds = org.python.types.Int.getInt(mili);
        }

        this.normalizeMicroseconds();
        this.normalizeSeconds();
    }

    private void normalizeMicroseconds() {
        long seconds = ((org.python.types.Int) this.seconds).value;
        long microseconds = ((org.python.types.Int) this.microseconds).value;

        while ( microseconds >= 1000000) {
            microseconds -= 1000000;
            seconds += 1;
        }

        while (microseconds < 0) {
            microseconds = 1000000 + microseconds;
            seconds -= 1;
        }

        this.seconds = org.python.types.Int.getInt(seconds);
        this.microseconds = org.python.types.Int.getInt(microseconds);
    }

    private void normalizeSeconds() {
        long days = ((org.python.types.Int) this.days).value;
        long seconds = ((org.python.types.Int) this.seconds).value;

        while ( seconds >= 86400) {
            seconds -= 86400;
            days += 1;
        }

        while (seconds < 0) {
            seconds = 86400 + seconds;
            days -= 1;
        }

        this.days = org.python.types.Int.getInt(days);
        this.seconds = org.python.types.Int.getInt(seconds);
    }


    @org.python.Method(__doc__ = "returns days")
    public org.python.types.Int __days__() {
        return (org.python.types.Int) this.days;
    }

    @org.python.Method(__doc__ = "returns seconds")
    public org.python.types.Int __seconds__() {
        return (org.python.types.Int) this.seconds;
    }

    @org.python.Method(__doc__ = "returns microseconds")
    public org.python.types.Int __microseconds__() {
        return (org.python.types.Int) this.microseconds;
    }

    @org.python.Method()
    public org.python.Object __min__() {
        return new org.python.types.Str("-999999 days, 0:00:00");
    }

    @org.python.Method()
    public org.python.Object __max__() {
        return new org.python.types.Str("9999999 days, 23:59:59.999999");
    }

    @org.python.Method()
    public org.python.Object __resolution__() {
        return new org.python.types.Str("0:00:00.000001");
    }

    @org.python.Method()
    public org.python.types.Float total_seconds() {
        double days = ((org.python.types.Int) this.days).value * 24 * 3600;
        double sum_seconds = days + ((org.python.types.Int) this.seconds).value;
        double microseconds = ((org.python.types.Int) this.microseconds).value;
        double microsecondsInSeconds = microseconds / 1000000;
        double totalSeconds = sum_seconds + microsecondsInSeconds;
        return new org.python.types.Float(totalSeconds);
    }

    @org.python.Method(__doc__ = "", args = {"other"})
    public org.python.Object __add__(org.python.Object other) {
        long thisDays = ((org.python.types.Int) this.days).value;
        TimeDelta otherObject = (org.python.stdlib.datetime.TimeDelta) other;
        long otherDays = ((org.python.types.Int) otherObject.days).value;
        long thisSeconds = ((org.python.types.Int) this.seconds).value;
        long otherSeconds = ((org.python.types.Int) otherObject.seconds).value;
        long thisMicroseconds = ((org.python.types.Int) this.microseconds).value;
        long otherMicroSeconds = ((org.python.types.Int) otherObject.microseconds).value;
        long sumDays = thisDays + otherDays;
        long sumSeconds = thisSeconds + otherSeconds;
        long sumMicroseconds = thisMicroseconds + otherMicroSeconds;
        org.python.Object[] args = {org.python.types.Int.getInt(sumDays), org.python.types.Int.getInt(sumSeconds), org.python.types.Int.getInt(sumMicroseconds)};
        TimeDelta TD = new TimeDelta(args, Collections.EMPTY_MAP);
        return TD;
    }

    public org.python.Object __pos__() {
        long otherSeconds = ((org.python.types.Int) this.seconds).value;
        long otherMicroSeconds = ((org.python.types.Int) this.microseconds).value;
        long otherDays = ((org.python.types.Int) this.days).value;
        org.python.Object[] args = {org.python.types.Int.getInt(otherDays), org.python.types.Int.getInt(otherSeconds), org.python.types.Int.getInt(otherMicroSeconds)};
        TimeDelta TD = new TimeDelta(args, Collections.EMPTY_MAP);
        return TD;
    }

    public org.python.types.Str __str__() {
        long dayslong = ((org.python.types.Int) this.days).value;
        String days = Long.toString(dayslong);
        long seconds = ((org.python.types.Int) this.seconds).value;
        long microseconds = ((org.python.types.Int) this.microseconds).value;
        String returnStr = "days: " + days + ", seconds: " + seconds + ", microseconds: " + microseconds;
        return new org.python.types.Str(returnStr);
    }

    @org.python.Method(__doc__ = "Returns true if other is a copy of this", args = {"other"})
    public Bool __eq__(org.python.Object other) {
        if (other instanceof TimeDelta) {
            TimeDelta otherObject = (org.python.stdlib.datetime.TimeDelta) other;
            Bool daysEqual = (Bool) this.__days__().__eq__(otherObject.__days__());
            Bool secondsEqual = (Bool) this.__seconds__().__eq__(otherObject.__seconds__());
            Bool microsecondsEqual = (Bool) this.__microseconds__().__eq__(otherObject.__microseconds__());
            if (daysEqual.value && secondsEqual.value && microsecondsEqual.value) {
                return Bool.TRUE;
            } else {
                return Bool.FALSE;
            }
        } else {
            return Bool.FALSE;
        }
    }

    @org.python.Method(
        __doc__ = "Return self>value.",
        args = {"other"}
    )
    public Bool __gt__(org.python.Object other) {
        if (other instanceof TimeDelta) {
            TimeDelta otherObject = (org.python.stdlib.datetime.TimeDelta) other;
            if (this.total_seconds().value > otherObject.total_seconds().value) {
                return Bool.TRUE;
            } else {
                return Bool.FALSE;
            }
        } else {
            throw new org.python.exceptions.TypeError("'>' not supported between instances of 'datetime.timedelta' and '"+ other.typeName() +" '");
        }
    }

    @org.python.Method(
        __doc__ = "Return self<value.",
        args = {"other"}
    )
    public Bool __lt__(org.python.Object other) {
        if (other instanceof TimeDelta) {
            TimeDelta otherObject = (org.python.stdlib.datetime.TimeDelta) other;
            if (this.total_seconds().value < otherObject.total_seconds().value) {
                return Bool.TRUE;
            } else {
                return Bool.FALSE;
            }
        } else {
            throw new org.python.exceptions.TypeError("'<' not supported between instances of 'datetime.timedelta' and '"+ other.typeName() +" '");
        }
    }

    @org.python.Method(
        __doc__ = "Return self>=value.",
        args = {"other"}
    )
    public Bool __ge__(org.python.Object other) {
        if (other instanceof TimeDelta) {
            TimeDelta otherObject = (org.python.stdlib.datetime.TimeDelta) other;
            if (this.total_seconds().value >= otherObject.total_seconds().value) {
                return Bool.TRUE;
            } else {
                return Bool.FALSE;
            }
        } else {
            throw new org.python.exceptions.TypeError("'>=' not supported between instances of 'datetime.timedelta' and '"+ other.typeName() +" '");
        }
    }

    @org.python.Method(
        __doc__ = "Return self<=value.",
        args = {"other"}
    )
    public Bool __le__(org.python.Object other) {
        if (other instanceof TimeDelta) {
            TimeDelta otherObject = (org.python.stdlib.datetime.TimeDelta) other;
            if (this.total_seconds().value <= otherObject.total_seconds().value) {
                return Bool.TRUE;
            } else {
                return Bool.FALSE;
            }
        } else {
            throw new org.python.exceptions.TypeError("'<=' not supported between instances of 'datetime.timedelta' and '"+ other.typeName() +" '");
        }
    }
    /*
    @org.python.Method(
        __doc__ = "Return self<=value.",
        args = {"other"}
    )
    public TimeDelta __diff__(org.python.Object other) {
        if (other instanceof TimeDelta) {
            TimeDelta otherObject = (org.python.stdlib.datetime.TimeDelta) other;
            this.__days__() - otherObject.__days__();

        } else {
            throw new org.python.exceptions.TypeError("'<=' not supported between instances of 'datetime.timedelta' and '"+ other.typeName() +" '");
        }
    }*/


}
