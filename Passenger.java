/*
 * Passenger
 * 
 *      This class is creating for instance of passenger
 *      collect passenger detail
 *      
 *      Created by Nutcha Suwannayik (Nut) 59070501021
 *      18 April 2019
 */
public class Passenger
{
     /*store Passenger name */
     private String name;
     /*store Passenger lastName */
     private String lastName;
     /*store Passenger passportId */
     private String passportId;
     /*store Passenger birthday */
     private String birthday;
     /*store Passenger gender */
     private String gender;
     /*store Passenger phoneNumber */
     private String phoneNumber;
     /*store Passenger email */
     private String email;

    /**
    * Construtor to create instance of Passenger.
    * @param  name   Passenger name
    * @param  lastName   Passenger lastName
    * @param  passportId   Passenger passportId
    * @param  birthday   Passenger birthday
    * @param  gender   Passenger gender
    * @param  phoneNumber   Passenger phoneNumber
    * @param  email   Passenger email
     */
    Passenger(String name, String lastName,String passportId, String birthday, String gender, String phoneNumber, String email)
    {
        this.name = name;
        this.lastName = lastName;
        this.passportId = passportId;
        this.birthday = birthday;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * Print Passenger information
     */    public void printPassenger()
    {
        System.out.println("Name : " + name);
        System.out.println("Lastname : " + lastName);
        System.out.println("Passport Id : " + passportId);
        System.out.println("Birthday : " + birthday);
        System.out.println("Gender : " + gender);
        System.out.println("Phone Number : " + phoneNumber);
        System.out.println("Email : " + email);

    }
    
}