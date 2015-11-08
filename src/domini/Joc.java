package domini;

public abstract class Joc {
	private tipoDificultad dificultad;
	private String id;
	private Tauler tauler;
	
	public Joc() {
		dificultad = null;
		id = null;
	}
	
	public Joc(int m, int n, tipoDificultad dif, String idJoc) {
		dificultad = dif;
		id = idJoc;
		tauler = new Tauler(m,n);
	}
	
	public Joc(String idJoc, Tauler t) {
		dificultad = null;
		id = idJoc;
		tauler = t;
	}
	
	public Joc(String idJoc, Tauler t, tipoDificultad td) {
		dificultad = td;
		id = idJoc;
		tauler = t;
	}
	
	public String getId() {
		return id;
	}
	
	public tipoDificultad getDificultad() {
		return dificultad;
	}
	
	public void setDificultad(tipoDificultad t) {
		dificultad = t;
	}
	
	public Tauler getTauler() {
		return tauler;
	}
}