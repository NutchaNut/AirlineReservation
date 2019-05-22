import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.io.*;


public class Reservation
{
    private String reservationId;                                                           
    private int numberOfPassenger;
    private OperateFlight selectedFlight;
    private ArrayList<Passenger> passengers;
    private int totalPrice;

    //constructor
    Reservation(String reservationId,OperateFlight flight, int noPassenger)
    {
        this.reservationId = reservationId;
        this.selectedFlight = flight;
        this.numberOfPassenger = noPassenger;
    }

    
    public void addPassenger()
    {
        String name;
        String lastName;
        String passportId;
        String birthday;
        String gender;
        String phoneNumber;
        String email;

        for(int i = 1; i <= numberOfPassenger; i++)                                                 //loop for fill in data of passenger
        {
            System.out.println("Passenger : " + i);

            Scanner str = new Scanner(System.in);
            str.nextLine();

            System.out.print("Name : ");                                                            //get name
            name = str.nextLine();

            System.out.print("LastName : ");                                                        //get last name
            lastName = str.nextLine();

            System.out.print("passport ID : ");                                                     //get passport id
            passportId = str.nextLine();

            System.out.print("Birthday(dd/mm/yyyy) : ");                                            //get birthday
            birthday = str.nextLine();

            System.out.print("Gender(Male/Female) : ");                                             //get gender
            gender = str.nextLine();

            System.out.print("Phone Number : ");                                                    //get phone number
            phoneNumber = str.nextLine();

            System.out.print("Email : ");                                                           //get email
            email = str.nextLine();

            Passenger passenger = new Passenger(name, lastName, passportId, birthday, gender, phoneNumber, email);          //create passenger
            passengers.add(passenger);                                                              //add passenger to arraylist

            str.close();
        }

    }

    //use to calculate price
    public void calculatePrice()
    {
        int cost = selectedFlight.getFlight().getPrice();                                           //get price of flight
        totalPrice = cost * numberOfPassenger;                                                      //calculate price
    }

    //use to print reservation detail
    public void printIniterary()
    {
        System.out.println("Reservation Id : " + reservationId);                                    //print reservation id

        System.out.println("Flight Detail : ");                                                     //print flight
        if(selectedFlight.isTransit())                                                              //check flight transit
        {
            selectedFlight.printFlight();                                                           //print flight and transit flight
            selectedFlight.printTransitFlight();
        }else
        {
            selectedFlight.printFlight();                                                           //print flight
        }
       
        System.out.println("Passenger : ");                                                         //print all passenger 
        Iterator iter = passengers.iterator();                                                      //loop for print passenger from arraylist
        while (iter.hasNext()) 
        {
            Passenger object = (Passenger)iter.next();
            object.printPassenger();
        }

        System.out.println("Total Price : " + totalPrice);                                          //print price

    }

    //use to get reservation id
    public String getReservationId()                                                                
    {
        return reservationId;
    }

    // protected static String getString(String prompt)
    //    {
    //    int value = 0;	   
    //    String inputString;
    //    int readBytes = 0;
    //    byte buffer[] = new byte[200]; 
    //    System.out.println(prompt);
    //    try
    //        {
    //        readBytes = System.in.read(buffer,0,200);
	//    }
    //    catch (IOException ioe)
    //        {
	//    System.out.println("Input/output exception - Exiting");
	//    System.exit(1);
    //        }
    //    inputString = new String(buffer);
    //    try 
    //        {
	//    /* modify to work for both Windows and Linux */
	//    int pos = inputString.indexOf("\r");
	//    if (pos <= 0)
	//        pos = inputString.indexOf("\n");
    //        if (pos > 0)
	//       inputString = inputString.substring(0,pos);
    //        //value = Integer.parseInt(inputString);
	//    }
    //    catch (NumberFormatException nfe) 
    //        {
	//    System.out.println("Bad number entered - Exiting");
	//    System.exit(1);
    //        }
    //    return inputString;
    //    }
}