package domini.Ranking;

import persistencia.CtrlPersistencia;

import java.io.IOException;

public class CTRLRanking {
		
	public static void carregar(Ranking r, String arxiu) {
		CtrlPersistencia.setSeparator(" ");
		try {
			r.Info = CtrlPersistencia.loadTable("./data/" + arxiu + ".txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
