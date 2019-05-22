import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class Menu 
{
    private static String originLocation;
    private static String destinationLocation;
    private static Date date;
    private static int noPassenger;
    private static ReservationManager allReservation = null;

    public static void main(String[] args) 
    {
        Scanner ch = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        int selectMenu = 0;
        String id;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        FlightManager flightManager = new FlightManager();
        ReservationManager reservationManager = new ReservationManager();
        OperateFlight selectFlight = null;
        ArrayList<OperateFlight> searchFlight = new ArrayList<OperateFlight>();

        flightManager.initialize();

        System.out.println("welcome to airline reservation program");
        do                                                                                                      //loop of menu
        {
            System.out.println("---------------------------------------");                                      //print menu
            System.out.println("menu : ");
            System.out.println("1 Search Flight");
            System.out.println("2 Search Reservation");
            System.out.println("3 Cancl Reservation");
            System.out.println("0 Exit");
            System.out.println("---------------------------------------");
            System.out.print("Enter menu : ");                                                                  //get select menu
            selectMenu = in.nextInt();
            System.out.flush();

            switch (selectMenu)                                                                                 
            {
                case 1:                                                                                         //menu 1 : search flight
                    flightManager.clearSearch();
                    System.out.print("Enter your origin location : ");                                          //get origin location
                    originLocation = ch.nextLine();

                    System.out.print("Enter your destination location : ");                                     //get destination location
                    destinationLocation = ch.nextLine();
                    System.out.print("Enter your traveling date inform[dd/mm/yyyy] : ");                        //get date
                    String tempDate = ch.nextLine();
                    try                                                                                         
                    {
                        date = df.parse(tempDate);                                                              //try parse string to date
                    }  
                    catch (ParseException error) 
                    {
                        // TODO Auto-generated catch block
                        error.printStackTrace();
                    }
                    System.out.print("Enter number of passenger : ");                                           //get number of passenger
                    noPassenger = in.nextInt();
                    System.out.println(noPassenger);
                    searchFlight = flightManager.searchFlight(originLocation,destinationLocation,date,noPassenger);         //search flight
                    if(searchFlight == null)
                    {
                        break;
                    }

                    selectFlight = flightManager.selectFlight();                                                //get selected flight

                    if(selectFlight == null)
                    {
                        break;
                    }

                    reservationManager.createReservation(selectFlight, noPassenger);                            //create reservation
                    break;
                case 2 : 
                    System.out.println("----------- Search Reservation -----------");                           //menu 2 : search reservation
                    System.out.println("Enter Reservation id : ");                                              //get input reservation id
                    id = ch.nextLine();                                                 
                    allReservation.showReservation(id);                                                         //search and show reservation
                    break;
                case 3 :                                                                
                    System.out.println("----------- Cancl Reservation -----------");                            //menu 3 : cancel reservation
                    System.out.println("Enter Reservation id : ");                                              //get input reservation id
                    id = ch.nextLine();
                    boolean cancel = allReservation.cancelReservation(id);                                      //search and cancel reservation
                    break;
            }

            System.out.println("------------------------------------------");

        }while(selectMenu != 0);
        
        
    }

    // protected static int getOneInteger(String prompt)
    //    {
    //    int value = 0;	   
    //    String inputString;
    //    int readBytes = 0;
    //    byte buffer[] = new byte[200]; 
    //    System.out.print(prompt);
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
    //        value = Integer.parseInt(inputString);
	//    }
    //    catch (NumberFormatException nfe) 
    //        {
	//    System.out.println("Bad number entered - Exiting");
	//    System.exit(1);
    //        }
    //    return value;
    //    }

    //    protected static String getString(String prompt)
    //    {
    //    int value = 0;	   
    //    String inputString;
    //    int readBytes = 0;
    //    byte buffer[] = new byte[200]; 
    //    System.out.print(prompt);
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