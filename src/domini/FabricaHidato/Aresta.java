package domini.FabricaHidato;

import domini.TaulerHidato.Cella;

import java.util.ArrayList;

/*Classe auxilar per a graf de cel·les d'un tauler*/
public class Aresta {
    private ArrayList<Cella> T;

    public Aresta(Cella x, Cella y) {
      T = new ArrayList<Cella>();
      T.add(x);
      T.add(y);
    }

    public Cella get(int i) {
      return this.T.get(i);
    }

    public boolean contains(Cella c) {
      return T.contains(c);
    }

    public int indexOf(Cella c) {
      return T.indexOf(c);
    }
}
