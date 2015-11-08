package excepcions.sudoku;

public class ExcepcionCasillaVaciaNoFijable extends Exception{
	public static final long serialVersionUID = 48L;

	@Override
	public String getMessage() {
		return "No se puede fijar una casilla vacia";
	}
}