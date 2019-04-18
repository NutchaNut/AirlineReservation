import java.util.ArrayList;
import java.util.Date;

public class Reservation{

    private String reservationId;
    private String originLocation;
    private String destinationLocation;
    private int numberOfPassenger;
    private Date date;
    private ArrayList<Flight> searchedFlight;
    private Flight selectedFlight;
    private ArrayList<Passenger> passengers;
    private int totalPrice;

    Reservation(String origin, String destination, Date date, int noPassenger){
        this.originLocation = origin;
        this.destinationLocation = destination;
        this.date = date;
        this.numberOfPassenger = noPassenger;
    }

    public void selectFlight(){

    }
    
    public boolean addPassenger(){

    }

    public int calculatePrice(){

    }

    public void getSearchFlight(){

    }

    public void printFlight(){

    }
}