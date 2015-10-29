package domini;

//////////////////////////////
//
// User
//
// Representacio d'un usuari de la aplicacio
// Nomes considera usuaris amb nom identificatiu (únic) i password
//
//////////////////////////////

public class User {
    //PRIVATE ATTRIBUTES
    protected String username;
    protected String password;

    //PUBLIC METHODS

    // Constructor per defecte
    // Construeix un usuari buit
    public User()
    {
    	username = null;
    	password = null;
    }

    // Constructor amb parametres
    // Construeix un usuari amb username=usr i password=pwd
    public User(String usr, String pwd)
    {
        username = usr; //fer servir clone?
        password = pwd;
    }
    
    // Retorna el nom de l'usuari i null si l'usuari es buit
    public final String getUsername()
    {
        return username;
    }
    
    // Retorna la password de l'usuari i null si l'usuari es buit
    public final String getPassword()
    {
        return  password;
    }
    
    // Canvia la password de l'usuari per pwd
    public final void setPassword(String pwd)
    {
        password = pwd;
    }
    
    // Retorna cert si pwd es igual a la password de l'usuari
    // Retorna fals en cas contrari
    // Retorna fals si l'usuari es buit
    public final boolean testPassword(String pwd) {
        return username != null && password.equals(pwd);
    }

    // Retorna cert si l'usuari te password diferent a null 
    // Retorna fals en cas contrari
    public final boolean tePassword()
    {
        return password != null;
    }
}
