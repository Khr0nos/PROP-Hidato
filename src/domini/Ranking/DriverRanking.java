package domini.Ranking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by josep on 11/26/15.
 */
public class DriverRanking {
    public static void main(String args[]) {
        try {
            System.out.println("1. Genera Ranking General");
            System.out.println("2. Genera Ranking Personal");
            System.out.println("3. Genera Ranking Per Tipus");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String x = br.readLine();
            Scanner sc = new Scanner(System.in);
            RankingFactory rf = new RankingFactory();
            if (x.equals("1")) {
                RankingGeneral r = rf.generarRankingGeneral();
                System.out.println(r.getnJocs());
                System.out.println(r.getnPartides());
                System.out.println(r.getnUsuaris());
                System.out.println(r.getPopular());
            } else if (x.equals("2")) {
                System.out.println("Seleciona Usuari");
                String s = sc.nextLine();
                RankingPersonal r = rf.generarRankingPersonal(s);
                System.out.println(r.getUsuari());
                System.out.println(r.getBestTime());
                System.out.println("Millor temps de dificultat facil");
                System.out.println(r.getBestTime("facil"));
                System.out.println("Millor temps de dificultat mitjana");
                System.out.println(r.getBestTime("medio"));
                System.out.println("Millor temps de dificultat dificil");
                System.out.println(r.getBestTime("dificil"));
                System.out.println(r.getPistes());
                System.out.println(r.getResolts());
            } else {
                System.out.println("Seleciona dificultat i entrades");
                String dif = sc.nextLine();
                String n = sc.nextLine();
                RankingPerTipus r = rf.generarRankingPerTipus(dif, Integer.parseInt(n));
                ArrayList<Tupla> a = r.getTempsJugador();
                for (int i = 0; i < a.size(); ++i) {
                    System.out.println(a.get(i).getTemps());
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
