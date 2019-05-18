import java.sql.Date;
import java.util.Scanner;

public class Menu {

    private Reservation reserve;
    private String originLocation;
    private String destinationLocation;
    private Date date;

    private static ReservationManager allReservation;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int selectMenu = 0;
        String id;

        System.out.println("welcome to airline reservation program");
        do{
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

            switch(selectMenu){
                case 1 : 
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
        
    }
    
}