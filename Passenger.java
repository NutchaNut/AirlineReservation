import java.util.Date;

public class Passenger
{
    //data for passenger
    private String name;
    private String lastName;
    private String passportId;
    private String birthday;
    private String gender;
    private String phoneNumber;
    private String email;

    //constructor
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

    //print passenger
    public void printPassenger()
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