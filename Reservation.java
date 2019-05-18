import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Iterator;

public class Reservation{

    private String reservationId;
    //private String originLocation;
    //private String destinationLocation;
    private int numberOfPassenger;
    //private Date date;
    //private ArrayList<Flight> searchedFlight;
    private OperateFlight selectedFlight;
    private ArrayList<Passenger> passengers;
    private int totalPrice;

    // Reservation(String origin, String destination, Date date, int noPassenger){
    //     this.originLocation = origin;
    //     this.destinationLocation = destination;
    //     this.date = date;
    //     this.numberOfPassenger = noPassenger;
    // }

    Reservation(String reservationId,OperateFlight flight, int noPassenger){
        this.reservationId = reservationId;
        this.selectedFlight = flight;
        //this.date = date;
        this.numberOfPassenger = noPassenger;
    }

    
    public void addPassenger(){

        Scanner in = new Scanner(System.in);

        String name;
        String lastName;
        String passportId;
        String birthday;
        String gender;
        String phoneNumber;
        String email;

        for(int i = 1; i <= numberOfPassenger; i++){
            System.out.println("Passenger : " + i);

            System.out.println("Name : ");
            name = in.nextLine();

            System.out.println("LastName : ");
            lastName = in.nextLine();

            System.out.println("passport ID : ");
            passportId = in.nextLine();

            System.out.println("Birthday(dd/mm/yyyy) : ");
            birthday = in.nextLine();

            System.out.println("Gender(Male/Female) : ");
            gender = in.nextLine();

            System.out.println("Phone Number : ");
            phoneNumber = in.nextLine();

            System.out.println("Email : ");
            email = in.nextLine();

            Passenger passenger = new Passenger(name, lastName, passportId, birthday, gender, phoneNumber, email);
            passengers.add(passenger);
        }

    }

    public void calculatePrice(){

        int cost = selectedFlight.getFlight().getPrice();
        totalPrice = cost * numberOfPassenger;

    }

    public void printIniterary(){

        //print flight
        System.out.println("Flight Detail : ");
        //print all passenger 
        System.out.println("Passenger : ");
        Iterator iter = passengers.iterator();
        while (iter.hasNext()) {
            Passenger object = (Passenger)iter.next();
            object.toString();
        }


    }

    public String getReservationId(){
        return reservationId;
    }
}