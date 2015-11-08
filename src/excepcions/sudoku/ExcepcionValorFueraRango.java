package excepcions.sudoku;

public class ExcepcionValorFueraRango extends Exception {
	public static final long serialVersionUID = 45L;

	@Override
	public String getMessage() {
		return "El valor esta fuera del rango permitido";
	}
}
