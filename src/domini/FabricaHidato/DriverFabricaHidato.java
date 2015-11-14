package domini.FabricaHidato;

import domini.JocHidato.tipoDificultad;

import java.util.Scanner;

public class DriverFabricaHidato {
  public static void main(String args[]) {
    Scanner n = new Scanner(System.in);
    System.out.println("Per acabar de generar Hidatos introdueix 0");
    System.out.println("Introdueix nombre de files, columnes, dificultat i id del tauler:");
    int f = n.nextInt();
    int c = n.nextInt();
    String lvl = n.next();
    String id = n.next();
    while (f != 0 && c != 0) {
      try {
        tipoDificultad dif;
        switch (lvl) {
          case "facil":
            dif = tipoDificultad.facil;
            break;
          case "medio":
            dif = tipoDificultad.medio;
            break;
          default:
            dif = tipoDificultad.dificil;
            break;
        }
        FabricaHidato.genera_hidato(c, f, dif, id);
      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.println("Hidato generat, intodueix nou nombre de files, columnes i id (0 0 si vols acabar)");
      f = n.nextInt();
      c = n.nextInt();
      if (f != 0 && c != 0) {
        lvl = n.next();
        id = n.next();
      }
    }
  }
}
