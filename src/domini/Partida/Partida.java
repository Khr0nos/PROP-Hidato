package domini.Partida;

import domini.Algorismes.Algorismes;
import domini.JocHidato.JocHidato;
import domini.TaulerHidato.TaulerHidato;

public class Partida {
    private String user;
    private JocHidato joc;
    private Time time;
    private int pistes;

    //private TaulerHidato original;
    private TaulerHidato modificat;
    private TaulerHidato solucio = null;

    private boolean solucionat = false;

    public Partida()
    {
        user = null;
        joc = null;
        time = null;
        pistes = 0;
    }

    public Partida(String u, JocHidato j)
    {
        user = u;
        joc = j;
        pistes = 0;
        time = new Time();
        time.start();

        //original = joc.getTauler();
        modificat = joc.getTauler();
        solucio = Algorismes.solve(modificat);
    }

    // Constructor usat per ctrlPartida
    public Partida(String u, JocHidato j, TaulerHidato m, double pre_time, int hints) {
        user = u;
        joc = j;
        pistes = hints;
        time = new Time(pre_time);
        time.start();

        //original = joc.getTauler();
        modificat = joc.getTauler();
        solucio = Algorismes.solve(modificat);
    }

    public void nouValor(int i, int j, int valor)
    {
        //Cella c = modificat.getCella(x, y);
        //c.setNumero(valor);

        modificat.setNumero(i,j,valor);

        solucionat = (modificat.getTauler().equals(solucio.getTauler()));

        if (solucionat)
        {
            time.stop();
        }
    }

    public boolean completat()
    {
        return solucionat;
    }

    public double getTime() {
      return time.getTimeSeconds();
    }

    // Mètodes per al controlador de Partida
    public String getUser() {
      return user;
    }

    public JocHidato getJoc() {
      return joc;
    }

    /*public TaulerHidato getOriginal() {
      return original;
    }*/

    public TaulerHidato getModificat() {
      return modificat;
    }

    public void atura() {
      time.stop();
    }

    public void addPista() {
        ++pistes;
    }

    public int getPistes() {
        return pistes;
    }
}
