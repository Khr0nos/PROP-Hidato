package domini.Partida;

import domini.Algorismes.Algorismes;
import domini.JocHidato.JocHidato;
import domini.TaulerHidato.Cella;
import domini.TaulerHidato.TaulerHidato;
import domini.Usuari.User;

public class Partida {
    private User user;
    private JocHidato joc;
    private Time time;

    private TaulerHidato original;
    private TaulerHidato modificat;
    private TaulerHidato solucio = null;

    private boolean solucionat = false;

    public Partida()
    {
        user = null;
        joc = null;
        time = null;
    }

    public Partida(User u, JocHidato j)
    {
        user = u;
        joc = j;
        time = new Time();
        time.start();

        original = joc.getTauler();
        modificat = original.clone();
        solucio = Algorismes.solve(original);
    }

    // Constructor usat per ctrlPartida
    public Partida(User u, JocHidato j, TaulerHidato m, double pre_time) {
        user = u;
        joc = j;
        time = new Time(pre_time);
        time.start();

        original = joc.getTauler();
        modificat = m;
        solucio = Algorismes.solve(original);
    }

    public void nouValor(int x, int y, int valor)
    {
        Cella c = modificat.getCella(x, y);
        c.setNumero(valor);

        solucionat = (modificat.equals(solucio));

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
    public User getUser() {
      return user;
    }

    public JocHidato getJoc() {
      return joc;
    }

    public TaulerHidato getOriginal() {
      return original;
    }

    public TaulerHidato getModificat() {
      return modificat;
    }

    public void atura() {
      time.stop();
    }
}
