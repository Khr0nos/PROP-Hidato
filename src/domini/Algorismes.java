import java.util.*;
import java.io.*;

//////////////////////////////
//
// Algorismes
//
// Conjunt d'algorismes per a la implementació
// del joc Hidato
//
// Podem suposar per al tractament d'un tauler:
// -1 equival a casella sense utilitzar (bloquejada)
// 0 equival a casella buida (per a omplir amb un numero)
// [1..n] valor que te la casella corresponent en un tauler N*N
//
//////////////////////////////

public class Algorismes {
  private static int tauler[][];
  private static int solucio[][];
  private static boolean utilitzat[];
  private static int falten;
  private static int ultima;
  private static int n;
  private static int m;
  private static boolean trobat;
    
  private static int max(int a, int b){
    if (a > b) return a;
      else return b;
    }
  private static int min(int a, int b){
      if (a < b) return a;
      else return b;
    }
 
  private static boolean comprova(int i, int j){
    int dis[][] = new int[n][m];
    boolean vis[][] = new boolean[n][m];
    for (int k = 0; k < n; ++k){
      for (int l = 0; l< m; ++l){
	if (k == i && l == j){
	  dis[i][j] = 0;
	  vis[i][j] = true;
	}
	else{
	vis[k][l] = false;
	dis[k][l] = n+m;
	}
      }	
    }
    Queue<Integer> cua = new LinkedList<Integer>();
    cua.add(i*m+j);
    while (!cua.isEmpty()){
      int pos = cua.poll().intValue();
      int k = pos/m;
      int l = pos%m;
      int d = dis[k][l] +1;
      for (int o = max(0,k-1); o <= min(n-1,k+1); ++o){
	for (int p = max(0,l-1); p <= min(m-1,l+1); ++p){
	  if (!vis[o][p]){
	    dis[o][p] = d;
	    vis[o][p] = true;
	    cua.add(o*m+p);
	    if (tauler[o][p] > 0){
	      int x = tauler[o][p] - tauler[i][j];
	      if (x < 0) x = x *-1;
	      if (d > x) return false;
	    }
	  }
	}
      }
    }
    return true;
  }
  
  private static void backtracking(){
      if (falten == 0){
      trobat = true;
      solucio = new int[n][m];
	for (int i = 0; i < n; ++i){
	  for (int j = 0; j < m; ++j){
	    solucio[i][j] = tauler[i][j];
	  }
	}
      }
      else {
	int mi = 0;
	int mj = 0;
	int minb = 10;
	for (int i = 0; i < n; ++i ){
	  for (int j = 0; j < m; ++j){
	    if (tauler[i][j] == 0){
	      int b = 0;
	      for (int k = max(0,i-1); k <= min(n-1,i+1); ++k){
		for (int l = max(0,j-1); l <= min(m-1,j+1); ++l){
		  if (tauler[i][j] == 0) ++b;
		}
	      }
	      if (b < minb){
	      minb = b;
	      mi = i;
	      mj = j;
	      }
	    }
	  }
	}
	--falten;
	for (int k = 1;(!trobat) && (k < ultima-1); ++k){
	  if (!utilitzat[k]){
	    utilitzat[k] = true;
	    tauler[mi][mj] = k+1;
	    
	    for (int a = 0; a < n; ++a){
	      for (int b = 0; b < m; ++b){
		if (b != m-1) System.out.print(tauler[a][b] + " ");
		else System.out.println(tauler[a][b]);
	      }
	    }
	    System.out.println();
	    
	    if (comprova(mi,mj)) backtracking();
	    tauler[mi][mj] = 0;
	    utilitzat[k] = false;
	  }
	}
	++falten;
      }
  }
  
  private static void escriure_solucio(){
    for (int i = 0; i < n; ++i){
	for (int j = 0; j < m; ++j){
	  if (j != m-1) System.out.print(solucio[i][j] + " ");
	  else System.out.println(solucio[i][j]);
	}
    }
  }
  public Algorismes(){
  }

  public Algorismes(int t[][]){
    n = t.length;
    m = t[0].length;
   
    tauler = new int[n][m];
    
    for (int i = 0; i < n; ++i){
      for (int j = 0; j < m; ++j){
	    tauler[i][j] = t[i][j];
      }
    }
  }
    
  public final void buscar_solucio(){
    trobat = false;
    falten = ultima = 0;
    for (int i = 0; i < n; ++i){
      for (int j = 0; j < m; ++j){
	if (tauler[i][j] == 0) ++falten;
	else if (tauler[i][j] > ultima) ultima = tauler[i][j];
      }
    }
    utilitzat = new boolean[ultima];
    for (int i = 0; i < ultima; ++i)utilitzat[i] = false;
    for (int i = 0; i < n; ++i){
      for (int j = 0; j < m; ++j){
	if (tauler[i][j] > 0) utilitzat[tauler[i][j] -1] = true;
      }
    }
    backtracking();
    escriure_solucio();
  }	

}
