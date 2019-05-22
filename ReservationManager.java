import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.List;

public class ReservationManager
{
    private ArrayList<Reservation> allReservations;                                     //store all reservation

    //use to search reservation by id and return reservation
     public Reservation searchById(String reservationId)
     {
        Iterator iter = allReservations.iterator();                                      //loop to find id
        while (iter.hasNext()) 
        {
            Reservation object = (Reservation)iter.next();
            if(object.getReservationId().equals(reservationId))                         //if found reservation
            {
                return object;                                                          //return reservation
            }
        }
        return null;
        
    }

    //use to delete reservation 
    public boolean cancelReservation(String reservationId){

        Scanner in = new Scanner(System.in);

        //search reservation by iterator
        Iterator iter = allReservations.iterator();                                                     
        while (iter.hasNext()) 
        {
            Reservation object = (Reservation)iter.next();
            if(object.getReservationId().equals(reservationId))                                         //if found reservation
            {
                object.printIniterary();                                                                //print reservation detail
                System.out.println("---------------------------------------------------------");
                System.out.println("Do you want to cancel this reservation?[y/n] :");
                String ans = in.nextLine();                                                             //get input to confirm reservation
                in.close();
                if(ans.equals("y"))                                                                     //check input
                {
                    iter.remove();                                                                      //delete reservation
                    System.out.println("cancel success");
                    return true;
                }else
                {
                    System.out.println("return to menu");
                    return true;
                }
            }
        }
        in.close();
        System.out.println("Not Found Reservation");
        return false;
    }

    //use to print reservation detail
    public void showReservation(String reservationId)
    {
        Reservation reservation = searchById(reservationId);                                    //search reservation by id
        if(reservation != null)                                                                 //if found reservation
        {
            reservation.printIniterary();                                                       //print reservation detail
        }else
        {
            System.out.println("Not Found Reservation");                                        //not found reservation
        }
    }

    //use to add reservation to arraylist
    public boolean saveReservation(Reservation reservation)
    {

        if(allReservations.add(reservation))                                                    //add reservation to arraylist
        {
            return true;                                                                        //success
        }
        return false;                                                                           //fail

    }

    //use to create reservation
    public void createReservation(OperateFlight flight, int noPassenger)
    {

        String reservationId = generateId();                                                    //generate reservation id

        Reservation reservation = new Reservation(reservationId,flight, noPassenger);           //create reservation
        reservation.addPassenger();                                                             //add passenger
        reservation.calculatePrice();                                                           //calculate price
        reservation.printIniterary();                                                           //print reservation detail

        Scanner in = new Scanner(System.in);

        System.out.println("------------------------------------------------------");
        System.out.println("Do you want to confirm reservation?[y/n] : ");                      //ask confirm reservation
        String ans = in.nextLine();
        if(ans.equals("y"))                                                                     //if confirm
        {
            if(saveReservation(reservation))                                                    //if save reservation success
            {
                System.out.println("Success!");
            }
            else
            {
                System.out.println("Fail");
            }
        }else
        {
            System.out.println("return to menu");
        }

    }

    //use to generate reservation id
    private String generateId()
    {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";                //key to generate

        StringBuilder sb = new StringBuilder(6); 
  
        for (int i = 0; i < 6; i++)                                                             //generate 6 key in 1 id
        { 
            int index = (int)(AlphaNumericString.length() * Math.random()); 
            sb.append(AlphaNumericString.charAt(index)); 
        } 
        return sb.toString();                                                                   //return id
    }
    
}