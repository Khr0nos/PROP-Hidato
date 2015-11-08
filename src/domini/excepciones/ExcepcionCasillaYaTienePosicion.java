package excepciones;

public class ExcepcionCasillaYaTienePosicion extends Exception{
	public static final long serialVersionUID = 50L;

	@Override
	public String getMessage() {
		return "esta casilla ya tiene posicion y no se puede modificar";
	}
}
