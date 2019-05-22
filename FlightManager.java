/**
 * FlightManager
 *      
 *        This class is usr for manage flight when the user want to
 *         search and select flight to make reservation.
 * 
 *         Created by Preyapach Tanathipchaicharoen (JJ) ID 59070501089
 *          ,17 May 2019
 */

import java.text.SimpleDateFormat;
import java.util.*;

public class FlightManager 
{

    /*initial name of flight file */
    private String flightFile = "flight.txt";

    /*initial name of schedulse file */
    private String scheduleFile = "scheduleFile.txt";

    /*to keep all flight from file reader */
    private ArrayList<Flight> allFlight = new ArrayList<Flight>();

    /*to keep all schedule from file raeder */
    private ArrayList<ScheduleFlight> allSchedule = new ArrayList<ScheduleFlight>();

    /*to keep all search flight from searcFlight method */
    private ArrayList<OperateFlight> searchFlight = new ArrayList<OperateFlight>();

    /*to initial day of week name */
    private String[] weekDay = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
    
    /**
     * this method is use for read all of involved file 
     * to initial the system.
     * 
     */
    public void initialize() 
    {
        /*read all flight from file */
        FlightFileReader readFlight = new FlightFileReader();
        boolean checkFlight = readFlight.open(flightFile);

        if (checkFlight) 
        {
            Flight flight = null;
            while ((flight = readFlight.readFlight()) != null) 
            {
                allFlight.add(flight); /*add each flight from file into arraylist */
            }

        } 
        else 
        {
            System.out.println("Error opening file " + flightFile);
            System.exit(1);

        }

        System.out.println("Loading" + flightFile + "into system success!!");

        /*read schedule flight from file */
        FlightFileReader readSchedule = new FlightFileReader();
        boolean checkSchedule = readSchedule.open(scheduleFile);

        if (checkSchedule) 
        {
            ScheduleFlight schedule = null;
            while ((schedule = readSchedule.readSchedule()) != null) 
            {
                allSchedule.add(schedule); /*add each schedule into arraylist */
            }
        } 
        else 
        {
            System.out.println("Error opening file" + scheduleFile);
            System.exit(1);
        }
        System.out.println("Loading" + scheduleFile + "into system success!!");

    }

    /**
     * this mecthod is use for search any flight with specific itinerary information from the user
     * and keep all of search result in arraylist.
     * @param origin origin location of itinerary.
     * @param destination destination location of itinerary.
     * @param date itinerary date.
     * @param noPassenger number of passenger that user want to reserve.
     * @return arraylist of OperateFlight instance that keep all result when searching.
     */
    public ArrayList<OperateFlight> searchFlight(String origin,String destination,Date date,int noPassenger)
    {
           
           OperateFlight gotFlight = null;
           Flight flight = null;
           Flight transit = null; /*if which flight has to transit this variable is used. */
           ScheduleFlight schedule = null;
          
           
            for(int i=0; i < allFlight.size() ; i++)
            {
                /*check current flight from allFlight arraylist match with origin and destination or not */
                if(origin.equals(allFlight.get(i).getOrigin()) && destination.equals(allFlight.get(i).getDestination()))
                {
                    /*check current flight has an empty seats enough or not */
                    if(noPassenger <= allFlight.get(i).getTotalAvailableSeat())
                    {
                        /*keep current flight in temp */
                        flight = allFlight.get(i);
                        
                        /*get schedule of this current flight */
                        for(int j=0; j < allSchedule.size() ; j++)
                        {
                            /*search flight ID for get the schedule */
                            if(flight.getFlightId().equals(allSchedule.get(j).getFlightId()))
                            {
                                schedule = allSchedule.get(j);
                                
                                Date now = new Date();  /*get current day */
                            	Calendar c = Calendar.getInstance();
                                c.setTime(date);
                                int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) -1;  /*get daye of week from current date */
                                String day = weekDay[dayOfWeek];

                                
                                for(int k=0 ; k < schedule.getDay().size() ; k++)
                                {
                                    /*check this flight has the flight at the user specific date 
                                        and make sure user not reserve any flight on this day */
                                    if(day.equals(schedule.getDay().get(k)) && !(now.equals(date)))
                                    {
                                        gotFlight = new OperateFlight(flight, date, schedule, null,null,false);
                                        searchFlight.add(gotFlight); /*add this flight in arraylist */
                                    }
                                    
                                }
                            }
                            
                        }
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
                                Calendar c = Calendar.getInstance();
                                c.setTime(date);
                                int tempDay = c.get(Calendar.DAY_OF_WEEK) - 1;
                                String thisDay = weekDay[tempDay];
                                
                                Date now = new Date();
                                Date tomorrow = new Date(date.getTime()+ (1000 * 60 * 60 * 24)); //get tomorrow of date
                                c.setTime(tomorrow);
                                tempDay = c.get(Calendar.DAY_OF_WEEK)- 1;
                                String tomorrowDay = weekDay[tempDay];
                                
                                
                                for(int k=0 ; k < scheduleFlight.getDay().size() ; k++)
                                {
                                    if(thisDay.equals(scheduleFlight.getDay().get(k)) && !(now.equals(date)))
                                    {
                                        
                                        /*If the transit flight have traveling in the same day of the previous flight and also check the transit time is appropriate.*/
                                         
                                        if((thisDay.equals(scheduleTransit.getDay().get(k)) 
                                        && scheduleFlight.getArrivalTime().before(scheduleTransit.getDepartureTime())) 
                                        || tomorrowDay.equals(scheduleTransit.getDay().get(k)))
                                            
                                        {
                                            gotFlight = new OperateFlight(flight, date,scheduleFlight ,scheduleTransit ,transit,true);
                                            searchFlight.add(gotFlight);
                                        }
                                       
                                    }
                                  
                                }
                                
                                
                            }
                            
                        }
                }
            }
            
            
        return searchFlight;
           
    }

       public OperateFlight selectFlight()
       {
           OperateFlight flight = null;
           Scanner input = new Scanner(System.in);
           printFlight(searchFlight);
           
           System.out.print("Type No of flight to make reservation[0 is don't want to select any flight]: ");
           int  chooseFlight = input.nextInt();

           if(chooseFlight == 0)
           {
               flight = null;
           }
           else
           {
            flight = searchFlight.get(chooseFlight-1);
           }
           

           return flight;
       }

       public void printFlight(ArrayList<OperateFlight> allFlight)
       {
            OperateFlight flight = null;
            System.out.println("  No  |    Flight ID   |\t    Airline    |\t Origin Location |\t Destination Location |\t Departure Time  |\t  Arrival Time  ");
            for(int i=0 ; i < allFlight.size() ; i++)
            {
                flight = allFlight.get(i);
                if(flight.isTransit() == false)
                {
                    System.out.print("["+(i+1)+"]"+"\t|\t");
                    flight.printFlight();
                   
                }
                else
                {
                    flight.printFlight();
                    flight.printTransitFlight();
                    
                                    
                }
                
            }
           
       }

       public void clearSearch()
       {
            searchFlight.clear();
       }
    
}