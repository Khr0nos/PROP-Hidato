import java.lang.String;

public class User {
    //PRIVATE ATTRIBUTES
    private String username;
    private String password;

    //PUBLIC METHODS

    //Public constructor
    public User();

    //Public constructor with parameters. User created has username=usr and password=pwd
    public User(String usr, String pwd) {
        username = usr;
        password = pwd;
    }
    //Returns the username of a User
    public string getUsername() {
        return username;
    }
    //Returns the password of a User
    public string getPassword() {
        return  password;
    }
    //Sets the value of password
    public void setPassword(String pwd) {
        password = pwd;
    }
}