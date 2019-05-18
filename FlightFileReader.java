import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class FlightFileReader extends TextFileReader 
{

    
    public Flight readFlight()
    {
        Flight flight = null;
        String line = getNextLine();
        String flightId , airline , origin , destination;
        int totalSeat , price;

        if(line != null)
        {
            String fields[] = line.split(" "); // split each field by space

            flightId = fields[0];
            airline = fields[1];
            origin = fields[2];
            destination = fields[3];
            totalSeat = Integer.parseInt(fields[4]);
            price = Integer.parseInt(fields[5]);
            

            flight = new Flight(flightId, airline, totalSeat, price,origin,destination);
        }

        return flight;
    }
    public ScheduleFlight readSchedule() 
    {
        ScheduleFlight schedule = null;
        String line = getNextLine();
        ArrayList<String> day = new ArrayList<String>();
        String flightId;
        Date departureTime = new Date();
        Date arrivalTime = new Date();

        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        if (line != null) {
            String fields[] = line.split(" "); // split each field by space

            flightId = fields[0];

            for(int i=1 ; i<4;i++)
            {
                day.add(fields[i]);
            }
                
            try {
                departureTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fields[4]);
            } catch (ParseException depart) {
                // TODO Auto-generated catch block
                depart.printStackTrace();
            }
            try {
                arrivalTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fields[5]);
            } catch (ParseException arrive) {
                // TODO Auto-generated catch block
                arrive.printStackTrace();
            }

            schedule = new ScheduleFlight(flightId, day, departureTime, arrivalTime);
        }

        return schedule;
    }
   
    
}