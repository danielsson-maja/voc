import org.junit.jupiter.api.Test;
import org.python.stdlib.datetime.Date;
import org.python.stdlib.datetime.DateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class test_DateTime {

    DateTime test;

    @Test
    public void testYear(){
        assertEquals("2021",((DateTime) DateTime.today()).__year__().toString());
    }

    @Test
    public void  testDate(){
        assertEquals("2021-09-15",((DateTime) DateTime.today()).date().toString());
    }

    @Test
    public void testToday(){
        assertEquals(null,test);
    }
}
