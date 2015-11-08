package excepciones;


public class ExcepcionPosicionFueraRango extends Exception {
	public static final long serialVersionUID = 44L;
	
	@Override
	public String getMessage() {
		return "La posicion esta fuera del rango permitido";
	}
}
