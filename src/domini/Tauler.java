package domini;

import java.util.*;
import excepciones.*;

public class Tauler {

	public Tauler(int m, int n) {
		try {
			if (m <= 0 || n <= 0) throw (new ExcepcionTamanoIncorrecto());
			ancho = m; alto = n;
			creaCeldasConPosicion();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public int getAlto() {
		return alto;
	}
	
	public int getNumCeldas() {
		return ancho*alto;
	}
	
	public int getNumCeldasRellenas() {
		int cont = 0;
		for (int i = 0; i < alto*ancho; ++i) {
			if (!vCellas.get(i).estaVacia()) ++cont;
		}
		return cont;
	}
	
	
	public Cella getCella(int x, int y) {
		try {
			if ((x < 0 || x >= alto) || (y < 0 || y >= ancho)) throw (new ExcepcionPosicionFueraRango());
			return vCellas.get(x*ancho + y);
		} catch (ExcepcionPosicionFueraRango e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public int getNumero(int x, int y) {
		try {
			if ((x < 0 || x >= alto) || (y < 0 || y >= ancho)) throw (new ExcepcionPosicionFueraRango());
			return vCellas.get(x*ancho + y).getNumero();
		} catch (ExcepcionPosicionFueraRango e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}
	
	public boolean estaVacia(int x, int y) {
		try {
			if ((x < 0 || x >= alto) || (y < 0 || y >= ancho)) throw (new ExcepcionPosicionFueraRango());
			return vCellas.get(x*ancho + y).estaVacia();
		} catch (ExcepcionPosicionFueraRango e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean estaFija(int x, int y) {
		try {
			if ((x < 0 || x >= alto) || (y < 0 || y >= ancho)) throw (new ExcepcionPosicionFueraRango());
			return vCellas.get(x*ancho + y).estaFija();
		} catch (ExcepcionPosicionFueraRango e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean estaBloqueada(int x, int y) {
		try {
			if ((x < 0 || x >= alto) || (y < 0 || y >= ancho)) throw (new ExcepcionPosicionFueraRango());
			return vCellas.get(x*ancho + y).estaBloqueada();
		} catch (ExcepcionPosicionFueraRango e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public void setNumero(int x, int y, int val) {
		try {
			if ((x < 0 || x >= alto) || (y < 0 || y >= ancho)) throw (new ExcepcionPosicionFueraRango());
			if (val < 0) throw (new ExcepcionValorFueraRango()); //FALTA: mirar valor por arriba
			if (vCellas.get(x*ancho + y).estaFija()) throw (new ExcepcionNumeroFijo());
			if (vCellas.get(x*ancho + y).estaBloqueada()) throw (new ExcepcionCasillaBloqueada());
			vCellas.get(x*ancho + y).setNumero(val);
		} catch (ExcepcionPosicionFueraRango e) {
			System.out.println(e.getMessage());
		} catch (ExcepcionValorFueraRango e) {
			System.out.println(e.getMessage());
		} catch (ExcepcionNumeroFijo e) {
			System.out.println(e.getMessage());
		} catch (ExcepcionCasillaBloqueada e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void borra(int x, int y) {
		try {
			if ((x < 0 || x >= alto) || (y < 0 || y >= ancho)) throw (new ExcepcionPosicionFueraRango());
			if (vCellas.get(x*ancho + y).estaFija()) throw (new ExcepcionNumeroFijo());
			if (vCellas.get(x*ancho + y).estaBloqueada()) throw (new ExcepcionCasillaBloqueada());
			vCellas.get(x*ancho + y).borra();
		} catch (ExcepcionPosicionFueraRango e) {
			System.out.println(e.getMessage());
		} catch (ExcepcionNumeroFijo e) {
			System.out.println(e.getMessage());
		} catch (ExcepcionCasillaBloqueada e) {
			System.out.println(e.getMessage());
		}
	}

	/*private void creaCeldasVacias() {
    	vCellas = new Vector<Cella>();
        Cella cellaAux = null;
        for (int i = 0; i < ancho * alto; ++i) {
            cellaAux = new Cella();
            vCellas.addElement(cellaAux);
        }
    }*/
	
	private void creaCeldasConPosicion() {
    	vCellas = new Vector<Cella>();
        Cella cellaAux = null;
        for (int i = 0; i < alto; ++i) {
        	for (int j = 0; j < ancho; ++j) {
        		cellaAux = new Cella(i, j);
                vCellas.addElement(cellaAux);
        	}
        }
    }
	
	private int ancho, alto;
	private Vector<Cella> vCellas;
	
}
