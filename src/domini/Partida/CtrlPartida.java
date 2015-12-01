package domini.Partida;

import domini.JocHidato.JocHidato;
import domini.JocHidato.tipoDificultad;
import domini.TaulerHidato.CtrlTauler;
import domini.TaulerHidato.TaulerHidato;
import domini.Usuari.User;
import persistencia.CtrlPersistencia;

import java.io.IOException;
import java.util.ArrayList;

public class CtrlPartida {

  static public void guardarPartida(Partida p)
  {
    String path = p.getUser().getUsername() + ".partida";
    try {
      p.atura();
      ArrayList<ArrayList<String>> partida = new ArrayList<ArrayList<String>>();

      ArrayList<String> header = new ArrayList<String>();
      header.add(p.getUser().getUsername());
      header.add(p.getJoc().getId());
      tipoDificultad dif = p.getJoc().getDificultad();
      String td;
      switch (dif) {
        case facil:
          td = "facil";
          break;
        case medio:
          td = "medio";
          break;
        case dificil:
          td = "dificil";
          break;
        default:
          td = "dificil";
          break;
      }
      header.add(td);
      header.add(String.valueOf(p.getTime()));
      partida.add(header);
      CtrlPersistencia.storeTable("src/JocsProva/" + path,partida);

      CtrlTauler.guardaTauler(p.getOriginal(), "original." + path);
      CtrlTauler.guardaTauler(p.getModificat(), "modificat." + path);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  static public Partida carregarPartida(User u)
  {
    Partida p = null;
    String path = u.getUsername() + ".partida";
    try {
      TaulerHidato orig = CtrlTauler.carregaTauler("original." + path);
      TaulerHidato mod = CtrlTauler.carregaTauler("modificat." + path);
      ArrayList<ArrayList<String>> partida = CtrlPersistencia.loadTable("src/JocsProva/" + path);
      ArrayList<String> header = partida.get(0);
      String joc = header.get(1);
      String dif = header.get(2);
      tipoDificultad td;
      switch (dif) {
        case "facil":
          td = tipoDificultad.facil;
          break;
        case "medio":
          td = tipoDificultad.medio;
          break;
        default:
          td = tipoDificultad.dificil;
          break;
      }
      Double time = Double.valueOf(header.get(3));
      JocHidato j = new JocHidato(joc,orig,td);
      p = new Partida(u,j,mod,time);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return p;
  }
}