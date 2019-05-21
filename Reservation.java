import java.util.ArrayList;
//import java.util.Date;
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

        Scanner str = new Scanner(System.in);

        String name;
        String lastName;
        String passportId;
        String birthday;
        String gender;
        String phoneNumber;
        String email;

        for(int i = 1; i <= numberOfPassenger; i++){
            System.out.println("Passenger : " + i);

            System.out.print("Name : ");
            name = str.nextLine();

            System.out.print("LastName : ");
            lastName = str.nextLine();

            System.out.print("passport ID : ");
            passportId = str.nextLine();

            System.out.print("Birthday(dd/mm/yyyy) : ");
            birthday = str.nextLine();

            System.out.print("Gender(Male/Female) : ");
            gender = str.nextLine();

            System.out.print("Phone Number : ");
            phoneNumber = str.nextLine();

            System.out.print("Email : ");
            email = str.nextLine();

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
        if(selectedFlight.isTransit()){
            selectedFlight.printFlight();
        }else{
            selectedFlight.printFlight();
            selectedFlight.printTransitFlight();
        }
       
        //print all passenger 
        System.out.println("Passenger : ");
        Iterator iter = passengers.iterator();
        while (iter.hasNext()) {
            Passenger object = (Passenger)iter.next();
            object.printPassenger();
        }


    }

    public String getReservationId(){
        return reservationId;
    }
}