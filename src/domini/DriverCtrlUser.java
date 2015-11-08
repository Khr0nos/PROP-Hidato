package domini;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DriverCtrlUser {
    public static void main(String[] args) {
        new CtrlUser();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Introdueix 1 per obtenir un usuari de la taula");
            System.out.println("Introdueix 2 per afegir un usuari a la taula");
            System.out.println("Introdueix 3 per esborrar un usuari de la taula");

            String in = br.readLine();
            
            switch (in) {
                case "1":
                    System.out.println("Introdueix nom de l'usuari a consultar:");
                    in = br.readLine();
                    User us = CtrlUser.getUsuari(in);
                    if (us != null) {
                        System.out.println("Usuari: " + us.getUsername());
                        System.out.println("Password: " + us.getPassword());
                    }
                    else System.out.println("Usuari no existent");
                    System.out.println();
                    break;
                case "2":
                    System.out.println("Introdueix el nou usuari a afegir [nom password]:");
                    try {
                        in = br.readLine();
                        String[] user = in.split(" ");
                        User aux = new User(user[0], user[1]);
                        boolean b = CtrlUser.afegeixUsuari(aux);
                        if (!b) System.out.println("L'usuari no es pot afegir, ja existeix");
                        System.out.println();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "3":
                    System.out.println("Introdueix nom de l'usuari a esborrar:");
                    in = br.readLine();
                    boolean b = CtrlUser.esborraUsuari(in);
                    if (!b) System.out.println("Usuari no existent");
                    System.out.println();
                    break;
                default:
                    System.out.println("Opció no vàlida");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Bolcat de fitxer:");
        ArrayList<User> usuaris = CtrlUser.getTaula();
        for (User us : usuaris) {
            System.out.println(us.getUsername() + " " + us.getPassword());
        }

        System.out.println("Fi de la taula");
        CtrlUser.end();
    }
}
