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

    public TaulerHidato(int n, int m, String usr) {
        this.height = n;
        this.width = m;
        this.autor = usr;
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

    public void setNotFixed(int i, int j){this.tauler[i][j].liberar();}

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

    private boolean teAdjacent(int x, int y, int value)
    {
        int nx[] = {-1, 0, 1, -1, 1, -1, 0, 1};
        int ny[] = {-1, -1, -1, 0, 0, 1, 1, 1};

        for (int k = 0; k < 8; ++k)
        {
            int posx = x + nx[k];
            int posy = y + ny[k];
            if (posx >= 0 && posx < width && posy >= 0 && posy < height)
            {

                if (tauler[posy][posx].getNumero() == value) return true;
            }
        }

        return false;
    }

    private int seguentX(int x, int y)
    {
        int value = tauler[y][x].getNumero();

        int nx[] = {-1, 0, 1, -1, 1, -1, 0, 1};
        int ny[] = {-1, -1, -1, 0, 0, 1, 1, 1};

        for (int k = 0; k < 8; ++k)
        {
            int posx = x + nx[k];
            int posy = y + ny[k];
            if (posx >= 0 && posx < width && posy >= 0 && posy < height)
            {
                if (tauler[posy][posx].getNumero() == value-1) return posx;
            }
        }

        return -1;
    }

    private int seguentY(int x, int y)
    {
        int value = tauler[y][x].getNumero();

        int nx[] = {-1, 0, 1, -1, 1, -1, 0, 1};
        int ny[] = {-1, -1, -1, 0, 0, 1, 1, 1};

        for (int k = 0; k < 8; ++k)
        {
            int posx = x + nx[k];
            int posy = y + ny[k];
            if (posx >= 0 && posx < width && posy >= 0 && posy < height)
            {
                //System.out.println(posx);
                //System.out.println(posy);
                if (tauler[posy][posx].getNumero() == value-1) return posy;
            }
        }

        return -1;
    }

    public boolean solved() {
        int maxim = 1;
        int posx = 0, posy = 0;

        // Encontrar posicion de la primera celda (estaria guay tener un atributo de la clase que lo tuviera)
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                int valor = tauler[i][j].getNumero();
                if (valor > maxim)
                {
                    maxim = valor;
                    posx = j;
                    posy = i;
                }
            }
        }

        while (maxim != 1)
        {
            //System.out.println(maxim);

            boolean noAdj = false;
            int valor;
            //System.out.println(posy);

            valor = tauler[posy][posx].getNumero();
            //System.out.println(valor);
            noAdj = teAdjacent(posx, posy, valor - 1);
            if (!noAdj) return false;

            int auxposx = seguentX(posx, posy);
            int auxposy = seguentY(posx, posy);
            System.out.println("posicio");
            System.out.println(posx);
            System.out.println(posy);
            posx = auxposx;
            posy = auxposy;
            --maxim;
        }
        return true;
    }
}
