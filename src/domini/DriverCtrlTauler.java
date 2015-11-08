package domini;

import java.io.*;
import java.util.Scanner;

public class DriverCtrlTauler {
    public static void main(String[] args)
    {
        System.out.println("Introdueix el identificador del tauler:");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();

        System.out.println("S'ha llegit: " + id);

        System.out.println("Carregant tauler ...");
        Tauler t = CtrlTauler.carregaTauler(id);
        System.out.println("Tauler carregat");

        System.out.println("visualitzacio del tauler:");
        int alto = t.getAlto();
        int ancho = t.getAncho();
        for (int i = 0; i < alto; ++i)
        {
            String fila = "";
            for (int j = 0; j < ancho; ++j)
            {
                if (t.estaVacia(j, i)) { fila += '.'; }
                else { fila += Integer.toString(t.getNumero(j, i)); }
            }
            System.out.println(fila);
        }
        System.out.println("Fi tauler");

    }
}

