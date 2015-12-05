package domini;

import domini.Usuari.CtrlUser;
import domini.Usuari.User;

import java.util.ArrayList;
import java.util.Vector;

//Controlador per a comunicar la capa de domini amb la capa de presentació: CtrlDomini <---> Vista de la presentació
public class CtrlDomini {

  //Obte dades d'usuari per a la gestió d'usuaris
  public static Vector<Vector<String>> getDadesUsuaris() {
    new CtrlUser();
    Vector<Vector<String>> ret = new Vector<Vector<String>>();
    ArrayList<User> aux = CtrlUser.getTaula();
    for (User us : aux) {
      Vector<String> fila = new Vector<String>(2);
      fila.add(us.getUsername());
      fila.add("****");
      ret.add(fila);
    }
    return ret;
  }
}
