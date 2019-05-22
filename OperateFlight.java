/**
 * OperateFlight
 * 
 *      This class is using for createing instance of any flight after search process
 *      to use them in another process ,also print flight and transir flight from itself.
 * 
 *      Created by Preyapach Tanathipchaicharien (JJ) ID 59070501089
 *      ,19 May 2019
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class OperateFlight
{
    /*store flight of this itinerary*/
    private Flight flight = null;

    /*store the date of traveling*/
    private Date itineraryDate = new Date();

    /*store the schedule of flight in this itinerary*/
    private ScheduleFlight flightDetail = null;

    /*store the schedule of transit flight if it have transit flight */
    private ScheduleFlight transitDetail =null;

    /*store the transit flight of itinerary if it have transit flight */
    private Flight transitFlight;

    /*for check this itinerary have to transit flight or not */
    private boolean checkTransit;

    /**
     * Construture to initial create instance of operate flight.
     * @param flight flight is Flight instance paramitter to save the flight.
     * @param date date is date paramitter to set itinerary date to travel.
     * @param flightDetail flightDetail is ScheduleFlight instance paramitter to save the schedule of this flight.
     * @param transitDetail transitDetail is ScheduleFlight instance paramitter to save the schedule of transit flight.
     * @param transit transit is Flight instance paramitter to save the transit flight.
     * @param checkTransit checkTransi is boolean paramitter use for check this itinerary has to transit or not.
     */
    public OperateFlight(Flight flight,Date date,ScheduleFlight flightDetail,ScheduleFlight transitDetail,Flight transit,boolean checkTransit)
    {
        

            this.flight = flight;
            this.itineraryDate = date;
            this.flightDetail = flightDetail;
            this.transitDetail = transitDetail;
            this.transitFlight = transit;
            this.checkTransit = checkTransit;
    }

    /**
     * use for get flight of this itinerary.
     * @return this itinerary's flight.
     */
    public Flight getFlight()
    {
        return this.flight;
    }

    /**
     * use for get date of this itinerary.
     * @return this itinerary's date.
     */
    public Date getItineraryDate()
    {
        return this.itineraryDate;
    }

    /**
     * use for get schedule detail of flight in this itinerary.
     * @return this itinerary's schedule detail.
     */
    public ScheduleFlight getFlightDetail()
    {
        return this.flightDetail;
    }

    /**
     * use for get schedule detail of transit flight in this itinerary.
     * @return this itinerary's transit schedule detail ,
     *          if this itinerary hasn't transit will return null.
     */
    public ScheduleFlight getTransitDetail()
    {
        return this.transitDetail;
    }

    /**
     * use for get transit flight of this itinerary.
     * @return this itinerary's transit flight ,
     *           if this itinerary hasn't transit will return null.
     */
    public Flight getTransitFlight()
    {
       return this.transitFlight;
    }

    /**
     * use for check this itinerary has to transit or not
     * @return boolean ,if this itinerary hasn't transit will return false.
     */
    public boolean isTransit()
    {
        return this.checkTransit;
    }

    /**
     * use for print flight of this itinerary.
     */
    public void printFlight()
    {
        SimpleDateFormat time = new SimpleDateFormat("HH:mm");
         System.out.println(flight.getFlightId()+" |\t"
                                     +flight.getAirline()+" |\t"
                                     +flight.getOrigin()+" |\t"
                                     +flight.getDestination()+" |\t"
                                     +time.format(flightDetail.getDepartureTime())+" |\t"
                                     +time.format(flightDetail.getArrivalTime()));
                
    }

    /**
     * use for print transit flight of this itinerary.
     */
    public void printTransitFlight()
    {
        SimpleDateFormat time = new SimpleDateFormat("HH:mm");
        System.out.println("You have to transit flight at "+flight.getDestination()+" when arrival.And transit flight detail is");
                    System.out.println(transitFlight.getFlightId()+"  "+transitFlight.getAirline()+"  "
                                        +time.format(transitDetail.getDepartureTime())+"  "+time.format(transitDetail.getArrivalTime()));
    }
   
}