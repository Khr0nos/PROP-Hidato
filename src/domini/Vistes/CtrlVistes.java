package domini.Vistes;

import domini.Algorismes.Algorismes;
import domini.FabricaHidato.FabricaHidato;
import domini.Partida.CtrlPartida;
import domini.Ranking.CTRLRanking;
import domini.TaulerHidato.CtrlTauler;
import domini.Usuari.CtrlUser;

//no s'utilitza de moment

public class CtrlVistes {
  private static CtrlPartida CP;
  private static CtrlTauler CT;
  private static CTRLRanking CR;
  private static CtrlUser CU;
  private static Algorismes A;
  private static FabricaHidato F;

  public CtrlVistes() {
    CP = new CtrlPartida();
    CT = new CtrlTauler();
    CR = new CTRLRanking();
    CU = new CtrlUser();
    A = new Algorismes();
    F = new FabricaHidato();

  }

 /* public void run() {
    //cridat al Mainaux
  }*/
}
