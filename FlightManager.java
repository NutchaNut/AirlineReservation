import java.util.ArrayList;
import java.util.Date;

public class FlightManager {

       
        String fileName = "Fligjt.txt";
        private ArrayList<Flight> allFlight = null;
       public void initialize()
       {
            FlightFileReader readFlight = new FlightFileReader();
            boolean bOk = readFlight.open(fileName);
            if(bOk)
            {
                Flight flight = null;
                while((flight = readFlight.readFlight())!= null)
                {
                    allFlight.add(flight);
                }

            }else
            {
                System.out.println("Error opening file"+fileName);
                System.exit(1);

            }

       }

       public ArrayList<Flight> searchFlight(String origin,String destination,Date date)
       {
           ArrayList<Flight> searchFlight = null;
            
        return searchFlight;
           
       }

       public Flight selectFlight()
       {
           Flight flight = null;
           return flight;
       }

       public void printFlight()
       {
           
       }
    
}