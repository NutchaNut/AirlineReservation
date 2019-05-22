/**
 * ScheduleFlight
 *      
 *      This class is use for keep the schedule of each flight
 *      in the same form.
 * 
 *      Created by Preyapach Tanathipchaicharoen (JJ) ID 59070501089
 *      ,18 April 2019
 */
import java.util.*;

public class ScheduleFlight
{
    /* store flight ID that usr for match to the instance of Flight class*/
    private String flightId;

    /*store the week day that this flight able to reserve */
    private ArrayList<String> day = new ArrayList<String>();

    /*store the departure time of this flight */
    private Date departureTime = new Date();

    /*store the arrival time of this flight */
    private Date arrivalTime = new Date();
    

    /**
     * Constructure to initial create the instance of schedule flight.
     * @param flightId flightId is String paramitter for set the flight ID of this schedule.
     * @param day day is the arraylist paramitter of the week day  that this flight able to reserve.
     * @param departureTime departureTime is the date paramitter use for set the departure time of this schedule .
     * @param arrivalTime arrivalTime is the date paramitter use for set the arrival time of this  schedule.  
     */
    public ScheduleFlight(String flightId, ArrayList<String> day, Date departureTime, Date arrivalTime)
    {
        this.flightId = flightId;
        this.day = day;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }
    /**
     * use for get flight ID of this schedule.
     * @return flight ID of this schdule.
     */
    public String getFlightId()
    {
        return this.flightId;
    }

    /**
     * use for get day of week from this schedule.
     * @return day of week from this schedule.
     */
    public ArrayList<String> getDay()
    {
        return this.day;
    }

    /**
     * use for get departure time of this schedule
     * @return departure time 
     */
    public Date getDepartureTime()
    {
        return this.departureTime;
    }

    /**
     * use for get arrival time of this schedule
     * @return arrival time 
     */
    public Date getArrivalTime()
    {
        return this.arrivalTime;
    }
}