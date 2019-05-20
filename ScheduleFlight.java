import java.util.*;

public class ScheduleFlight extends TextFileReader {
    private String flightId;
    private ArrayList<String> day = new ArrayList<String>();
    private Date departureTime = new Date();
    private Date arrivalTime = new Date();
    

    public ScheduleFlight(String flightId, ArrayList<String> day, Date departureTime, Date arrivalTime)
    {
        this.flightId = flightId;
        this.day = day;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getFlightId()
    {
        return this.flightId;
    }

    public ArrayList<String> getDay()
    {
        return this.day;
    }

    public Date getDepartureTime()
    {
        return this.departureTime;
    }

    public Date getArrivalTime()
    {
        return this.arrivalTime;
    }
}