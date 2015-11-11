package domini;

/**
 * Created by josep on 11/11/15.
 */
public class TaulerHidato extends Tauler {
    private Cella[][] tauler;
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
        return (tauler[y][x].estaVacia());
    }
    public boolean isBlocked(int x, int y) {
        return (tauler[y][x].estaBloqueada());
    }
    public void setNumber(int x, int y, int val) {
        tauler[y][x].setNumero(val);
    }
    public void setBlocked(int x, int y) {
        tauler[y][x].bloquear();
    }

}
