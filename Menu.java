/**
 * Menu
 * 
 *      this class is keeping the main function
 *      and can choose the menu to operate with system functional.
 * 
 *      Created by Nutcha Suwannayik (Nut) ID 59070501021
 */
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

                    String checkDate[] = tempDate.split("/");
                    int day = Integer.parseInt(checkDate[0]);
                    int month = Integer.parseInt(checkDate[1]);
                    
                    if((31<day) || (12<month))
                    {
                        System.out.println("Your itinerary date is impossible");
                        break;
                    }

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

    
}