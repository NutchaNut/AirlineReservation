import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.io.*;

/*
 * Reservation
 * 
 *      This class is creating for instance of Reservation
 *      collect Reservation detail, add passenger, calculate price
 *      
 *      Created by Nutcha Suwannayik (Nut) 59070501021
 *      18 April 2019
 */

public class Reservation
{
     /*store reservationId for identify reservation */
     private String reservationId;   
     /*store number of passenger */                                                        
     private int numberOfPassenger;
     /*store selectedFlight that have flight detail */                                                        
     private OperateFlight selectedFlight;
     /*store list of passenger */                                                        
     private ArrayList<Passenger> passengers;
     /*store totalPrice */                                                        
     private int totalPrice;
 
     /**
     * Construtor to create instance of Reservation.
     * @param  reservationId   String of reservationId to identify reservation
     * @param  flight   OperateFlight flight keep selected flight
     * @param  noPassenger   number of passenger
      */
    Reservation(String reservationId,OperateFlight flight, int noPassenger)
    {
        this.reservationId = reservationId;
        this.selectedFlight = flight;
        this.numberOfPassenger = noPassenger;
    }

    /*
     * addPassenger method use for create instance of Passenger
     */
    public void addPassenger()
    {
        Scanner in = new Scanner(System.in);
        String name;
        String lastName;
        String passportId;
        String birthday;
        String gender;
        String phoneNumber;
        String email;

        /*loop for fill in data of passenger*/
        for(int i = 1; i <= numberOfPassenger; i++)                                                 
        {
            System.out.println("Passenger : " + i);

            Scanner str = new Scanner(System.in);
            str.nextLine();

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

            /*create instance of Passenger and add to arraylist */
            Passenger passenger = new Passenger(name, lastName, passportId, birthday, gender, phoneNumber, email);          
            passengers.add(passenger);                                                              
        }

    }

   /*
     * calculatePrice method use for calculate total price 
     */
    public void calculatePrice()
    {
        /*get price of flight*/
        int cost = selectedFlight.getFlight().getPrice();                                           
        totalPrice = cost * numberOfPassenger;                                                      
    }

    /*
     * printIniterary method use for print reservation detail
     */
    public void printIniterary()
    {
        /*print reservation detail */
        System.out.println("Reservation Id : " + reservationId);                                   

        /*print flight detail */
        System.out.println("Flight Detail : ");                                                     
        if(selectedFlight.isTransit())                                                              
        {
            selectedFlight.printFlight();                                                           
            selectedFlight.printTransitFlight();
        }else
        {
            selectedFlight.printFlight();                                                           
        }

        /*print all passenger detail */
        System.out.println("Passenger : ");                                                          
        Iterator iter = passengers.iterator();                                                      
        while (iter.hasNext()) 
        {
            Passenger object = (Passenger)iter.next();
            object.printPassenger();
        }

        /*print price */
        System.out.println("Total Price : " + totalPrice);                                         

    }

     /**
     * get Reservation Id
     * @return string of reservation id
     */
    //use to get reservation id
    public String getReservationId()                                                                
    {
        return reservationId;
    }

}