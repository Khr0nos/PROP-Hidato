package capaDomini;

import excepciones.*;

public class Cella {
	public Cella() {
		numero = x = y = -1;
		fija = false;
		bloqueada = false;
	}
	
	public Cella(int x, int y) {
		numero = -1;
		this.x = x;
		this.y = y;
		fija = false;
		bloqueada = false;
	}
	
	// si la celda está vacía, devuelve -1
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int val) {
		try {
			if(fija) throw (new ExcepcionNumeroFijo());
			numero = val;
		}
		catch (ExcepcionNumeroFijo e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean estaVacia() {
		return numero==-1;
	}
	
	public void borra() {
		try {
			if(fija) throw (new ExcepcionNumeroFijo());
			numero = -1;
		}
		catch (ExcepcionNumeroFijo e) {
			System.out.println(e.getMessage());
		}
	}
	

	public void fijar() {
		try {
			if(numero == -1) throw (new ExcepcionCasillaVaciaNoFijable());
			fija = true;
		} catch (ExcepcionCasillaVaciaNoFijable e) {
			System.out.println(e.getMessage());
		}
	}
	
	// comprobar
	public void liberar() {
		fija = false;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int pos) {
		try {
			if(x != -1 && y != -1) throw (new ExcepcionCasillaYaTienePosicion());
			x = pos;
		} catch (ExcepcionCasillaYaTienePosicion e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void setY(int pos) {
		try {
			if(x != -1 && y != -1) throw (new ExcepcionCasillaYaTienePosicion());
			y = pos;
		} catch (ExcepcionCasillaYaTienePosicion e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void setXeY(int x, int y) {
		try {
			if(x != -1 && y != -1) throw (new ExcepcionCasillaYaTienePosicion());
			this.x = x;
			this.y = y;
		} catch (ExcepcionCasillaYaTienePosicion e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean estaFija() {
		return fija;
	}
	
	public boolean estaBloqueada() {
		return bloqueada;
	}
	
	public void bloquear() {
		bloqueada = true;
	}
	
	private int numero;
	private boolean fija;
	private boolean bloqueada;
	private int x;
	private int y;
}