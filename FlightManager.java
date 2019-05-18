import java.text.SimpleDateFormat;
import java.util.*;

public class FlightManager {

    String flightFile = "Flight.txt";
    String scheduleFile = "Schedule.txt";
    private ArrayList<Flight> allFlight = new ArrayList<Flight>();
    private ArrayList<ScheduleFlight> allSchedule = new ArrayList<ScheduleFlight>();
    ArrayList<OperateFlight> searchFlight = new ArrayList<OperateFlight>();

    public void initialize() {
        FlightFileReader readFlight = new FlightFileReader();
        boolean checkFlight = readFlight.open(flightFile);
        if (checkFlight) {
            Flight flight = null;
            while ((flight = readFlight.readFlight()) != null) {
                allFlight.add(flight);
            }

        } else {
            System.out.println("Error opening file" + flightFile);
            System.exit(1);

        }

        System.out.println("Loading" + flightFile + "into system success!!");

        FlightFileReader readSchedule = new FlightFileReader();
        boolean checkSchedule = readSchedule.open(scheduleFile);
        if (checkSchedule) {
            ScheduleFlight schedule = null;
            while ((schedule = readSchedule.readSchedule()) != null) {
                allSchedule.add(schedule);
            }
        } else {
            System.out.println("Error opening file" + scheduleFile);
            System.exit(1);
        }
        System.out.println("Loading" + scheduleFile + "into system success!!");

    }

    public ArrayList<OperateFlight> searchFlight(String origin,String destination,Date date,int noPassenger)
       {
           
           OperateFlight gotFlight = null;
           Flight flight = null;
           Flight transit = null;
           ScheduleFlight schedule = null;

           SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
           
           
            for(int i=0; i < allFlight.size() ; i++)
            {
                if(origin.equals(allFlight.get(i).getOrigin()) && destination.equals(allFlight.get(i).getDestination()))
                {
                    if(noPassenger <= allFlight.get(i).getTotalAvailableSeat())
                    {
                        flight = allFlight.get(i);
                        

                        for(int j=0; j < allSchedule.size() ; j++)
                        {
                            if(flight.getFlightId().equals(allSchedule.get(j).getFlightId()))
                            {
                                schedule = allSchedule.get(j);
                                Date now = new Date();
                                for(int k=0 ; k < schedule.getDay().size() ; k++)
                                {
                                    if(simpleDateformat.format(date).equals(schedule.getDay().get(k)) && !(now.equals(date)))
                                    {
                                        gotFlight = new OperateFlight(flight, date, origin, destination,null,false);
                                        searchFlight.add(gotFlight);
                                    }
                                    else
                                    {
                                        System.out.println("Please search for flights at least 1 day in advance before traveling.");
                                    }
                                }
                            }
                            else
                            {
                                System.out.println("Sorry,we don't have any flights traveling on this day.");
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Sorry,we don't have any flights that have enought seats for you.");
                    }
                    
                }
                else if(origin.equals(allFlight.get(i).getOrigin()))
                {   
                    String tempDestination = allFlight.get(i).getDestination();
                
                    for(int j=0 ;j<allFlight.size();j++)
                        if(tempDestination.equals(allFlight.get(j).getOrigin()) && destination.equals(allFlight.get(j).getDestination()))
                        {
                            if(noPassenger <= allFlight.get(i).getTotalAvailableSeat() && noPassenger <= allFlight.get(j).getTotalAvailableSeat())
                            {
                                flight = allFlight.get(i);
                                transit = allFlight.get(j);
                                ScheduleFlight scheduleFlight = null;
                                ScheduleFlight scheduleTransit = null;
                                for(int k=0; k < allSchedule.size() ; k++)
                                {
                                    if(flight.getFlightId().equals(allSchedule.get(k).getFlightId()))
                                    {
                                        scheduleFlight = allSchedule.get(k);
                                    }
                                }
                                for(int k=0; k < allSchedule.size() ; k++)
                                {
                                    if(transit.getFlightId().equals(allSchedule.get(k).getFlightId()))
                                    {
                                        scheduleTransit = allSchedule.get(k);
                                    }
                                }

                                Date now = new Date();
                                Date tomorrow = new Date(date.getTime()+ (1000 * 60 * 60 * 24)); //get tomorrow of date
                                for(int k=0 ; k < scheduleFlight.getDay().size() ; k++)
                                {
                                    if(simpleDateformat.format(date).equals(scheduleFlight.getDay().get(k)) && !(now.equals(date)))
                                    {
                                        if((simpleDateformat.format(date).equals(scheduleTransit.getDay().get(k)) 
                                            || simpleDateformat.format(tomorrow).equals(scheduleTransit.getDay().get(k))) 
                                            && scheduleFlight.getArrivalTime().before(scheduleTransit.getDepartureTime()))
                                        {
                                            gotFlight = new OperateFlight(flight, date, origin, destination,transit,true);
                                            searchFlight.add(gotFlight);
                                        }
                                        else
                                        {
                                            System.out.println("Sorry,we don't have any flights for your traveling");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Please search for flights at least 1 day in advance before traveling.");
                                    }
                                }
                                
                                
                            }
                            else
                            {
                                System.out.println("Sorry,we don't have any flights that have enought seats for you.");
                            }
                        }
                }
            }
            
        return searchFlight;
           
       }

       public OperateFlight selectFlight()
       {
           OperateFlight flight = null;
           printFlight(searchFlight);
           return flight;
       }

       public void printFlight(ArrayList<OperateFlight> allFlight)
       {

           
       }
    
}