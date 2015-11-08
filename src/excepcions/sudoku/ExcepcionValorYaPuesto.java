package excepcions.sudoku;

public class ExcepcionValorYaPuesto extends Exception {
	public static final long serialVersionUID = 46L;

	@Override
	public String getMessage() {
		return "El valor ya esta puesto en una de sus regiones";
	}
}
