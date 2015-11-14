package domini.Ranking;

import domini.Usuari.CtrlUser;
import persistencia.CtrlPersistencia;

public class RankingFactory {
	
	public RankingFactory() {
		CtrlPersistencia.setSeparator(" ");
		System.out.println("---");
		CtrlUser CU = new CtrlUser();
	}
	
	public RankingGeneral generarRankingGeneral() {
		return new RankingGeneral();
	}
	
	public RankingPerTipus generarRankingPerTipus (String d, int nEntrades) {
		return new RankingPerTipus(d, nEntrades);
	}
	
	public RankingPersonal generarRankingPersonal(String username) {
		return new RankingPersonal(username);
	}
}
