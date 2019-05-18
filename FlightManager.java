import java.util.ArrayList;
import java.util.Date;

public class FlightManager {

       
        String flightFile = "Flight.txt";
        String scheduleFile = "Schedule.txt";
        private ArrayList<Flight> allFlight = new ArrayList<Flight>();
        private ArrayList<ScheduleFlight> allSchedule = new ArrayList<ScheduleFlight>();
       public void initialize()
       {
            FlightFileReader readFlight = new FlightFileReader();
            boolean checkFlight = readFlight.open(flightFile);
            if(checkFlight)
            {
                Flight flight = null;
                while((flight = readFlight.readFlight())!= null)
                {
                    allFlight.add(flight);
                }

            }
            else
            {
                System.out.println("Error opening file"+flightFile);
                System.exit(1);

            }

            System.out.println("Loading"+flightFile+"into system success!!");

            FlightFileReader readSchedule = new FlightFileReader();
            boolean checkSchedule = readSchedule.open(scheduleFile);
            if(checkSchedule)
            {
                ScheduleFlight schedule =null;
                while((schedule = readSchedule.readSchedule())!= null)
                {
                    allSchedule.add(schedule);
                }
            }
            else
            { 
                System.out.println("Error opening file"+scheduleFile);
                System.exit(1);
            }
            System.out.println("Loading"+scheduleFile+"into system success!!");

       }

       public ArrayList<Flight> searchFlight(String origin,String destination,Date date,int noPassenger)
       {
           ArrayList<Flight> searchFlight = null;
           OperateFlight gotFlight = null;

           String tempId = null;
           String tempOrigin =null;
           String tempDest = null;
           Date tempDate = new Date();

           
            for(int i=0; i< allFlight.size() ; i++)
            {
                if(origin.equals(allFlight.get(i).getOrigin()) && destination.equals(allFlight.get(i).getDestination()))
                {
                    if(noPassenger <= allFlight.get(i).getTotalAvailableSeat())
                    {
                        tempId = allFlight.get(i).getFlightId();
                        for(int j=0; i<allSchedule.size() ; j++)
                        {

                        }
                    }
                    
                }
            }
            
        return searchFlight;
           
       }

       public Flight selectFlight()
       {
           Flight flight = null;
           return flight;
       }

       public void printFlight(ArrayList<Flight> allFlight)
       {

           
       }
    
}