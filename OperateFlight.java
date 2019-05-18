import java.util.Date;

public class OperateFlight
{
    private Flight flight = null;
    private Date itineraryDate = new Date();
    private String originLocation;
    private String destinationLocation;
    private String transitLocation;
    private boolean checkTransit;

    OperateFlight(Flight flight,Date date,String origin,String destination,String transit,boolean checkTransit)
    {
        
        if(checkTransit == false)
        {
            this.flight = flight;
            this.itineraryDate = date;
            this.originLocation = origin;
            this.destinationLocation = destination;
            this.transitLocation = null;
        }
        else
        {
            this.flight = flight;
            this.itineraryDate = date;
            this.originLocation = origin;
            this.destinationLocation = destination;
            this.transitLocation = transit;

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

    public String getTransitLocation()
    {
        if(this.checkTransit == true)
        {
            return this.transitLocation;
        }
        else
        {
            return "This itinerary hasn't to have a transit flight";
        }
    }
    public boolean isTransit()
    {
        return this.checkTransit;
    }
   
}