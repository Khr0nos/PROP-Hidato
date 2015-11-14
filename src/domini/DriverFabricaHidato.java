package domini;

import java.util.Scanner;

public class DriverFabricaHidato {
  public static void main(String args[]) {
    Scanner n = new Scanner(System.in);
    System.out.println("Per acabar de generar Hidatos introdueix 0");
    System.out.println("Introdueix nombre de files i columnes:");
    int f = n.nextInt();
    int c = n.nextInt();
    while (f != 0 && c != 0) {
      try {
        FabricaHidato.genera_hidato(c, f, tipoDificultad.facil);
      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.println("Hidato generat, intodueix 0 0 si vols acabar");
      f = n.nextInt();
      c = n.nextInt();
    }
  }
}
