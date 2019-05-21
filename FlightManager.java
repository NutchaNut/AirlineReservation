import java.text.SimpleDateFormat;
import java.util.*;

public class FlightManager 
{

    String flightFile = "flight.txt";
    String scheduleFile = "scheduleFile.txt";
    private ArrayList<Flight> allFlight = new ArrayList<Flight>();
    private ArrayList<ScheduleFlight> allSchedule = new ArrayList<ScheduleFlight>();
    ArrayList<OperateFlight> searchFlight = new ArrayList<OperateFlight>();
    String[] weekDay = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
    
    public void initialize() 
    {

        FlightFileReader readFlight = new FlightFileReader();
        boolean checkFlight = readFlight.open(flightFile);
        if (checkFlight) 
        {
            Flight flight = null;
            while ((flight = readFlight.readFlight()) != null) 
            {
                allFlight.add(flight);
            }

        } 
        else 
        {
            System.out.println("Error opening file " + flightFile);
            System.exit(1);

        }

        System.out.println("Loading" + flightFile + "into system success!!");

        FlightFileReader readSchedule = new FlightFileReader();
        boolean checkSchedule = readSchedule.open(scheduleFile);
        if (checkSchedule) 
        {
            ScheduleFlight schedule = null;
            while ((schedule = readSchedule.readSchedule()) != null) 
            {
                allSchedule.add(schedule);
            }
        } 
        else 
        {
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
                            	Calendar c = Calendar.getInstance();
                                c.setTime(date);
                                int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
                                String day = weekDay[dayOfWeek];
                                for(int k=0 ; k < schedule.getDay().size() ; k++)
                                {
                                    if(day.equals(schedule.getDay().get(k)) && !(now.equals(date)))
                                    {
                                        gotFlight = new OperateFlight(flight, date, schedule, null,null,false);
                                        searchFlight.add(gotFlight);
                                    }
                                    // else
                                    // {
                                    //     System.out.println("Please search for flights at least 1 day in advance before traveling.");
                                    // }
                                }
                            }
                            // else
                            // {
                            //     System.out.println("Sorry,we don't have any flights traveling on this day.");
                            // }
                        }
                    }
                    // else
                    // {
                    //     System.out.println("Sorry,we don't have any flights that have enought seats for you.");
                    // }
                    
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
                                        // else
                                        // {
                                        //     System.out.println("Sorry,we don't have any flights for your traveling");
                                        // }
                                    }
                                    // else
                                    // {
                                    //     System.out.println("Please search for flights at least 1 day in advance before traveling.");
                                    // }
                                }
                                
                                
                            }
                            // else
                            // {
                            //     System.out.println("Sorry,we don't have any flights that have enought seats for you.");
                            // }
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
            System.out.println();
           System.out.print("Type No of flight to mak reservation[0 is don't want to select any flight]: ");
           int  chooseFlight = input.nextInt();

           if(chooseFlight == 0)
           {
               flight = null;
           }
           else
           {
            flight = searchFlight.get(chooseFlight-1);
           }
           

           input.close();

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
                    // System.out.println("["+(i+1)+"]"+flight.getFlight().getFlightId()+" |\t"
                    //                 +flight.getFlight().getAirline()+" |\t"
                    //                 +flight.getFlight().getOrigin()+" |\t"
                    //                 +flight.getFlight().getDestination()+" |\t"
                    //                 +flight.getFlightDetail().getDepartureTime()+" |\t"
                    //                 +flight.getFlightDetail().getArrivalTime());
                }
                else
                {
                    flight.printFlight();
                    flight.printTransitFlight();
                    // System.out.println("["+(i+1)+"]"+flight.getFlight().getFlightId()+" |\t"
                    //                 +flight.getFlight().getAirline()+" |\t"
                    //                 +flight.getFlight().getOrigin()+" |\t"
                    //                 +flight.getFlight().getDestination()+" |\t"
                    //                 +flight.getFlightDetail().getDepartureTime()+" |\t"
                    //                 +flight.getFlightDetail().getArrivalTime());
                    // System.out.println("You have to transit flight at "+flight.getFlight().getDestination()+" when arrival.And transit flight detail is");
                    // System.out.println(flight.getTransitFlight().getFlightId()+"  "+flight.getTransitFlight().getAirline()+"  "
                    //                     +flight.getTransitDetail().getDepartureTime()+"  "+flight.getTransitDetail().getArrivalTime());
                                    
                }
                
            }
           
       }

       public void clearSearch()
       {
            searchFlight.clear();
       }
    
}