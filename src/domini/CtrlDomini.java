package domini;

import domini.Usuari.CtrlUser;

//Controlador per a comunicar la capa de domini amb la capa de presentació: CtrlDomini <---> Vista de la presentació
public class CtrlDomini {

  public static String getPassword(String usr) {
    new CtrlUser();
    return CtrlUser.getUsuari(usr).getPassword();
  }
}
