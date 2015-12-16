package presentacio;

import domini.CtrlDomini;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MAX on 14/12/2015.
 */
public class JugarUsuari extends JFrame {

  private JPanel JU;
  private Tauler T;
  private BarraNoColocades BNC;
  //private JLabel timer;
  //private JScrollPane sc;
  //private JList<String> jl;
  private JButton pista;
  private JButton guardar;
  private JButton exit;

  public JugarUsuari(SeleccionaTauler ant, String usr, String idtau) {
    JU = new JPanel(new GridLayout(3, 1));
    setContentPane(JU);
    pack();
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    setSize(500, 500);
    setLocationRelativeTo(null);
    T = new Tauler(idtau);
    add(T);
    BNC = new BarraNoColocades(idtau);
    add(BNC);
    JPanel aux = new JPanel(new GridLayout(1, 2));
    JPanel aux1 = new JPanel(new GridLayout(3, 1));
    //JPanel aux2 = new JPanel(new GridLayout(2,1));
    pista = new JButton("Pista");
    aux1.add(pista);
    guardar = new JButton("Guardar");
    aux1.add(guardar);
    exit = new JButton("Exit");
    aux1.add(exit);
        /*jl = new JList<>();
        sc = new JScrollPane(jl); aux2.add(sc);
        timer = new JLabel(); aux2.add(timer);*/
    aux.add(aux1);
    //aux.add(aux2);
    add(aux);
    CtrlDomini.inicialitzaPartida(idtau, "fàcil", usr); //Substituir facil per una dificultat

    pista.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });
    guardar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(guardar, "Partida guardada", "Atenció", JOptionPane.INFORMATION_MESSAGE);
        CtrlDomini.guardarPartida();
        String[] ops = {"Si", "No"};
        int n = JOptionPane.showOptionDialog(guardar,
                "Vols continuar la partida?",
                "Avís", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, ops, ops[0]);
        if (n == JOptionPane.NO_OPTION) {
          ant.setVisible(true);
          setVisible(false);
        }
      }
    });
    exit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String[] opcions = {"Si", "No"};
        int n = JOptionPane.showOptionDialog(exit,
                "ATENCIÓ!\n" + "Estas apunt de sortir.\n" +
                        "El teu progrés es perdrà, estas segur que vols continuar?",
                "Esborra Usuari", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opcions, opcions[0]);
        if (n == JOptionPane.YES_OPTION) {
          ant.setVisible(true);
          setVisible(false);
        }
      }
    });
  }

  public JugarUsuari(PlayMenu ant, String usr) { //CONTINUAR
    JU = new JPanel(new GridLayout(3, 1));
    setContentPane(JU);
    pack();
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    setSize(500, 500);
    setLocationRelativeTo(null);
    CtrlDomini.carregaPartida(usr);
    String idtau = CtrlDomini.getIdTaulerPartida();
    T = new Tauler(idtau);
    add(T);
    T.completaTauler(usr);
    BNC = new BarraNoColocades(idtau);
    add(BNC);
    JPanel aux = new JPanel(new GridLayout(1, 2));
    JPanel aux1 = new JPanel(new GridLayout(3, 1));
    //JPanel aux2 = new JPanel(new GridLayout(2,1));
    pista = new JButton("Pista");
    aux1.add(pista);
    guardar = new JButton("Guardar");
    aux1.add(guardar);
    exit = new JButton("Exit");
    aux1.add(exit);
        /*jl = new JList<>();
        sc = new JScrollPane(jl); aux2.add(sc);
        timer = new JLabel(); aux2.add(timer);*/
    aux.add(aux1);
    //aux.add(aux2);
    add(aux);
    //CtrlDomini.esborraUltimaPartida(usr, idtau);
    pista.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
      }
    });
    guardar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(guardar, "Partida guardada", "Atenció", JOptionPane.INFORMATION_MESSAGE);
        CtrlDomini.guardarPartida();
        String[] ops = {"Si", "No"};
        int n = JOptionPane.showOptionDialog(guardar,
                "Vols continuar la partida?",
                "Avís", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, ops, ops[0]);
        if (n == JOptionPane.NO_OPTION) {
          ant.setVisible(true);
          setVisible(false);
        }
      }
    });
    exit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String[] opcions = {"Si", "No"};
        int n = JOptionPane.showOptionDialog(exit,
                "ATENCIÓ!\n" + "Estas apunt de sortir.\n" +
                        "El teu progrés es perdrà, estas segur que vols continuar?",
                "Esborra Usuari", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opcions, opcions[0]);
        if (n == JOptionPane.YES_OPTION) {
          ant.setVisible(true);
          setVisible(false);
        }
      }
    });


  }

  {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
    $$$setupUI$$$();
  }

  /**
   * Method generated by IntelliJ IDEA GUI Designer
   * >>> IMPORTANT!! <<<
   * DO NOT edit this method OR call it in your code!
   *
   * @noinspection ALL
   */
  private void $$$setupUI$$$() {
    JU = new JPanel();
    JU.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
    JU.setMinimumSize(new Dimension(24, 24));
    JU.setPreferredSize(new Dimension(24, 24));
  }

  /**
   * @noinspection ALL
   */
  public JComponent $$$getRootComponent$$$() {
    return JU;
  }
}
