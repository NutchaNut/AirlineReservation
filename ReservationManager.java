import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.List;

/*
 * ReservationManager
 * 
 *      This class is use for managing reservation 
 *      have create reservation, save reservation, search reservation and cancel reservation
 *      
 *      Created by Nutcha Suwannayik (Nut) 59070501021
 *      18 April 2019
 */

public class ReservationManager
{
    /*store all reservation */                                                        
    private ArrayList<Reservation> allReservations;

     /*
     * searchById method use for search reservation by id
     * @param  reservationId   String of reservationId to identify reservation
     * @return Reservation object
     */
     public Reservation searchById(String reservationId)
     {
        Iterator iter = allReservations.iterator();                                      
        while (iter.hasNext()) 
        {
            Reservation object = (Reservation)iter.next();
            if(object.getReservationId().equals(reservationId))                         
            {
                return object;                                                          
            }
        }
        return null;
        
    }

    /*
     * cancelReservation method use for delete reservation
     * @param  reservationId   String of reservationId to identify reservation
     * @return boolean of cancel success 
     */    
    public boolean cancelReservation(String reservationId){

        Scanner in = new Scanner(System.in);

        /*search reservation by iterator*/
        Iterator iter = allReservations.iterator();                                                     
        while (iter.hasNext()) 
        {
            Reservation object = (Reservation)iter.next();
            /**if found reservation */
            if(object.getReservationId().equals(reservationId))                                         
            {
                /**print reservation detail */
                object.printIniterary();                                        
                /**get input to confirm reservation */                        
                System.out.println("---------------------------------------------------------");
                System.out.println("Do you want to cancel this reservation?[y/n] :");
                String ans = in.nextLine();                                                             
                in.close();
                if(ans.equals("y"))                                                                     
                {
                    /**delete reservation */
                    iter.remove();                                                                      
                    System.out.println("cancel success");
                    return true;
                }else
                {
                    System.out.println("return to menu");
                    return true;
                }
            }
        }
        System.out.println("Not Found Reservation");
        return false;
    }

    /*
     * showReservation method use for print reservation detail
     * @param  reservationId   String of reservationId to identify reservation
     */ 
    public void showReservation(String reservationId)
    {
        /** search reservation by id*/
        Reservation reservation = searchById(reservationId);                                    
        if(reservation != null)                                                                 
        {
            reservation.printIniterary();                                                       
        }else
        {
            System.out.println("Not Found Reservation");                                        
        }
    }

    /*
     * saveReservation method use for add reservation to arraylist
     * @param  reservation  object of reservation 
     */ 
    public boolean saveReservation(Reservation reservation)
    {
        /** add reservation to arraylist */
        if(allReservations.add(reservation))                                                   
        {
            return true;                                                                        
        }
        return false;                                                                           

    }

    /*
     * createReservation method use for create reservation
     * @param  flight  object of selected flight
     * @param  noPassenger integer of passenger
     */ 
    public void createReservation(OperateFlight flight, int noPassenger)
    {
        /** generate reservation id */
        String reservationId = generateId();                                                    

        /** create reservation */
        Reservation reservation = new Reservation(reservationId,flight, noPassenger);
        /** add passenger */
        reservation.addPassenger();                                                            
        /** calculate price */
        reservation.calculatePrice();                                                           
        /** print reservation detail */
        reservation.printIniterary();                                                          

        Scanner in = new Scanner(System.in);

        /** ask to confirm reservation*/
        System.out.println("------------------------------------------------------");
        System.out.println("Do you want to confirm reservation?[y/n] : ");
        String ans = in.nextLine();
        if(ans.equals("y"))                                                                     
        {
            /**save reservation */
            if(saveReservation(reservation))                                                    
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

    /*
     * generateId method use for generate reservation id
     * @return String of id
     */ 
    private String generateId()
    {
        /**key for generate */
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";                

        StringBuilder sb = new StringBuilder(6); 
  
        for (int i = 0; i < 6; i++)                                                             
        { 
            int index = (int)(AlphaNumericString.length() * Math.random()); 
            sb.append(AlphaNumericString.charAt(index)); 
        } 
        return sb.toString();                                                                  
    }
    
}