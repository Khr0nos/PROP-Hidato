package domini;

public class TaulerHidato extends Tauler {
    private Cella[][] tauler;
    private int width;
    private int height;

    public TaulerHidato(int w, int h) {
        this.width = w;
        this.height = h;
        this.tauler = new Cella[h][w];
        for(int i = 0; i < w; ++i) {
            for(int j = 0; j < h; ++j) {
               this.tauler[j][i] = new Cella(i,j);
            }
        }
    }

    public Cella getCella(int i, int j) {
        return this.tauler[i][j];
    }

    public int getAncho() {
        return this.width;
    }

    public int getAlto() {
        return this.height;
    }

    public int getNumero(int i, int j) {
        return this.tauler[i][j].getNumero();
    }

    public boolean estaVacia(int i, int j) {
        return (this.tauler[i][j].getNumero() == 0);
    }

    public boolean estaBloqueada(int i, int j) {
        return (this.tauler[i][j].estaBloqueada());
    }

    public void setNumero(int i, int j, int val) {
        if (val == -1) tauler[i][j].bloquear();
        else this.tauler[i][j].setNumero(val);
    }

    public void setBlock(int i, int j) {
        this.tauler[i][j].bloquear();
    }

    public void setFixed(int i, int j) {
        this.tauler[i][j].fijar();
    }

    public void print() {
        for(int i = 0; i < this.height; ++i) {
            String s = "";
            for(int j = 0; j < this.width; ++j) {
                if(this.tauler[i][j].estaBloqueada()) s += "-1 ";
                else if(this.tauler[i][j].estaVacia()) s += "0 ";
                else s += this.tauler[i][j].getNumero() + " ";
            }
            System.out.println(s);
        }
    }
}
