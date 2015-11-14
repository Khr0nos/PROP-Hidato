package domini;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

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
                TaulerHidato t = CtrlTauler.carregaTauler(id);
                System.out.println("Tauler carregat");

                System.out.println("visualitzacio del tauler:");
                t.printTauler();
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
                TaulerHidato tauler = new TaulerHidato(n,m);
                System.out.println("Introdueix Taulell:");
                for(int i = 0; i < m; ++i) {
                    for(int j = 0; j < n; ++j) {
                        int val = sc.nextInt();
                        if(val != -1) tauler.setNumero(i,j,val);
                        else tauler.setBlock(i,j);
                    }
                }
                CtrlTauler.guardaTauler(tauler,id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

