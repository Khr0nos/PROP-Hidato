package domini;

import persistencia.CtrlPersistencia;

import java.io.IOException;
import java.util.ArrayList;

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
	private boolean dirty; // true si s'ha modificat la llista d'usuari
	protected ArrayList<User> usuaris; // ordenats per nom
	
	// Carrega els usuaris de la BD
	// si hi ha hagut error al carregar els usuaris tira una excepcio
	protected void carrega() {}
	
	// Codifica els usuaris en el format que es guardaran a la BD
	protected ArrayList<ArrayList<String>> codifica() { return null; }

	// Constructor per defecte
	// Inicialitza l'agregacio
	public CtrlUser()
	{
		dirty = false;
		carrega();
	}

	// Si en el moment de desalocar la instancia s'han modificat les dades carregades des de la BD, desar els canvis 	
	public void finalize()
	{
		if (dirty)
		{
			CtrlPersistencia bd = new CtrlPersistencia();
			try {
				bd.storeTable("users", codifica());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Retorna l'Usuari amb usarname igual a nom
	// Retorna null si no el troba
	public User getUsuari(String nom) { return null; }
	
	// Afegeix l'Usuari us a l'agregat
	// Retorna fals si hi ha hagut cap error i printa un missatge explicatiu
	public boolean afegeixUsuari(User us) { return false; }
	
	// Esborra l'Usuari us de l'agregat
	// Retorna false si hi ha hagut cap error i printa un missatge explicatiu
	public boolean esborraUsuari(String nom) { return false; }
}
