package domini;

import java.util.Scanner;

public class DriverTaulerHidato {
  public static void main(String args[]) {
    Scanner n = new Scanner(System.in);
    System.out.println("Per acabar introdueix 0");
    System.out.println("Introdueix opció:");
    System.out.println("Opció 1: Crea Tauler");
    System.out.println("Opció 2: Obté cel·la");
    System.out.println("Opció 3: Canvia cel·la ");
    System.out.println("Opció 4: Obté nombre de columnes");
    System.out.println("Opció 5: Obté nombre de files");
    System.out.println("Opció 6: Obté valor de cel·la");
    System.out.println("Opció 7: Consulta si una cel·la esta buida");
    System.out.println("Opció 8: Consulta si una cel·la esta bloquejada");
    System.out.println("Opció 9: Canvia valor d'una cel·la");
    System.out.println("Opció 10: Bloqueja cel·la");
    System.out.println("Opció 11: Fixa cel·la");
    System.out.println("Opció 12: Mostra tauler");

    TaulerHidato t = new TaulerHidato(2,2);
    int f, c;
    int op = n.nextInt();
    while (op != 0) {
      try {
        if (op == 1) {
          System.out.println("Entra files i columnes");
          f = n.nextInt();
          c = n.nextInt();
          t = new TaulerHidato(c,f);
        }
        else if (op == 2) {
          System.out.println("Entra fila, columna de la cel·la");
          f = n.nextInt();
          c = n.nextInt();
          System.out.println("Aquesta cel·la conté valor: "+t.getCella(f,c).getNumero());
        }
        else if (op == 3) {
          System.out.println("Entra fila, columna i valor de cel·la");
          f = n.nextInt();
          c = n.nextInt();
          int val = n.nextInt();
          Cella cell = new Cella(f,c);
          cell.setNumero(val);
          t.setCella(f,c,cell);
        }
        else if (op == 4) {
          System.out.println(t.getAncho());
        }
        else if (op == 5) {
          System.out.println(t.getAlto());
        }
        else if (op == 6) {
          System.out.println("Entra fila, columna de la cel·la");
          f = n.nextInt();
          c = n.nextInt();
          System.out.println(t.getNumero(f,c));
        }
        else if (op == 7) {
          System.out.println("Entra fila, columna de la cel·la");
          f = n.nextInt();
          c = n.nextInt();
          if (t.estaVacia(f,c)) System.out.println("esta buida");
          else System.out.println("no esta buida");
        }
        else if (op == 8) {
          System.out.println("Entra fila, columna de la cel·la");
          f = n.nextInt();
          c = n.nextInt();
          if (t.estaBloqueada(f,c)) System.out.println("esta bloquejada");
          else System.out.println("no esta bloquejada");
        }
        else if (op == 9) {
          System.out.println("Entra fila, columna i valor nou");
          f = n.nextInt();
          c = n.nextInt();
          int val = n.nextInt();
          t.getCella(f,c).setNumero(val);
        }
        else if (op == 10) {
          System.out.println("Entra fila, columna de la cel·la");
          f = n.nextInt();
          c = n.nextInt();
          t.setBlock(f,c);
        }
        else if (op == 11) {
          System.out.println("Entra fila, columna de la cel·la");
          f = n.nextInt();
          c = n.nextInt();
          t.setFixed(f,c);
        }
        else {
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
