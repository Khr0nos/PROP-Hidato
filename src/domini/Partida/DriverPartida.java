package domini.Partida;

import domini.JocHidato.JocHidato;
import domini.JocHidato.tipoDificultad;
import domini.TaulerHidato.CtrlTauler;
import domini.TaulerHidato.TaulerHidato;
import domini.Usuari.CtrlUser;

import java.util.Scanner;

public class DriverPartida {
  public static void main(String[] args) {
    try {
      System.out.println("Introdueix operació a fer:");
      System.out.println("1: Crea partida buida");
      System.out.println("2: Crea partida amb usuari i tauler");
      System.out.println("3: modifica valor de tauler");
      System.out.println("4: Consulta si s'ha acabat la partida");
      System.out.println("5: Consulta temps de la partida");
      System.out.println("Introdueix 0 per acabar");
      Scanner sc = new Scanner(System.in);
      int op = sc.nextInt();
      Partida p = new Partida();
      new CtrlUser();
      while (op != 0) {
        if (op == 1) {
          p = new Partida();
          System.out.println("Partida buida creada");
          System.out.println("Partida sense usuari ni tauler");
        } else if (op == 2) {
          System.out.println("Escriu el username:");
          System.out.println("Escriu el password:");
          //String nom = sc.next();
          //String pwd = sc.next();
          //User u = new User(nom,pwd);
          System.out.println("Entra l'identificador del Tauler (tauler dels jocs de proves)");
          System.out.println("Entra l'identificador de la partida (nom que vulguis)");
          System.out.println("Entra dificultat (facil, medio o dificil)");
          String s = sc.next();
          String m = sc.next();
          String lvl = sc.next();
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
          TaulerHidato t = CtrlTauler.carregaTauler(s);
          JocHidato j = new JocHidato(m,t,dif);
          //p = new Partida(u,j);
          if (t != null) {
            System.out.println("Partida amb tauler:");
            t.printTauler();
          }
        } else if (op == 3) {
          System.out.println("Entra fila, columna i valor nou");
          int f = sc.nextInt();
          int c = sc.nextInt();
          int val = sc.nextInt();
          p.nouValor(f,c,val);
          System.out.println("Valor inserit");
        } else if (op == 4){
          if (p.completat()) {
            System.out.println("Partida acabada");
            System.out.println("Temps de partida: " + p.getTime());
          }
          else System.out.println("Partida no terminada");
        } else {
          System.out.println("Temps de partida: " + p.getTime());
        }
        op = sc.nextInt();
      }
    } catch (Exception e) {
          e.printStackTrace();
    }
  }
}
