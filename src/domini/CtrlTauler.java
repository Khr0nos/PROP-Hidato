package domini;

import persistencia.CtrlPersistencia;

import java.io.IOException;
import java.util.ArrayList;

public class CtrlTauler {
    static private String taulers = "src/domini/JocsProva/";

    static public Tauler carregaTauler(String id)
    {
        ArrayList<ArrayList<String>> t = new ArrayList<ArrayList<String>>();
        Tauler result = null;

        try {
            t = CtrlPersistencia.loadTable(taulers + id + ".txt");

            ArrayList<String> header = t.get(0);
            String ancho = header.get(0);
            String alto = header.get(1);
            result = new Tauler(Integer.parseInt(ancho), Integer.parseInt(alto));

            for (int i = 2; i <= t.size(); ++i) {
                for (int j = 0; j < t.get(1).size(); ++j) {
                    //System.out.println(t.get(i).get(j));
                    int val = Integer.parseInt(t.get(i-1).get(j));
                    if (val != -1) result.setNumero(j,i-1,val);
                    else result.getCella(j,i-1).bloquear();
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
                Cella c = t.getCella(i, j);
                //if (!c.estaVacia())
                //{
                    String valor = Integer.toString(c.getNumero());
                    fila.add(valor);
                //}
            }
            result.add(fila);
        }
        //FALTA COMPROVAR SI EL TAULELL ES CORRECTE O NO
        try
        {
            CtrlPersistencia.storeTable(taulers + id + ".txt", result);
        } catch (IOException e) {
            System.out.println("No s'ha pogut guardar tauler");
        }

    }
}
