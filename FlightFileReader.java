/**
 * FlightFileReader
 * 
 *      this class is use for read any involve file of Airline Reservarion Syatem.
 *  
 *      Created by Preyapach Tanathipchaicharoen (JJ) ID 59050701089
 *      ,12 May 2019
 */
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class FlightFileReader extends TextFileReader 
{

    /**
     * read flight file into system with 5 fields of data
     * @return flight with Flight Instance to the system arraylist
     */
    public Flight readFlight()
    {
        /*temperary variable for get data from file */
        Flight flight = null;
        String line = getNextLine();
        String flightId , airline , origin , destination;
        int totalSeat , price;

        if(line != null)
        {
            String fields[] = line.split(" "); // split each field by space

            /*get data from each field to the temperary variable */
            flightId = fields[0];
            airline = fields[1];
            origin = fields[2];
            destination = fields[3];
            totalSeat = Integer.parseInt(fields[4]);
            price = Integer.parseInt(fields[5]);
            
            /*create instance of Flight */
            flight = new Flight(flightId, airline, totalSeat, price,origin,destination);
        }

        return flight;
    }

    /**
     * read schedule file into system with 4 fields of data 
     * @return schedule with ScheduleFlight Instance to the system arraylist
     */
    public ScheduleFlight readSchedule() 
    {
        /*temperary variable for get data from file */
        ScheduleFlight schedule = null;
        String line = getNextLine();
        ArrayList<String> day = new ArrayList<String>();
        String flightId;
        Date departureTime = new Date();
        Date arrivalTime = new Date();

       
        if (line != null) {
            String fields[] = line.split(" "); // split each field by space

            flightId = fields[0];

            /*get day of week into arraylist */
            for(int i=1 ; i<4;i++)
            {
                day.add(fields[i]);
            }
                
            try 
            {
                /*get departure time with format */
                departureTime = new SimpleDateFormat("HH:mm").parse(fields[4]);

            } 
            catch (ParseException depart) 
            {
                
                depart.printStackTrace();
            }
            try 
            {
                /*get arrival time with format */
                arrivalTime = new SimpleDateFormat("HH:mm").parse(fields[5]);
            } 
            catch (ParseException arrive) 
            {
                
                arrive.printStackTrace();
            }

            /*create instance of ScheduleFlight */
            schedule = new ScheduleFlight(flightId, day, departureTime, arrivalTime);
        }

        return schedule; 
    }
   
    
}