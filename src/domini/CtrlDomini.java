package domini;

import domini.Algorismes.Algorismes;
import domini.FabricaHidato.FabricaHidato;
import domini.JocHidato.tipoDificultad;
import domini.Ranking.RankingGeneral;
import domini.Ranking.RankingPerTipus;
import domini.Ranking.RankingPersonal;
import domini.Ranking.Tupla;
import domini.TaulerHidato.CtrlTauler;
import domini.TaulerHidato.TaulerHidato;
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
  private static ArrayList<String> taulersAutor;
  //private static CtrlTauler CT;
  //private static Algorismes A;

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
  public static void generarHidato(int m,int n, String diff, String id) throws Exception{
    if (Objects.equals(diff, "facil")) FabricaHidato.genera_hidato(m,n,tipoDificultad.facil,id);
    else if (Objects.equals(diff, "medio")) FabricaHidato.genera_hidato(m,n,tipoDificultad.medio,id);
    else FabricaHidato.genera_hidato(m,n,tipoDificultad.facil,id);
  }

  public static boolean generarHidatoUser(int m, int n, String a, ArrayList<Integer> t, String id){
    TaulerHidato th = new TaulerHidato(m,n,a,t);
    boolean b = Algorismes.hasSol(th);
    if (b) {
      CtrlTauler.guardaTauler(th,id);
      TaulerHidato aux = new TaulerHidato(m,n,a,t);
      TaulerHidato sol = Algorismes.solve(aux);
      CtrlTauler.guardaTauler(sol,"solucio" + id);
    }
    return b;
  }

  public static ArrayList<Integer> getTaulerHid(String id){
    TaulerHidato t = CtrlTauler.carregaTauler(id);
    return t.getTauler();
  }

  public static void esborraTauler(String id){
    CtrlPersistencia.deleteFile("src/JocsProva/"+ id +".txt");
    CtrlPersistencia.deleteFile("src/JocsProva/solucio"+ id +".txt");
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
  public static ArrayList<String> taulersAutor(String usr) {
    try {
      taulersAutor = new ArrayList<String>(0);
      ArrayList<ArrayList<String>> taulers = CtrlPersistencia.loadTable("src/JocsProva/Jocs.txt");
      for (int i = 0; i < taulers.size(); ++i) {
        ArrayList<ArrayList<String>> t = CtrlPersistencia.loadTable(taulers.get(i).get(0));
        String id = taulers.get(i).get(0).substring(14, taulers.get(i).get(0).length()-4);
        if (t.get(0).get(2).equals(usr)) taulersAutor.add(id);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return taulersAutor;
  }
  public static void esborraReferenciaTauler(String id) {
    try {
      ArrayList<ArrayList<String>> Taulers = CtrlPersistencia.loadTable("src/JocsProva/Jocs.txt");
      for (int i = Taulers.size() - 1; i >= 0; i--) {
        ArrayList<String> fila = Taulers.get(i);
        if (fila.get(0).equals("src/JocsProva/" + id + ".txt")) Taulers.remove(i);
      }
      CtrlPersistencia.storeTable("src/JocsProva/Jocs.txt", Taulers);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  //PRE: cal haver comprovat id amb checkIdtauler
  public static void guardaReferenciaTauler(String id) {
    try {
      ArrayList<ArrayList<String>> Taulers = CtrlPersistencia.loadTable("src/JocsProva/Jocs.txt");
      ArrayList<String> tauler = new ArrayList<String>();
      tauler.add("src/JocsProva/" + id + ".txt");
      Taulers.add(tauler);
      CtrlPersistencia.storeTable("src/JocsProva/Jocs.txt", Taulers);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static boolean checkIdtauler(String id) {
    boolean ret = false;
    try {
      ArrayList<ArrayList<String>> Taulers = CtrlPersistencia.loadTable("src/JocsProva/Jocs.txt");
      for (int i = 0; i < Taulers.size(); i++) {
        ArrayList<String> tauler = Taulers.get(i);
        //String idTauler = tauler.substring(14,(tauler.length()-4));
        ret = (tauler.get(0).equals("src/JocsProva/" + id + ".txt"));        //true si el id de tauler ja existeix
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return ret;
  }
}
