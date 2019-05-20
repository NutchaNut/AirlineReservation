public class Flight 
{
     
    private String flightId;
    private String airline;
    private int totalAvailableSeat;
    private int totalSeat;
    private int price;
    private String origin;
    private String destination;

    public Flight(String flightId,String airline,int totalSeat,int price,String origin,String destination)
    {
        this.flightId = flightId;
        this.airline = airline;
        this.totalSeat = totalSeat;
        this.totalAvailableSeat = totalSeat - 0;
        this.price = price;
        this.origin = origin;
        this.destination = destination;
    }
    
    public String getFlightId()
    {
        return this.flightId;
    }

    public String getAirline()
    {
        return this.airline;
    }

    public int getTotalAvailableSeat()
    {
        return totalAvailableSeat;
    }

    public int getTotalSeat()
    {
        return this.totalSeat;
    }

    public int getPrice()
    {
        return this.price;
    }

    public String getOrigin()
    {
        return this.origin;
    }

    public String getDestination()
    {
        return this.destination;
    }

    public void setTotalAvailableSeat(int numberPassenger)
    {
        this.totalAvailableSeat = this.totalSeat - numberPassenger;
    }
}