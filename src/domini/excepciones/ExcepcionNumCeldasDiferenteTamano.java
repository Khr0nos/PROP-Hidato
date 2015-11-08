package excepciones;

public class ExcepcionNumCeldasDiferenteTamano extends Exception {
	public static final long serialVersionUID = 42L;

	@Override
	public String getMessage() {
		return "El numero de celdas recibidas es diferente al tamano";
	}
	
}
