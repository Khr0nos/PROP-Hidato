package domini.FabricaHidato;

import domini.JocHidato.tipoDificultad;
import domini.TaulerHidato.Cella;
import domini.TaulerHidato.CtrlTauler;
import domini.TaulerHidato.TaulerHidato;

import java.util.ArrayList;
import java.util.Random;

public class FabricaHidato {
  private static Graf G;
  private static int num;

  public FabricaHidato() {
    G = new Graf();
    num = 0;
  }

  public FabricaHidato(int x, int y) {
    G = new Graf(x,y);
    num = 0;
  }

  public static void genera_hidato(int m, int n, tipoDificultad lvl, String id) throws Exception {
    Random rng = new Random();

    int N = n*m;
    G = new Graf(n,m);

    // Generació de solució d'Hidato
    ArrayList<Cella> cami = new ArrayList<Cella>();
    int k;
    do {
      int aux = rng.nextInt(N);
      G.setValor(aux,1);
      ArrayList<Cella> adj;
      adj = G.getAdjVer(G.getVertex(aux));
      k = 2;
      while (k <= N && adj.size() > 0) {
        for (int i = adj.size() - 1; i >= 0; i--) {
          Cella c = adj.get(i);
          if (c.getNumero() != 0) adj.remove(c);
        }
        if (adj.size() > 0) {
          aux = rng.nextInt(adj.size());
          Cella step = G.getVertex(adj.get(aux));
          step.setNumero(k);
          adj = G.getAdjVer(step);
          cami.add(step);
          ++k;
        }
      }
      if (k <= N/3) G.clear();
    } while (k <= N/3);                     // N/3 com a factor d'ocupació mínima
    cami.remove(cami.size()-1);             // per a no posar a 0 últim element del Hidato al tauler inicial

    /*int j = 1;
    for (Cella c: G.getVertexs()) {           // per a mostrar per sortida estandard la solucio
      System.out.print(c.getNumero() + " ");
      if (j%m == 0) System.out.println();
      ++j;
    }
    System.out.println();*/

    for (Cella c: G.getVertexs()) {
      if (c.getNumero() == 0) c.setNumero(-1);
    }

    TaulerHidato t = new TaulerHidato(m,n);
    copia(G, t);
    CtrlTauler.guardaTauler(t,"solucio" + id + Integer.toString(num));

    //Generació de tauler inicial
    int n_del;
    if (lvl == tipoDificultad.facil) n_del = k/3;
    else if (lvl == tipoDificultad.medio) n_del = k/2;
    else n_del = (2*k)/3;

    while (n_del > 0) {
      Cella c = cami.get(rng.nextInt(cami.size()));
      if (G.getVertex(c).getNumero() != 0) {
        G.getVertex(c).setNumero(0);
        --n_del;
      }
    }

    copia(G, t);
    CtrlTauler.guardaTauler(t,id + Integer.toString(num));

    ++num;  // identificador per a la solució i tauler inicial seguents
  }

  private static void copia(Graf G, TaulerHidato t) {
    int k = 0;
    for(int i = 0; i < t.getAlto(); i++) {
      for(int j = 0; j < t.getAncho(); j++) {
        t.setCella(i,j,G.getVertex(k));
        ++k;
      }
    }
  }

}
