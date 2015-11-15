package domini.Partida;

import domini.JocHidato.JocHidato;
import domini.Usuari.User;
import persistencia.CtrlPersistencia;

public class Partida {
    User user;
    JocHidato joc;

    TaulerHidato original;
    TaulerHidato modificat;
    TaulerHidato solucio = null;

    boolean solucionat = false;

    private String partides = ".partida.txt";

    public Partida()
    {
        user = null;
        joc = null;
    }

    public Partida(User u, JocHidato j)
    {
        user = u;
        joc = j;

        original = joc.getTauler();
        modificat = original.clone();
        solucio = ALgorismes.solve(original);
    }

    public void nouValor(int x, int y, int valor)
    {
        Cella c = modificat.getCella(x, y);
        c.setNumero(valor);

        solucionat = (modificat == solucio);
    }

    public boolean completat()
    {
        return solucionat;
    }

    public void guardar()
    {
        if (user == null) return;

        String path = user.getUsername() + partides;
        try {
            ArrayList<ArrayList<String>> partida = new ArrayList<ArrayList<String>>();

            ArrayList<String> header = new ArrayList<String>();
            header.add(user.getUsername());
            header.add(joc.getId());
            partida.add(header);

            CtrlTauler.guardaTauler(original, "original." + path);
            CtrlTauler.guardaTauler(modificat, "modificat." + path);
            ArrayList<String> info = new ArrayList<String>();
            info.add("original." + path);
            info.add("modificat." + path);
//            temps i errors
        } catch (IOException e) {
            
        }
    }

    public void carregar(User u)
    {
	String path = u.getUsername() + partides;
        try {
            ArrayList<ArrayList<String>> partida = CtrlPersistencia.loadTable(path);

            ArrayList<String> header = partida.get(0);
            String nom_user = header.get(0);
            String id_joc = header.get(1);

            ArrayList<String> info = partida.get(1);
            String tauler_original = info.get(0);
            String tauler_modificat = info.get(1);
//            String temps = info.get(2);
//            String errors = info.get(3);

            user = CtrlUser.getUsuari(nom_user);
            original = CtrlTauler.carregaTauler(tauler_original);
            joc = new JocHidato(id_joc, original);
            modificat = CtrlTauler.carregaTauler(tauler_modificat);
        } catch (IOException e) {
            
        }
    }
}
