import java.util.Date;

public class OperateFlight
{
    private String flightId;
    private Date initeraryDate = new Date();
    private String originLocation;
    private String destinationLocation;

    OperateFlight(String flightId,Date date,String origin,String destination)
    {
        this.flightId = flightId;
        this.initeraryDate = date;
        this.originLocation = origin;
        this.destinationLocation = destination;
    }

    public String getFlightId()
    {
        return this.flightId;
    }

    public Date getIniteraryDate()
    {
        return this.initeraryDate;
    }

    public String getOriginLocation()
    {
        return this.originLocation;
    }

    public String getDestinationLocation()
    {
        return this.destinationLocation;
    }
   
}