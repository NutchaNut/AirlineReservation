import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.List;

public class ReservationManager{

    private ArrayList<Reservation> allReservations;

     public Reservation searchById(String reservationId){
        Iterator iter = allReservations.iterator();
        while (iter.hasNext()) {
            Reservation object = (Reservation)iter.next();
            if(object.getReservationId().equals(reservationId)){
                return object;
            }
        }
        return null;
        
    }

    public boolean cancelReservation(String reservationId){

        Iterator iter = allReservations.iterator();
        while (iter.hasNext()) {
            Reservation object = (Reservation)iter.next();
            String id = object.getReservationId();
            if(id.equals(reservationId)){
                iter.remove();
                System.out.println("cancel success");
                return true;
            }
        }
        System.out.println("Not Found Reservation");
        return false;
    }

    public boolean showReservation(String reservationId){
        Reservation reservation = searchById(reservationId);
        if(reservation != null){
            reservation.printIniterary();
            return true;
        }else{
            System.out.println("Not Found Reservation");
            return false;
        }
    }

    public boolean saveReservation(Reservation reservation){

        if(allReservations.add(reservation)){
            return true;
        }
        return false;

    }

    public void createReservation(OperateFlight flight, Date date){

        String reservationId = generateId();
        System.out.println(reservationId);

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

    String generateId(){
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";

        StringBuilder sb = new StringBuilder(6); 
  
        for (int i = 0; i < 6; i++) { 

            int index = (int)(AlphaNumericString.length() * Math.random()); 
  
            sb.append(AlphaNumericString .charAt(index)); 
        } 
        return sb.toString();
    }
    
}