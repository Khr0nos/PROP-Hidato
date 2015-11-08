package domini;

import persistencia.CtrlPersistencia;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by josep on 10/30/15.
 */
public class Interprete {

    public void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String in = "";

            in = br.readLine();
            ArrayList<ArrayList<cells>> tablero;
            ArrayList<ArrayList<String>> t_aux = CtrlPersistencia.loadTable(in);


        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
