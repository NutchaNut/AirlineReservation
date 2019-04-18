import java.util.Date;

public class Passenger{

    private String name;
    private String lastName;
    private String passportId;
    private Date birthday;
    private String gender;
    private String phoneNumber;
    private String email;

    Passenger(String name, String lastName,String passportId, Date birthday, String gender, String phoneNumber, String email){
        this.name = name;
        this.lastName = lastName;
        this.passportId = passportId;
        this.birthday = birthday;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    
}