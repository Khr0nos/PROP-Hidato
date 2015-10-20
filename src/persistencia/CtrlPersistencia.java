package persistencia;

import java.lang.String;
import java.util.ArrayList;

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
// Els arxius amb dades es troben en un directori concret
//
// Si en alguna operacio ha sorgit un error:
//   Una variable de control ho registrara
//   S'escriura un missatge explicatiu
//
// Les taules no han de seguir un format concret pero s'aconsella que el
// primer registre tingui un nom identifictiu per cada columna
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
    //PRIVATE ATTRIBUTES
    private boolean error; // indica si hi ha hagut cap error durant la ultima operacio

    //PUBLIC METHODS

    //Public constructor
    public CtrlPersistencia()
    {
        error = false;
    }
    
    // Carrega les dades de l'arxiu a path
    // Si no es troba l'arxiu retorna null
    public ArrayList<ArrayList<String>> loadTable(String path)
    {
    	return null;
    }
    
    // Guarda les dades a table a l'arxiu a path
    // Si no es troba l'arxiu a path se'n crea un de nou
    // Si es troba l'arxiu a path se sobrescriura
    public void storeTable(ArrayList<ArrayList<String>> table, String path)
    {
    }
    
    // Retorna true si hi ha hagut cap error a l'ultima operacio
    // Retorna false altrament
    public boolean getError()
    {
    	return error;
    }
}
