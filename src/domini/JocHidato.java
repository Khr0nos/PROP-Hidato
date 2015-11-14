package domini;

public class JocHidato {
  private tipoDificultad dificultad;
  private String id;
  private TaulerHidato tauler;

  public JocHidato() {
    dificultad = null;
    id = null;
  }

  public JocHidato(int n, int m, tipoDificultad dif, String idJoc) {
    dificultad = dif;
    id = idJoc;
    tauler = new TaulerHidato(n,m);
  }

  public JocHidato(String idJoc, TaulerHidato t) {
    dificultad = null;
    id = idJoc;
    tauler = t;
  }

  public JocHidato(String idJoc, TaulerHidato t, tipoDificultad td) {
    dificultad = td;
    id = idJoc;
    tauler = t;
  }

  public String getId() {
    return id;
  }

  public tipoDificultad getDificultad() {
    return dificultad;
  }

  public void setDificultad(tipoDificultad t) {
    dificultad = t;
  }

  public TaulerHidato getTauler() {
    return tauler;
  }
}
