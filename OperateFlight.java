import java.util.Date;

public class OperateFlight
{
    private Flight flight = null;
    private Date itineraryDate = new Date();
    private ScheduleFlight flightDetial = null;
    private ScheduleFlight transitDetail =null;
    private Flight transitFlight;
    private boolean checkTransit;

    public OperateFlight(Flight flight,Date date,ScheduleFlight flightDetail,ScheduleFlight transitDetail,Flight transit,boolean checkTransit)
    {
        

            this.flight = flight;
            this.itineraryDate = date;
            this.flightDetial = flightDetail;
            this.transitDetail = transitDetail;
            this.transitFlight = transit;
            this.checkTransit = checkTransit;
    }

    public Flight getFlight()
    {
        return this.flight;
    }

    public Date getItineraryDate()
    {
        return this.itineraryDate;
    }

    public ScheduleFlight getFlightDetail()
    {
        return this.flightDetial;
    }

    public ScheduleFlight getTransitDetail()
    {
        return this.transitDetail;
    }

    public Flight getTransitFlight()
    {
       return this.transitFlight;
    }
    public boolean isTransit()
    {
        return this.checkTransit;
    }

    public void printFlight()
    {
        System.out.println("Flight Id : " + flight.getFlightId());
        System.out.println("Airline : " + flight.getAirline());
        System.out.println("Departure from : " + flight.getOrigin() + "   Departure Time : " + flightDetial.getDepartureTime());
        System.out.println("Arrival at : " + flight.getDestination()+ "   Arrival Time : " + flightDetial.getArrivalTime());
    }

    public void printTransitFlight(){
        System.out.println("You have to transit flight at "+flight.getDestination()+" when arrival.And transit flight detail is");
                    System.out.println(transitFlight.getFlightId()+"  "+transitFlight.getAirline()+"  "
                                        +transitDetail.getDepartureTime()+"  "+transitDetail.getArrivalTime());
    }
   
}