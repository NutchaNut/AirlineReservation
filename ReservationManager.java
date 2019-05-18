import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ReservationManager{

    private ArrayList<Reservation> allReservations;

    // public AllReservation searchById(){
    //     //AllReservation reservation = new AllReservation(reservationId, flight, passengers, price);
        
        
    // }

    public boolean cancelReservation(){

        return false;
    }

    public boolean showReservation(){

        return false;
    }

    public boolean saveReservation(Reservation reservation){

        if(allReservations.add(reservation)){
            return true;
        }
        return false;

    }

    public void createReservation(OperateFlight flight, Date date){

        String reservationId = UUID.randomUUID().toString();

        Scanner in = new Scanner(System.in);
        int noPassenger;

        System.out.println("Enter Number of Passenger : ");
        noPassenger = in.nextInt();

        Reservation reservation = new Reservation(reservationId,flight, noPassenger);
        reservation.addPassenger();
        reservation.calculatePrice();
        reservation.printIniterary();

        System.out.println("Do you want to confirm reservation?[y/n] : ");
        String ans = in.nextLine();
        if(ans.equals("y")){
            if(saveReservation(reservation)){
                System.out.println("Success!");
            }
            else{
                System.out.println("Fail");
            }
        }

    }

    
}