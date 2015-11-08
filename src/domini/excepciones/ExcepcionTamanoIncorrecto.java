package excepciones;

public class ExcepcionTamanoIncorrecto extends Exception{
	public static final long serialVersionUID = 47L;

	@Override
	public String getMessage() {
		return "Este tamano no es valido";
	}
}
