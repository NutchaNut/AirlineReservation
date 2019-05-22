import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class Menu 
{
    private static Reservation reserve;
    private static String originLocation;
    private static String destinationLocation;
    private static Date date;
    private static int noPassenger;

    private static ReservationManager allReservation = null;
    private static FlightManager flightManager = new FlightManager();
    private static ReservationManager reservationManager = new ReservationManager();

    public static void main(String[] args) 
    {
        Scanner ch = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        int selectMenu = 0;
        String id;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
        OperateFlight selectFlight = null;
        ArrayList<OperateFlight> searchFlight = new ArrayList<OperateFlight>();

        flightManager.initialize();

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
            //selectMenu = getOneInteger("Enter menu : ");
            System.out.print("Enter menu : ");
            selectMenu = in.nextInt();
            System.out.flush();

            switch (selectMenu) 
            {
                case 1:
                    flightManager.clearSearch();
                    System.out.print("Enter your origin location : ");
                    originLocation = ch.nextLine();
                    //originLocation = getString("Enter your origin location : ");
                    //System.out.println(originLocation);

                    //destinationLocation = getString("Enter your destination location : ");
                    //System.out.println(destinationLocation);
                    System.out.print("Enter your destination location : ");
                    destinationLocation = ch.nextLine();
                    System.out.print("Enter your traveling date inform[dd/mm/yyyy] : ");
                    String tempDate = ch.nextLine();
                    //String tempDate = getString("Enter your traveling date inform[dd/mm/yyyy] : ");
                    try 
                    {
                        date = df.parse(tempDate);
                    } 
                    catch (ParseException error) 
                    {
                        // TODO Auto-generated catch block
                        error.printStackTrace();
                    }
                    System.out.println("Enter number of passenger");
                    noPassenger = in.nextInt();
                    //noPassenger = getOneInteger("Enter number of passenger : ");
                    System.out.println(noPassenger);
                    searchFlight = flightManager.searchFlight(originLocation,destinationLocation,date,noPassenger);
                    if(searchFlight.isEmpty())
                    {   
                        System.out.println("Can't search your desire flight.");
                        break;
                    }
                    System.out.println();
                    selectFlight = flightManager.selectFlight();

                    if(selectFlight == null)
                    {
                        break;
                    }

                    reservationManager.createReservation(selectFlight, noPassenger);
                    break;
                case 2 : 
                    System.out.println("----------- Search Reservation -----------");
                    System.out.println("Enter Reservation id : ");
                    id = ch.nextLine();
                    allReservation.showReservation(id);
                    break;
                case 3 : 
                    System.out.println("----------- Cancl Reservation -----------");
                    System.out.println("Enter Reservation id : ");
                    id = ch.nextLine();
                    allReservation.cancelReservation(id);
                    break;
                }

            System.out.println("------------------------------------------");

        }while(selectMenu != 0);
            
        in.close();
        ch.close();
    }
        
}