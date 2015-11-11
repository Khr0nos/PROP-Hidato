package domini;

import persistencia.CtrlPersistencia;

import java.io.IOException;
import java.util.ArrayList;

public class CtrlTauler {
    static private String path = "src/domini/JocsProva/";

    static public Tauler carregaTauler(String id)
    {
        ArrayList<ArrayList<String>> t = new ArrayList<ArrayList<String>>();
        Tauler result = null;

        try {
            t = CtrlPersistencia.loadTable(path + id + ".txt");

            ArrayList<String> header = t.get(0);
            int ancho = Integer.parseInt(header.get(0));
            int alto = Integer.parseInt(header.get(1));
            result = new Tauler(ancho,alto);

            for (int i = 1; i < t.size(); ++i) {
                for (int j = 0; j < t.get(1).size(); ++j) {
                    int val = Integer.parseInt(t.get(i).get(j));
                    //if (val != -1) result.setNumber(j,i-1,val);
                    //else result.setBlocked(j,i-1);
                    if (val != -1) result.getCella(j,i-1).setNumero(val);
                    else result.estaBloqueada(j,i-1);
                }
            }
        } catch (IOException e) {
            System.out.println("No s'ha pogut carregar tauler");
        }
        return result;
    }

    static public void guardaTauler(Tauler t, String id)
    {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        int alto = t.getAlto();
        int ancho = t.getAncho();
        ArrayList<String> header = new ArrayList<String>();
        header.add(Integer.toString(ancho));
        header.add(Integer.toString(alto));
        result.add(header);

        for (int i = 0; i < alto; ++i)
        {
            ArrayList<String> fila = new ArrayList<String>();
            for (int j = 0; j < ancho; ++j)
            {
                if (!t.getCella(j,i).estaVacia())
                {
                    String valor = Integer.toString(t.getNumero(j,i));
                    fila.add(valor);
                }
                else {
                    fila.add("-1");
                }
            }
            result.add(fila);
        }
        //FALTA COMPROVAR SI EL TAULELL ES CORRECTE O NO
        try
        {
            CtrlPersistencia.storeTable(path + id + ".txt", result);
        } catch (IOException e) {
            System.out.println("No s'ha pogut guardar tauler");
        }

    }
}
