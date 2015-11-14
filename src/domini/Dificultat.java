package domini;

abstract public class Dificultat {
	private static final String[] d = {"3x3", "4x4", "5x5", "6x6", "7x7", "8x8", "9x9"};
	
	public static boolean esValida(String s) {
		for (int i=0; i<d.length; ++i) {
			if (d[i].equals(s)) return true;
		}
		return false;
	}
	
	public static String[] getAll() {
		return d;
	}
	
	/* La dificultat d és valida */
	public static int toInt(String s) {
		int i = 0;
		boolean trobat = false;
		while (!trobat) {
			if (d[i].equals(s)) trobat = true;
			else ++i;
		}
		return Integer.parseInt(d[i].substring(0,1));
	}
}