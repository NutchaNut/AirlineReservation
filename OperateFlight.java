import java.util.Date;

public class OperateFlight
{
    private Flight flight = null;
    private Date initeraryDate = new Date();
    private String originLocation;
    private String destinationLocation;

    OperateFlight(Flight flight,Date date,String origin,String destination)
    {
        this.flight = flight;
        this.initeraryDate = date;
        this.originLocation = origin;
        this.destinationLocation = destination;
    }

    public Flight getFlight()
    {
        return this.flight;
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