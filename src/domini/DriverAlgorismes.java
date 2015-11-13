package domini;
import java.util.Scanner;

public class DriverAlgorismes {

 private static int t[][];

 private static void llegir_tauler(){
    try{
      Scanner consola = new Scanner(System.in);
      int n = consola.nextInt();
      int m = consola.nextInt();
      t = new int[n][m];
      for (int i = 0; i < n; ++i){
	for (int j = 0; j < m; ++j){
	  t[i][j] = consola.nextInt();
	}
      }
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
 
  
  public static void main(String[] args){
    try{
      llegir_tauler();
      Algorismes a = new Algorismes(t);
      a.buscar_solucio();
      Algorismes.genera_hidato(6,6,tipoDificultad.facil);
    }
    catch(Exception e){
       e.printStackTrace();
    }
  }
}