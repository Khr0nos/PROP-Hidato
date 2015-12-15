package domini.Partida;

import domini.JocHidato.JocHidato;
import domini.JocHidato.tipoDificultad;
import domini.TaulerHidato.CtrlTauler;
import domini.TaulerHidato.TaulerHidato;
import domini.Usuari.User;

import java.util.Scanner;

public class DriverCtrlPartida {
  /*public static void main(String args[]) {
    Scanner n = new Scanner(System.in);
    System.out.println("Per acabar introdueix 0");
    System.out.println("Introdueix opció:");
    System.out.println("Opció 1: Guarda Partida");
    System.out.println("Opció 2: Carrega Partida");

    Partida p;
    int op = n.nextInt();
    while (op != 0) {
      try {
        if (op == 1) {
          System.out.println("Escriu el username i password:");
          String nom = n.next();
          String pwd = n.next();
          User u = new User(nom,pwd);
          System.out.println("Entra l'identificador del Tauler (tauler dels jocs de proves)");
          System.out.println("Entra l'identificador de la partida (nom que vulguis)");
          System.out.println("Entra dificultat (facil, medio o dificil)");
          String s = n.next();
          String m = n.next();
          String lvl = n.next();
          tipoDificultad td;
          switch (lvl) {
            case "facil":
              td = tipoDificultad.facil;
              break;
            case "medio":
              td = tipoDificultad.medio;
              break;
            default:
              td = tipoDificultad.dificil;
              break;
          }
          TaulerHidato t = CtrlTauler.carregaTauler(s);
          JocHidato j = new JocHidato(m,t,td);
          p = new Partida(u,j);
          CtrlPartida.guardarPartida(p);
        } else {
          System.out.println("Escriu el nom i password de l'usuari de la partida a carregar:");
          String nom = n.next();
          String pwd = n.next();
          User u  = new User(nom,pwd);
          p = CtrlPartida.carregarPartida(u);
          System.out.println("Partida carregada");
          System.out.println("Tauler actual de la partida:");
          p.getModificat().printTauler();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.println("intodueix 0 si vols acabar");
      op = n.nextInt();
    }
  }*/
}
