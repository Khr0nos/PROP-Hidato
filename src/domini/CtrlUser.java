package domini;

import persistencia.CtrlPersistencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

//////////////////////////////
//
// CtrlUser
//
// Agregacio de Usuaris
// Permet gestionar usuaris
//
// Es considera que el nom d'usuari es unic
// Els usuaris s'ordenen per nom per raons d'eficiencia
// Es considera que els usuaris es troben a la taula "users"
// amb el format aconsellat a CtrlPersistencia
//
//////////////////////////////

public class CtrlUser
{
	private static boolean dirty;             // true si s'ha modificat la llista d'usuari
	protected static ArrayList<User> usuaris; // ordenats per nom
	
	// Carrega els usuaris de la BD
	// si hi ha hagut error al carregar els usuaris llença una excepcio
	protected static void carrega() throws Exception
    {
        try {
            ArrayList<ArrayList<String>> users = CtrlPersistencia.loadTable("users");  //cal definir el path!
            for (ArrayList<String> fila : users)
            {
                String nom = fila.get(0);
                String pwd = fila.get(1);
                usuaris.add(new User(nom, pwd));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	// Codifica els usuaris en el format que es guardaran a la BD
	protected static ArrayList<ArrayList<String>> codifica()
    {
        ArrayList<ArrayList<String>> users = new ArrayList<ArrayList<String>>();
        try {
            for (User us : usuaris) {
                ArrayList<String> fila = new ArrayList<String>();
                fila.add(us.getUsername());
                fila.add(us.getPassword());
                users.add(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

	// Constructor per defecte
	// Inicialitza l'agregacio
	public CtrlUser() throws Exception {
		dirty = false;
		try {
            carrega();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	// Si en el moment de desalocar la instancia s'han modificat les dades carregades des de la BD, desar els canvis 	
	public void finalize()
	{
        try {
            super.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        if (dirty)
		{
			try {
				CtrlPersistencia.storeTable("users", codifica());  //cal definir el path!
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Retorna l'Usuari amb username igual a nom
	// Retorna null si no el troba
	public static User getUsuari(String nom)
    {
        for (User usuari : usuaris) {
            if (Objects.equals(usuari.getUsername(), nom)) return usuari;
        }
        return null;
    }
	
	// Afegeix l'Usuari us a l'agregat
	// Retorna fals si hi ha hagut cap error i llença excepció o bé si l'usuari ja hi és i no es pot afegir
	public static boolean afegeixUsuari(User us) throws Exception
    {
        boolean ret = false;
        try {
            if (!usuaris.contains(us)) {
                ret = usuaris.add(us);
            }
            dirty = ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
	
	// Esborra l'Usuari amb username nom de l'agregat
	// Retorna false si hi ha hagut cap error i llença excepció
	public static boolean esborraUsuari(String nom) throws Exception
    {
        boolean ret = false;
        try {
            for (User usuari : usuaris) {
                if (Objects.equals(usuari.getUsername(), nom)) ret = usuaris.remove(usuari);
            }
            dirty = ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
