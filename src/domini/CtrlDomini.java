package domini;

import domini.Ranking.RankingGeneral;
import domini.Ranking.RankingPerTipus;
import domini.Ranking.RankingPersonal;
import domini.Ranking.Tupla;
import domini.Usuari.CtrlUser;
import persistencia.CtrlPersistencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

//Controlador per a comunicar la capa de domini amb la capa de presentació: CtrlDomini <---> Vista de la presentació
public class CtrlDomini {
  private static RankingGeneral RG;
  private static RankingPersonal RP;
  private static RankingPerTipus RT;

  public static String getPassword(String usr) {
    new CtrlUser();
    return CtrlUser.getUsuari(usr).getPassword();
  }

  public static void inicialitzaRankingGen() {
    RG = new RankingGeneral();
  }

  public static void inicialitzaRankingPer(String usr) {
    RP = new RankingPersonal(usr);
  }

  public static void inicialitzaRankingTipus(String d, int n) { RT = new RankingPerTipus(d,n); }

  public static int getnUsuaris() {
    return RG.getnUsuaris();
  }

  public static int getnPartides() {
    return RG.getnPartides();
  }

  public static int getnJocs() {
    return RG.getnJocs();
  }

  public static String getPopular() {
    return RG.getPopular();
  }

  public static int getResolts() {
    return RP.getResolts();
  }

  public static double getPistes() {
    return RP.getPistes();
  }

  public static double getBestTime(String facil) {
    return RP.getBestTime(facil);
  }

  public static int getNEntrades() { return RT.getTempsJugador().size(); }

  public static double getEntradaTemps(int i) {
    ArrayList<Tupla> a = RT.getTempsJugador();
    return a.get(i).getTemps();
  }

  public static String getEntradaUsuari(int i) {
    ArrayList<Tupla> a = RT.getTempsJugador();
    return a.get(i).getUser();
  }
  public static String getIDtauler(int i) {
    ArrayList<Tupla> a = RT.getTempsJugador();
    return a.get(i).getId();
  }

  public static void esborraPartides(String usr) {
    try {
      ArrayList<ArrayList<String>> partides = CtrlPersistencia.loadTable("src/JocsProva/Partides.txt");
      for (int i = partides.size()-1; i >= 0; i--) {
        ArrayList<String> fila = partides.get(i);
        if (Objects.equals(fila.get(0), usr)) {
          partides.remove(fila);
        }
      }
      CtrlPersistencia.storeTable("src/JocsProva/Partides.txt", partides);
      CtrlPersistencia.deleteFile("src/JocsProva/original." + usr + ".partida");
      CtrlPersistencia.deleteFile("src/JocsProva/modificat." + usr + ".partida");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
