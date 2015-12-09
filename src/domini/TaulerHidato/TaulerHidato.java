package domini.TaulerHidato;

import java.util.ArrayList;

public class TaulerHidato implements Cloneable {
    private Cella[][] tauler;
    private int width;
    private int height;
    private String autor;

    public TaulerHidato(int n, int m, String a, ArrayList<Integer> t){
        this.height = n;
        this.width = m;
        this.autor = a;
        tauler = new Cella[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                Cella c = new Cella(i,j);
                c.setNumero(t.get(i*m+j));
                this.tauler[i][j] = c;
            }
        }
    }

    public TaulerHidato(int n, int m) {
        this.height = n;
        this.width = m;
        this.autor = "maquina";
        this.tauler = new Cella[n][m];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
               this.tauler[i][j] = new Cella(i,j);
            }
        }
    }

    public TaulerHidato clone() {
      TaulerHidato cloned = null;
      try {
        cloned = (TaulerHidato) super.clone();
        /*cloned.setAncho(width);
        cloned.setAlto(height);
        for (int i = 0; i < height; i++) {
          for (int j = 0; j < width; j++) {
            if (tauler[i][j].estaBloqueada()) cloned.setBlock(i,j);
            if (tauler[i][j].estaFija()) cloned.setFixed(i,j);
            else {
              cloned.setNumero(i, j, tauler[i][j].getNumero());
              cloned.getCella(i, j).setXeY(i, j);
            }
          }
        }*/
      } catch (CloneNotSupportedException e) {
        e.printStackTrace();
      }
      return cloned;
    }
    public ArrayList<Integer> getTauler(){
        ArrayList<Integer> r = new ArrayList<>();
        for (int i = 0; i < height; ++i){
            for (int j = 0; j < width; ++j ){
                r.add(i*width+j,getNumero(i,j));
            }
        }
        return r;
    }

    public Cella getCella(int i, int j) {
        return this.tauler[i][j];
    }

    public void setCella(int i, int j, Cella c) {
        this.tauler[i][j] = c;
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

    public  boolean estaFija(int i, int j) { return (this.tauler[i][j].estaFija()); }

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

    public void printTauler() {
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

    public String getAutor() { return autor; }

    public void setAutor(String s) { autor = s; }

    public void setAncho(int ancho) {
      this.width = ancho;
    }

    public void setAlto(int alto) {
      this.height = alto;
    }
}
