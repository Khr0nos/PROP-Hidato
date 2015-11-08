package excepciones;

public class ExcepcionCasillaBloqueada extends Exception{
	public static final long serialVersionUID = 49L;

	@Override
	public String getMessage() {
		return "Casilla bloqueada no modificable";
	}
}
