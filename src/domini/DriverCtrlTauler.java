package domini;

import java.util.Scanner;
import java.io.*;

public class DriverCtrlTauler {
    public static void main(String[] args) {
        try {
            System.out.println("Prem 1 per carregar taulell");
            System.out.println("Prem 2 per guardar taulell");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String in = br.readLine();
            if (in.equals("1")) {
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
                for (int i = 0; i < alto; ++i) {
                    String fila = "";
                    for (int j = 0; j < ancho; ++j) {
                        if (t.estaVacia(j, i)) {
                            fila += '.';
                        } else {
                            fila += Integer.toString(t.getNumero(j, i));
                        }
                        fila += " ";
                    }
                    System.out.println(fila);
                }
                System.out.println("Fi tauler");
            }
            else {
                System.out.println("Introdueix el identificador del tauler:");
                Scanner sc = new Scanner(System.in);
                String id = sc.nextLine();
                System.out.println("Introdueix amplada:");
                int n = sc.nextInt();
                System.out.println("Introdueix alçada:");
                int m = sc.nextInt();
                Tauler tauler = new Tauler(n,m);
                System.out.println("Introdueix Taulell:");
                for(int i = 0; i < n; ++i) {
                    for(int j = 0; j < m; ++j) {
                        tauler.setNumero(j,i,sc.nextInt());
                    }
                }
                CtrlTauler.guardaTauler(tauler,id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

