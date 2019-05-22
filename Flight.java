public class Flight 
{
    /*store flight ID inform of string*/
    private String flightId;

    /*store airline name*/
    private String airline;

    /*store the total available seats for checking any flight is full or not*/
    private int totalAvailableSeat;

    /*total seats of each flight*/
    private int totalSeat;

    /*store price of each flight assume that every seat have the same price*/
    private int price;

    /*store the origin location of each flight*/
    private String origin;

    /*store the destination location of each flight*/
    private String destination;

    /**
     * Construture to initial create instance of flight.
     * @param flightId flightId is string paramitter to set flight ID to this flight.
     * @param airline airline is string paramitter to set airline in this flight.
     * @param totalSeat totalSeat is integer paramitter to set total seat in this flight.
     * @param price price is integer paramitter to set price of seat in this flight.
     * @param origin origin is string paramitter to set origin location of this flight.
     * @param destination destination is string paramitter to set destination location of this flight.
     */
    public Flight(String flightId,String airline,int totalSeat,int price,String origin,String destination)
    {
        this.flightId = flightId;
        this.airline = airline;
        this.totalSeat = totalSeat;
        this.totalAvailableSeat = totalSeat - 0; /*initial calculate available seats*/
        this.price = price;
        this.origin = origin;
        this.destination = destination;
    }
    
    /**
     * use to get flight ID.
     * @return flight ID of this flight.
     */
    public String getFlightId()
    {
        return this.flightId;
    }
    
    /**
     * use to get airline.
     * @return airline of this flight.
     */
    public String getAirline()
    {
        return this.airline;
    }
  
    /**
     * use to get total available seats.
     * @return total available seats of this flight.
     */
    public int getTotalAvailableSeat()
    {
        return totalAvailableSeat;
    }
    
    /**
     * use to get total seats.
     * @return total seats of this flight.
     */
    public int getTotalSeat()
    {
        return this.totalSeat;
    }

    
    /**
     * use to get price.
     * @return price of each seat in this flight.
     */
    public int getPrice()
    {
        return this.price;
    }

    /**
     * use to get origin location.
     * @return origin location of this flight.
     */
    public String getOrigin()
    {
        return this.origin;
    }

    /**
     * use to get destination location.
     * @return destination location of this flight.
     */
    public String getDestination()
    {
        return this.destination;
    }

    /**
     * use to calculate and set value of total avilable seats.
     * 
     */
    public void setTotalAvailableSeat(int numberPassenger)
    {
        this.totalAvailableSeat = this.totalSeat - numberPassenger;
    }
}