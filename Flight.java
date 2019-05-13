public class Flight 
{
     
    private String flightId;
    private String airline;
    private int totalAvailableSeat;
    private int totalSeat;
    private int price;

    Flight(String flightId,String airline,int totalSeat,int price)
    {
        this.flightId = flightId;
        this.airline = airline;
        this.totalSeat = totalSeat;
        this.totalAvailableSeat = totalSeat - 0;
        this.price = price;
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
        return this.totalAvailableSeat;
    }

    public int getTotalSeat()
    {
        return this.totalSeat;
    }

    public int getPrice()
    {
        return this.price;
    }

    public void setTotalAvailableSeat(int numberPassenger)
    {
        this.totalAvailableSeat = this.totalSeat - numberPassenger;
    }
}