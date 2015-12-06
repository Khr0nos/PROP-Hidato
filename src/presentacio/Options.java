package presentacio;

import domini.Usuari.CtrlUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Xavi on 05/12/2015.
 */
public class Options extends JFrame {
  private JButton Taulers;
  private JButton CanviaContrassenyaButton;
  private JPanel Options;
  private JButton esborraUsuariButton;
  private JButton Enrere;
  private Options actual;

  public Options(String usr, String pwd, MenuPrincipal ant) {
    setContentPane(Options);
    pack();
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    setLocationRelativeTo(null);
    actual = this;
    Taulers.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // passar a una finestra on crear, modificar o esborrar taulers
      }
    });
    CanviaContrassenyaButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ModificaUsuari GU = new ModificaUsuari(actual, usr, pwd);
        setVisible(false);
      }
    });
    esborraUsuariButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Object[] opcions = {"Si", "No"};
        int n = JOptionPane.showOptionDialog(actual,
                "ATENCIÓ!\n" + "Estas apunt d'esborrar el teu usuari.\n" +
                        "Els teus taulers continuaran existint per altres usuaris.\n" +
                        "Les teves partides guardades s'esborraran." +
                        "Estas segur que vols continuar?", "Esborra Usuari",JOptionPane.YES_NO_OPTION,
                         JOptionPane.QUESTION_MESSAGE, null, opcions, opcions[0]);
        if (n == JOptionPane.YES_OPTION) {
          CtrlUser.esborraUsuari(usr);
          //FALTA ESBORRAR PARTIDES
          setVisible(false);
          dispose();
          Loging l = new Loging();
        }
      }
    });
    Enrere.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        ant.setVisible(true);
      }
    });
  }
}
