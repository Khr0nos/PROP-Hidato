package domini.FabricaHidato;

import domini.JocHidato.tipoDificultad;

import java.util.Scanner;

public class DriverFabricaHidato {
  public static void main(String args[]) {
    Scanner n = new Scanner(System.in);
    System.out.println("Per acabar de generar Hidatos introdueix 0 0");
    System.out.println("Tot Hidato generat es guardat en fitxer amb nom = id + numero i la seva solucio amb nom = solucio + id + numero");
    System.out.println("Tots els parametres demanats son obligatoris");
    System.out.println("Introdueix nombre de files, columnes, dificultat (facil, medio o dificil) i id del tauler:");
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
      System.out.println("Introdueix 0 0 si vols acabar");
      System.out.println("Hidato generat, intodueix nou nombre de files, columnes, dificultat (facil, medio o dificil) i id");
      f = n.nextInt();
      c = n.nextInt();
      if (f != 0 && c != 0) {
        lvl = n.next();
        id = n.next();
      }
    }
  }
}
