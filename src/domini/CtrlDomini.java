package domini;

import domini.Algorismes.Algorismes;
import domini.FabricaHidato.FabricaHidato;
import domini.JocHidato.JocHidato;
import domini.JocHidato.tipoDificultad;
import domini.Partida.CtrlPartida;
import domini.Partida.Partida;
import domini.Ranking.RankingGeneral;
import domini.Ranking.RankingPerTipus;
import domini.Ranking.RankingPersonal;
import domini.Ranking.Tupla;
import domini.TaulerHidato.CtrlTauler;
import domini.TaulerHidato.TaulerHidato;
import domini.Usuari.CtrlUser;
import persistencia.CtrlPersistencia;

import java.io.IOException;
import java.util.*;

//Controlador per a comunicar la capa de domini amb la capa de presentació: CtrlDomini <---> Vista de la presentació
public class CtrlDomini {
  private static RankingGeneral RG;
  private static RankingPersonal RP;
  private static RankingPerTipus RT;
  private static ArrayList<String> taulersAutor;
  private static TaulerHidato Tauler;
  private static JocHidato Joc;
  private static Partida Partida;

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

  public static void inicialitzaRankingTipus(String d, int n) {
    RT = new RankingPerTipus(d, n);
  }

  public static void inicialitzaPartida(String idtau, String dif, String usr) {
    carregaTaulerHidato(idtau);
    tipoDificultad diff;
    if (dif.equals("fàcil")) diff = tipoDificultad.facil;
    else if (dif.equals("mitjà")) diff = tipoDificultad.medio;
    else diff = tipoDificultad.dificil;
    Joc = new JocHidato(idtau,Tauler,diff);
    Partida = new Partida(usr,Joc);
  }

  public static boolean moviment(int i, int j, int val) {
    Partida.nouValor(i,j,val);
    if (Partida.completat()) {
      guardarPartida();
      return true;
    }
    else return false;
  }

  public static void guardarPartida() {
    CtrlPartida.guardarPartida(Partida);
  }

  public static void carregaPartida(String usr) {
    Partida = CtrlPartida.carregarPartida(usr);
  }

  public static double getTemps() { return Partida.getTime(); }

  public static int getNPistes() { return Partida.getPistes(); }

  public static void incPistes() { Partida.addPista(); }

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

  public static int getNEntrades() {
    return RT.getTempsJugador().size();
  }

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

  public static void generarHidato(int m, int n, String diff, String id) throws Exception {
    if (Objects.equals(diff, "facil")) FabricaHidato.genera_hidato(m, n, tipoDificultad.facil, id);
    else if (Objects.equals(diff, "medio")) FabricaHidato.genera_hidato(m, n, tipoDificultad.medio, id);
    else FabricaHidato.genera_hidato(m, n, tipoDificultad.facil, id);
  }

  public static boolean guardarHidato(String id) {
    boolean b = Algorismes.hasSol(Tauler);
    try {
      if (b) {
        CtrlTauler.guardaTauler(Tauler, id);
        TaulerHidato sol = Algorismes.solve(Tauler);
        CtrlTauler.guardaTauler(sol, "solucio" + id);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return b;
  }

  public static ArrayList<Integer> getTaulerHid(String id) {
    TaulerHidato t = CtrlTauler.carregaTauler(id);
    return t.getTauler();
  }

  public static ArrayList<Integer> perColocar(String id) {
    List<Integer> fixades;
    ArrayList<Integer> falten;
    TaulerHidato t = CtrlTauler.carregaTauler(id);
    int h = t.getAlto();
    int w = t.getAncho();
    fixades = new ArrayList<>();
    for (int i = 0; i < h; ++i){
      for (int j = 0; j < w; ++j){
        if (t.estaFija(i,j)) fixades.add(t.getNumero(i,j));
      }
    }
    Collections.sort(fixades);
    falten = new ArrayList<>();
    boolean b = true;
    for (int i = 1; i <= getUltim(); ++i){
      b = true;
      for (int j = 0; j < fixades.size() && b; ++j){
        if (fixades.get(j).equals(i)) b = false;
        if (!fixades.get(j).equals(i) && fixades.get(j) > i){
          falten.add(i);
          b = false;
        }
      }
    }
    return falten;
  }

  public static void iniTaulerHidato(int n, int m, String usr) { Tauler = new TaulerHidato(n,m,usr); }

  public static void carregaTaulerHidato(String id){
    Tauler = CtrlTauler.carregaTauler(id);
  }

  public static int getFiles() { return Tauler.getAlto(); }

  public static int getColumnes() { return Tauler.getAncho(); }

  public static int getUltim(){
    int max = 0;
    for (int i = 0; i < getFiles(); ++i){
      for (int j = 0; j < getColumnes(); ++j){
        if (Tauler.getNumero(i,j) > max ) max = Tauler.getNumero(i,j);
      }
    }
    return max;
  }
  public static int getValorAt(int i, int j) { return Tauler.getNumero(i,j); }

  public static void setValorAt(int i, int j, int val) { Tauler.setNumero(i,j,val); }

  public static void setFixedAt(int i, int j) { Tauler.setFixed(i,j);}

  public static void esborraTauler(String id){
    try {
      CtrlPersistencia.deleteFile("src/JocsProva/" + id + ".txt");
      CtrlPersistencia.deleteFile("src/JocsProva/solucio" + id + ".txt");
      ArrayList<ArrayList<String>> aux = CtrlPersistencia.loadTable("src/JocsProva/Jocs.txt");
      ArrayList<ArrayList<String>> n = new ArrayList<ArrayList<String>>();
      for (int i = 0; i < aux.size(); ++i) {
        if (!aux.get(i).get(0).contains(id)) n.add(aux.get(i));
      }
      CtrlPersistencia.storeTable("src/JocsProva/Jocs.txt",n);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
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
      ArrayList<ArrayList<String>> partides = CtrlPersistencia.loadTable("src/JocsProva/Partides.txt");
      for (int i = 0; i < taulers.size(); ++i) {
        ArrayList<ArrayList<String>> t = CtrlPersistencia.loadTable(taulers.get(i).get(0));
        String id = taulers.get(i).get(0).substring(14, taulers.get(i).get(0).length()-4);
        if (t.get(0).get(2).equals(usr)){
          boolean b = true;
          for (int j = 0; j < partides.size(); ++j){
            String idp = partides.get(j).get(1);
            if (id.equals(idp)) b = false;
          }
          if (b) taulersAutor.add(id);
        }
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return taulersAutor;
  }
  public static ArrayList<String> taulersAutorMaquina(String usr) {
    try {
      taulersAutor = new ArrayList<String>(0);
      ArrayList<ArrayList<String>> taulers = CtrlPersistencia.loadTable("src/JocsProva/Jocs.txt");
      ArrayList<ArrayList<String>> partides = CtrlPersistencia.loadTable("src/JocsProva/Partides.txt");
      for (int i = 0; i < taulers.size(); ++i) {
        ArrayList<ArrayList<String>> t = CtrlPersistencia.loadTable(taulers.get(i).get(0));
        String id = taulers.get(i).get(0).substring(14, taulers.get(i).get(0).length()-4);
        taulersAutor.add(id);
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
        ret = (tauler.get(0).equals("src/JocsProva/" + id + ".txt"));        //true si el id de tauler ja existeix
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return ret;
  }

  public static void crear_Partida(String idu,String idtau) {

  }
}
