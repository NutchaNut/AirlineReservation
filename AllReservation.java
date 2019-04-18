import java.util.ArrayList;

public class AllReservation{

    private String reservationId;
    private Flight flight;
    private ArrayList<Passenger> passengers;
    private int price;

    AllReservation(String reservationId, Flight flight, ArrayList<Passenger> passengers, int price){
        this.reservationId = reservationId;
        this.flight = flight;
        this.passengers = passengers;
        this.price = price;
    }
    
}