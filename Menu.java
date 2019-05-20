import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Menu {

    private Reservation reserve;
    private static String originLocation;
    private static String destinationLocation;
    private static Date date;
    private static int noPassenger;

    private static ReservationManager allReservation;

    private static int menu()
    {   
        int selectMenu = 0;
        Scanner in = new Scanner(System.in);
        
        System.out.println("---------------------------------------");
        System.out.println("menu : ");
        System.out.println("1 Search Flight");
        System.out.println("2 Search Reservation");
        System.out.println("3 Cancl Reservation");
        System.out.println("0 Exit");
        System.out.println("---------------------------------------");
        System.out.println("Enter menu : ");
        selectMenu = in.nextInt();
        System.out.flush();

        return selectMenu;
    }
    public static void main(String[] args) 
    {

        Scanner in = new Scanner(System.in);
        int selectMenu = 0;
        String id;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        FlightManager managerFlight = new FlightManager();
        OperateFlight selectFlight = null;
        ReservationManager managerReservation = new ReservationManager();

        managerFlight.initialize();

        System.out.println("welcome to airline reservation program");
        do 
        {   selectMenu = menu();

            switch (selectMenu) 
            {
                case 1:
                    System.out.println("Enter your origin location");
                    originLocation = in.nextLine();
                    System.out.println("Enter your destination location");
                    destinationLocation = in.nextLine();
                    System.out.println("Enter your traveling date inform[dd/mm/yyyy]");
                    String tempDate = in.nextLine();
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
                    selectFlight = managerFlight.searchFlight(originLocation,destinationLocation,date,noPassenger);
                    if(selectFlight == null)
                    {
                        break;
                    }
                    managerReservation.createReservation(selectFlight, noPassenger);
                    break;
                case 2 : 
                    System.out.println("----------- Search Reservation -----------");
                    System.out.println("Enter Reservation id : ");
                    id = in.nextLine();
                    allReservation.showReservation(id);
                    break;
                case 3 : 
                    System.out.println("----------- Cancl Reservation -----------");
                    System.out.println("Enter Reservation id : ");
                    id = in.nextLine();
                    allReservation.cancelReservation(id);
                    break;
            }

            System.out.println("------------------------------------------");

        }while(selectMenu != 0);
        
        in.close();
    }
    
}