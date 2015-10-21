package persistencia;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

//////////////////////////////
//
// CtrlPersistencia
// 
// Permet gestionar dades en arxius
//
// Cada arxiu conte una taula de dades
// Cada taula te diverses entrades
//
// Els arxius els gestiona la mateixa classe
// La ruta als arxius es relativa al directori d'execucio
//
// Cada linia de l'arxiu ha de correspondre a una linia de la taula
// Cada dada de la linia queda separada amb un espai " "
// S'aconsella que el primer registre tingui un nom identifictiu per cada columna
//
// Exemple:
//
// id	nom		password
// 1	josep	pwd1
// 2	fabio	pwd2
// 3	max		pwd3
// 4	xavi	pwd4
//
//////////////////////////////

public class CtrlPersistencia
{
    // Carrega les dades de l'arxiu a path
    // Si no es troba l'arxiu tira una excepcio
    public static ArrayList<ArrayList<String>> loadTable(String path) throws IOException
    {
    	// Generar path a partir del parametre d'entrada
        path = Paths.get(path).toAbsolutePath().toString();
        
        // Array on es guardaran les dades llegides
        ArrayList<ArrayList<String>> resultat = new ArrayList<ArrayList<String>>();
        
        try {
		    BufferedReader reader = new BufferedReader(new FileReader(path));
		    
		    String l = "";
		    ArrayList<String> fila;

			// Llegir linia a linia on cada cella queda separada per sep
		    while ((l = reader.readLine()) != null){
		        String[] fila_aux = l.split(" ");
		        fila = new ArrayList<String>();
		        
		        for (String cella : fila_aux)
		        {
		        	fila.add(cella);
		        }
		        
		        resultat.add(fila);
		    }
		    reader.close();
	    } catch (FileNotFoundException e) {
	    	e.printStackTrace();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	    
        return resultat;
    }
    
    // Guarda les dades a table a l'arxiu a path
    // Si no es troba l'arxiu a path se'n crea un de nou
    // Si es troba l'arxiu a path se sobrescriura
     public static void storeTable(String path, ArrayList<ArrayList<String>> taula) throws IOException
    {
        // Generar path a partir del parametre d'entrada
        path = Paths.get(path).toAbsolutePath().toString();
        
        // Esto parece que crea el file si no existe, pero lo he encontrado por ahi
        File file = new File(path);
        if(!file.exists()) file.getParentFile().mkdirs();
        
        FileWriter writer = new FileWriter(path);
        
        for (ArrayList<String> fila : taula)
        {
		    for (int i = 0; i < fila.size(); ++i)
		    {
		        writer.write(fila.get(i));
		        writer.write("\r\n");
		    }
	    }
        writer.close();
    }
}
