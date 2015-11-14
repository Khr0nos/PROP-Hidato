package domini.JocHidato;

import domini.TaulerHidato.TaulerHidato;

import java.util.Scanner;

public class DriverJocHidato {
  public static void main(String args[]) {
    Scanner n = new Scanner(System.in);
    System.out.println("Per acabar introdueix 0");
    System.out.println("Introdueix opció:");
    System.out.println("Opció 1: Crea Joc per defecte");
    System.out.println("Opció 2: Crea Joc amb id i tauler");
    System.out.println("Opció 3: Crea Joc amb id i dificultat");
    System.out.println("Opció 4: Crea Joc amb id, tauler i dificultat");
    System.out.println("Opció 5: Obté id del joc");
    System.out.println("Opció 6: Obté dificultat del joc");
    System.out.println("Opció 7: Canvia dificultat del joc");
    System.out.println("Opció 8: Obté tauler del joc");

    JocHidato joc = new JocHidato();
    int op = n.nextInt();
    while (op != 0) {
      try {
        if (op == 1) joc = new JocHidato();
        else if (op == 2) {
          System.out.println("Entra files, columnes i id del joc");
          int f = n.nextInt();
          int c = n.nextInt();
          String id = n.nextLine();
          TaulerHidato t = new TaulerHidato(c,f);
          joc = new JocHidato(id,t);
        }
        else if (op == 3) {
          System.out.println("Entra files, columnes, dificultat i id del joc");
          int f = n.nextInt();
          int c = n.nextInt();
          String id = n.nextLine();
          String dif = n.next();
          tipoDificultad d;
          switch (dif) {
            case "facil":
              d = tipoDificultad.facil;
              break;
            case "medio":
              d = tipoDificultad.medio;
              break;
            default:
              d = tipoDificultad.dificil;
              break;
          }
          joc = new JocHidato(f,c,d,id);
        }
        else if (op == 4) {
          System.out.println("Entra files, columnes, dificultat i id del joc");
          int f = n.nextInt();
          int c = n.nextInt();
          String dif = n.next();
          String id = n.nextLine();
          tipoDificultad d;
          switch (dif) {
            case "facil":
              d = tipoDificultad.facil;
              break;
            case "medio":
              d = tipoDificultad.medio;
              break;
            default:
              d = tipoDificultad.dificil;
              break;
          }
          TaulerHidato t = new TaulerHidato(c,f);
          joc = new JocHidato(id,t,d);
        }
        else if (op == 5) {
          System.out.println(joc.getId());
        }
        else if (op == 6) {
          System.out.println(joc.getDificultad());
        }
        else if (op == 7) {
          System.out.println("Entra dificultat nova del joc");
          String dif = n.next();
          tipoDificultad d;
          switch (dif) {
            case "facil":
              d = tipoDificultad.facil;
              break;
            case "medio":
              d = tipoDificultad.medio;
              break;
            default:
              d = tipoDificultad.dificil;
              break;
          }
          joc.setDificultad(d);
        } else {
          TaulerHidato t = joc.getTauler();
          t.printTauler();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.println("intodueix 0 si vols acabar");
      op = n.nextInt();
    }
  }
}
