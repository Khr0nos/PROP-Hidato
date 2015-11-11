package domini;

import excepcions.sudoku.*;

import java.util.Vector;

public class TaulerHidato extends Tauler {
    /*private Cella[][] tauler;
    private int width;
    private int height;

    public TaulerHidato(int w, int h) {
        tauler = new Cella[h][w];
        width = w;
        height = h;
    }

    public Cella getCella(int x, int y) {
        return tauler[y][x];
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public int getNum(int x, int y) {
        return tauler[y][x].getNumero();
    }
    public boolean isEmpty(int x, int y) {
        return (tauler[y][x].getNumero() == 0);
    }
    public boolean isBlocked(int x, int y) {
        return (tauler[y][x].estaBloqueada());
    }
    public void setNumber(int x, int y, int val) {
        if (val == -1) tauler[y][x].bloquear();
        else tauler[y][x].setNumero(val);
    }
    public void setBlocked(int x, int y) {
        tauler[y][x].bloquear();
    }*/


    public TaulerHidato(int m, int n) {
        super(m,n);
    }

    public void setNumero(int x, int y, int val) {


    }
}
