package domini;

import domini.Ranking.RankingGeneral;
import domini.Ranking.RankingPersonal;
import domini.Usuari.CtrlUser;

//Controlador per a comunicar la capa de domini amb la capa de presentació: CtrlDomini <---> Vista de la presentació
public class CtrlDomini {
  private static RankingGeneral RG;
  private static RankingPersonal RP;

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
}
