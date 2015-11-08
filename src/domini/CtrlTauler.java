package domini;

import persistencia.CtrlPersistencia;

import java.io.IOException;
import java.util.ArrayList;

public class CtrlTauler {
    static private String taulers = "taulers";

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

            int filas = t.size();
            for (int i = 1; i < filas; ++i) {
                ArrayList<String> cella = t.get(i);

                int x = Integer.parseInt(t.get(i).get(0));
                int y = Integer.parseInt(t.get(i).get(1));
                int valor = Integer.parseInt(t.get(i).get(2));

                result.setNumero(x, y, valor);
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
            for (int j = 0; j < ancho; ++j)
            {
                Cella c = t.getCella(i, j);
                if (!c.estaVacia())
                {
                    String x = Integer.toString(c.getX());
                    String y = Integer.toString(c.getY());
                    String valor = Integer.toString(c.getNumero());

                    ArrayList<String> celda = new ArrayList<String>();
                    celda.add(x);
                    celda.add(y);
                    celda.add(valor);
                    result.add(celda);
                }
            }
        }

        try
        {
            CtrlPersistencia.storeTable(taulers + id + ".txt", result);
        } catch (IOException e) {
            System.out.println("No s'ha pogut guardar tauler");
        }

    }
}
