import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ScheduleFlight extends TextFileReader {
    private String flightId;
    private ArrayList<String> day;
    private Date departureTime = new Date();
    private Date arrivalTime = new Date();

    public ScheduleFlight readSchedule() {
        ScheduleFlight schedule = null;
        String line = getNextLine();

        String flightId;
        Date departureTime = new Date();
        Date arrivalTime = new Date();

        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        if (line != null) {
            String fields[] = line.split(" "); // split each field by space

            flightId = fields[0];

            try {
                departureTime = new SimpleDateFormat("HH:mm").parse(fields[5]);
            } catch (ParseException depart) {
                // TODO Auto-generated catch block
                depart.printStackTrace();
            }
            try {
                arrivalTime = new SimpleDateFormat("HH:mm").parse(fields[6]);
            } catch (ParseException arrive) {
                // TODO Auto-generated catch block
                arrive.printStackTrace();
            }

            schedule = new ScheduleFlight(flightId, day, departureTime, arrivalTime);
        }

        return schedule;
    }

    ScheduleFlight(String flightId, ArrayList<String> day, Date departureTime, Date arrivalTime)
    {
        this.flightId = flightId;
        this.day = day;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }
}