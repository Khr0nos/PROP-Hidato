package domini;

import persistencia.CtrlPersistencia;

import java.io.IOException;
import java.util.ArrayList;

//////////////////////////////
//
// CtrlTauler
//
// Agregacio de Taulers
// Permet gestionar taulers
//
// Es considera que l'identificador de tauler es unic (si no es unic es
// sobreescriura el tauler nou a sobre de l'antic)
// El format per guardar un taulell es el seguent, un parell d'enterns
// n i m que indiquen l'amplada i l'alçada del taulell en aquest ordre,
// seguit d'una matriu d'enters on cada numero representa la casella[i][j] del
// taulell. Si la casella es un -1, aquella casella no existira a efectes practics
// (es buida), si la casella es un 0, aquella casella es buida (es poden posar numeros)
// i si la casella te un altre numero es una casella fixa (el numero no es pot canviar).
// Entre numeros i al final de cada linia hi ha d'haver un espai.
//
// Exemple:
//  3 3
// -1 0 2
//  5 0 3
//  6 0 -1
//
//////////////////////////////

public class CtrlTauler {
    static private String path = "src/domini/JocsProva/";

    static public TaulerHidato carregaTauler(String id)
    {
        try {
            ArrayList<ArrayList<String>> t = CtrlPersistencia.loadTable(path + id + ".txt");

            ArrayList<String> header = t.get(0);
            int ancho = Integer.parseInt(header.get(0));
            int alto = Integer.parseInt(header.get(1));
            TaulerHidato result = new TaulerHidato(ancho, alto);
            for (int i = 1; i < t.size(); ++i) {
                for (int j = 0; j < t.get(1).size(); ++j) {
                    int val = Integer.parseInt(t.get(i).get(j));
                    if (val > 0) {
                        result.setNumero(i-1,j, val);
                        result.setFixed(i-1,j);
                    }
                    else if (val == 0) result.setNumero(i-1,j,val);
                    else result.setBlock(i-1,j);
                }
            }
            return result;
        } catch (IOException e) {
            System.out.println("No s'ha pogut carregar tauler");
            return null;
        }
    }

    static public void guardaTauler(TaulerHidato t, String id)
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
                if (!t.estaBloqueada(i,j))
                {
                    String valor = Integer.toString(t.getNumero(i,j));
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
