import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConversion {
    public static String timeConversion(String hours) {
        // Write your code here
        String[] aux;
        String fm;
        if (hours.contains("PM")){
            aux = hours.replace("PM", "").split(":");
            fm = "PM";
        }else {
            aux = hours.replace("AM", "").split(":");
            fm = "AM";
        }
        Integer hh = Integer.parseInt(aux[0]);

        if (hh < 12 && fm.equals("PM")){
            aux[0] = String.valueOf(hh + 12);
        } else if (hh == 12 && fm.equals("AM")) {
            aux[0] = "00";
        }

        return aux[0]+":"+aux[1]+":"+aux[2];
    }
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        Date date;
//        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aa");
        String hours12 = reader.readLine().replace("PM", " PM");

        System.out.println(timeConversion(hours12));

    }
}
