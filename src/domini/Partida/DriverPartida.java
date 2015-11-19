package domini.Partida;

import domini.JocHidato.JocHidato;
import domini.TaulerHidato.CtrlTauler;
import domini.TaulerHidato.TaulerHidato;
import domini.Usuari.CtrlUser;
import domini.Usuari.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DriverPartida {
  public static void main(String[] args) {
    try {
      System.out.println("Introdueix operació a fer:");
      System.out.println("1: Crea partida buida");
      System.out.println("2: Crea partida amb usuari i tauler");
      System.out.println("3: modifica valor de tauler"); 
      System.out.println("4: Guarda partida");
      System.out.println("5: Carrega partida");
      System.out.println("6: Consulta si s'ha acabat la partida");
      System.out.println("Introdueix 0 per acabar");
      Scanner sc = new Scanner(System.in);
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int op = sc.nextInt();
      Partida p = new Partida();
      new CtrlUser();
      while (op != 0) {
        if (op == 1) {
          p = new Partida();
          System.out.println("Partida buida creada");
        } else if (op == 2) {
          System.out.println("Escriu el username:");
          String nom = br.readLine();
          System.out.println("Escriu el password:");
          String pwd = br.readLine();
          User u = new User(nom,pwd);
          System.out.println("Entra l'identificador del Tauler (tauler dels jocs de proves)");
          String s = br.readLine();
          System.out.println("Entra l'identificador de la partida");
          String m = br.readLine();
          TaulerHidato t = CtrlTauler.carregaTauler(s);
          JocHidato j = new JocHidato(m,t);
          p = new Partida(u,j);
        } else if (op == 3) {
          System.out.println("Entra fila, columna i valor nou");
          int f = sc.nextInt();
          int c = sc.nextInt();
          int val = sc.nextInt();
          p.nouValor(f,c,val);
        } else if (op == 4) {
          if (p.getUser() != null) {
            p.guardar();
            System.out.println("Partida guardada");
          } else {
            System.out.println("No es pot guardar una partida buida");
          }
        } else if (op == 5) {
          System.out.println("Escriu el username de l'usuari a carregar partida:");
          String nom = br.readLine();
          User us = CtrlUser.getUsuari(nom);
          if (us != null) p.carregar(us);
          else System.out.println("Partida no guardada (usuari no trobat)");
        } else {
          if (p.completat()) System.out.println("Partida acabada");
          else System.out.println("Partida no terminada");
        }
        op = sc.nextInt();
      }
    } catch (Exception e) {
          e.printStackTrace();
    }
  }
}
