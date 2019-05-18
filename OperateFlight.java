import java.util.Date;

public class OperateFlight
{
    private Flight flight = null;
    private Date itineraryDate = new Date();
    private String originLocation;
    private String destinationLocation;
    private Flight transitFlight;
    private boolean checkTransit;

    OperateFlight(Flight flight,Date date,String origin,String destination,Flight transit,boolean checkTransit)
    {
        
        if(checkTransit == false)
        {
            this.flight = flight;
            this.itineraryDate = date;
            this.originLocation = origin;
            this.destinationLocation = destination;
            this.transitFlight = null;
        }
        else
        {
            this.flight = flight;
            this.itineraryDate = date;
            this.originLocation = origin;
            this.destinationLocation = destination;
            this.transitFlight = transit;

        }
    }

    public Flight getFlight()
    {
        return this.flight;
    }

    public Date getItineraryDate()
    {
        return this.itineraryDate;
    }

    public String getOriginLocation()
    {
        return this.originLocation;
    }

    public String getDestinationLocation()
    {
        return this.destinationLocation;
    }

    public Flight getTransitFlight()
    {
       return this.transitFlight;
    }
    public boolean isTransit()
    {
        return this.checkTransit;
    }
   
}