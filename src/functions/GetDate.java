package functions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class GetDate {
    public String informDate(){
        Date toDay = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = new GregorianCalendar();
        cal.setTime(toDay);
        return df.format(cal.getTime());
    }
}
