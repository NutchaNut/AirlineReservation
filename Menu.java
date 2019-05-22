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

/*
 * Menu
 * 
 *      This is main class for running program
 *      
 *      Created by Nutcha Suwannayik (Nut) 59070501021
 *      18 April 2019
 */

public class Menu 
{
    /*store string of originLocation */                                                        
    private static String originLocation;
    /*store string of destinationLocation */                                                        
    private static String destinationLocation;
    /*store date to search flight */                                                        
    private static Date date;
    /*store integer of passenger */                                                        
    private static int noPassenger;
    /*instance of ReservationManager*/                                                        

    public static void main(String[] args) 
    {
        /*scanner for input data*/                                                        
        Scanner ch = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        /*selectMenu for choose menu*/                                                        
        int selectMenu = 0;
        String id;
        /*date input format*/                                                        
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        /*instance of FlightManager*/                                                        
        FlightManager flightManager = new FlightManager();
        /*instance of ReservationManager*/                                                        
        ReservationManager reservationManager = new ReservationManager();
        /*instance of OperateFlight use for selectedFlight*/                                                        
        OperateFlight selectFlight = null;
        /*Arraylist of searched flight*/                                                        
        ArrayList<OperateFlight> searchFlight = new ArrayList<OperateFlight>();

        /**innitialize flight */
        flightManager.initialize();

        /**Loop menu */
        System.out.println("welcome to airline reservation program");
        do                                                                                                      
        {
            System.out.println("---------------------------------------");                                      
            System.out.println("menu : ");
            System.out.println("1 Search Flight");
            System.out.println("2 Search Reservation");
            System.out.println("3 Cancl Reservation");
            System.out.println("0 Exit");
            System.out.println("---------------------------------------");
            System.out.print("Enter menu : ");                                                                  
            selectMenu = in.nextInt();
            System.out.flush();
            /**choose menu */
            switch (selectMenu)                                                                                 
            {
                /**menu 1 : search flight */
                case 1:                                                                                         
                    flightManager.clearSearch();
                    /** get origin location */
                    System.out.print("Enter your origin location : ");                                          
                    originLocation = ch.nextLine();

                    /** get destination location */
                    System.out.print("Enter your destination location : ");                                     
                    destinationLocation = ch.nextLine();

                    /** get date */
                    System.out.print("Enter your traveling date inform[dd/mm/yyyy] : ");                        
                    String tempDate = ch.nextLine();

                    String checkDate[] = tempDate.split("/");
                    int day = Integer.parseInt(checkDate[0]);
                    int month = Integer.parseInt(checkDate[1]);
                    
                    if((31<day) || (12<month))
                    {
                        System.out.println("Your itinerary date is impossible");
                        break;
                    }

                    /**try parse string to date */
                    try                                                                                         
                    {
                        date = df.parse(tempDate);                                                              
                    }  
                    catch (ParseException error) 
                    {
                        // TODO Auto-generated catch block
                        error.printStackTrace();
                    }
                    
                    /**get number of passenger */
                    System.out.print("Enter number of passenger : ");                                           
                    noPassenger = in.nextInt();
                    System.out.println(noPassenger);
                    /**search flight */
                    searchFlight = flightManager.searchFlight(originLocation,destinationLocation,date,noPassenger);         
                    
                    if(searchFlight == null)
                    {
                        break;
                    }

                    /**get selected flight*/
                    selectFlight = flightManager.selectFlight();                                                

                    if(selectFlight == null)
                    {
                        break;
                    }

                    /**create reservation*/
                    reservationManager.createReservation(selectFlight, noPassenger);                            
                    break;
                /** menu 2 : search reservation */
                case 2 : 
                    System.out.println("----------- Search Reservation -----------"); 
                    /**get input reservation id */                         
                    System.out.println("Enter Reservation id : ");                                              
                    id = ch.nextLine();              
                    /**search and show reservation */                                   
                    reservationManager.showReservation(id);                                                         
                    break;
                /*menu 3 : cancel reservation*/
                case 3 :                                                                
                    System.out.println("----------- Cancl Reservation -----------");   
                    /*get input reservation id*/                      
                    System.out.println("Enter Reservation id : ");                                             
                    id = ch.nextLine();
                    /**search and cancel reservation */
                    boolean cancel = reservationManager.cancelReservation(id);                                      
                    break;
            }

            System.out.println("------------------------------------------");

        }while(selectMenu != 0);
        
        
    }
    
}