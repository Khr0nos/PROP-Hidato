package domini;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//////////////////////////////
//
// Algorismes
//
// Algorisme que determina si un tauler hidato té solucio. Si en te, la pot trobar
// Podem suposar per al tractament d'un tauler:
// -1 equival a casella sense utilitzar (bloquejada)
// 0 equival a casella buida (per a omplir amb un numero)
// [1..n] valor que te la casella corresponent en un tauler N*M
//
//////////////////////////////

public class Algorismes {
    private static TaulerHidato tauler;
    private static int[] fixades;
    private static int n,m,r,c,f;

    private static int max(int a, int b){
        if (a > b) return a;
        else return b;
    }
    private static int min(int a, int b){
        if (a < b) return a;
        else return b;
    }

    private static boolean resolver(int x, int y, int num, int next){
        if (num > fixades[f-1]) return true;
        if (tauler.getNumero(x,y)!= 0 && tauler.getNumero(x,y) != num) return false;
        if (tauler.getNumero(x,y) == 0 && fixades[next] == num) return false;
        int back = tauler.getNumero(x,y);
        if (back == num) ++next;
        if (!tauler.estaFija(x,y))tauler.setNumero(x,y,num);
        for (int i = max(x-1,0); i <= min(x+1,n-1); ++i){
            for (int j = max(y-1,0); j <= min(y+1,m-1); ++j){
                if (resolver(i,j,num+1,next)) return true;
            }
        }
        if (!tauler.estaFija(x,y)) tauler.setNumero(x,y,back);
        return false;
    }

    public static boolean hasSol(TaulerHidato t){
        n = t.getAlto();
        m = t.getAncho();

        tauler = new TaulerHidato(m,n);

        List<Integer> list = new ArrayList<Integer>(); //Llista amb el numeros fixes
        //creem una copia del tauler que es passa com a parametre
        for (int i = 0; i < n; ++i){
            for (int j = 0; j < m; ++j){
                Cella cel = t.getCella(i,j);
                if (cel.getNumero() == -1) tauler.setBlock(i,j);
                else if (cel.getNumero() == 0) tauler.setNumero(i,j,0);
                else {
                    int val = cel.getNumero();
                    tauler.setNumero(i,j,val);
                    tauler.setFixed(i,j);
                    list.add(val);
                    if (val == 1){ //posicio d'inici
                        r = i;
                        c = j;
                    }
                }
            }
        }
        f = list.size();
        fixades = new int[f];
        Collections.sort(list);
        for (int i = 0; i < f; ++i){
            fixades[i] = list.get(i);
        }
        boolean s = resolver(r,c,1,0);
        return s;
    }

    public static TaulerHidato solve(TaulerHidato t){
        n = t.getAlto();
        m = t.getAncho();

        tauler = new TaulerHidato(m,n);

        List<Integer> list = new ArrayList<Integer>(); //Llista amb el numeros fixes
        //creem una copia del tauler que es passa com a parametre
        for (int i = 0; i < n; ++i){
            for (int j = 0; j < m; ++j){
                Cella cel = t.getCella(i,j);
                if (cel.getNumero() == -1) tauler.setBlock(i,j);
                else if (cel.getNumero() == 0) tauler.setNumero(i,j,0);
                else {
                    int val = cel.getNumero();
                    tauler.setNumero(i,j,val);
                    tauler.setFixed(i,j);
                    list.add(val);
                    if (val == 1){ //posicio d'inici
                    r = i;
                    c = j;
                    }
                }
            }
        }
        f = list.size();
        fixades = new int[f];
        Collections.sort(list);
        for (int i = 0; i < f; ++i){
            fixades[i] = list.get(i);
        }
        resolver(r,c,1,0);
        return tauler;
    }
}