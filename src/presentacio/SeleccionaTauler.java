package presentacio;

import domini.CtrlDomini;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by josep on 12/10/15.
 */
public class SeleccionaTauler extends JFrame{
    private JPanel ST;
    private JList list1;
    private JScrollPane SP;
    private JButton enrereButton;
    private JButton okButton;
    private SeleccionaTauler actual;

    private void ActualitzaList(String usr) {
        ArrayList<String> taulers = CtrlDomini.taulersAutor(usr);
        DefaultListModel<String> data = new DefaultListModel<>();
        for (int j = 0; j < taulers.size(); ++j) {
            data.addElement(taulers.get(j));
        }
        list1.setModel(data);
    }

    private void ActualitzaListAmbMaquina(String usr) {
        ArrayList<String> taulers = CtrlDomini.taulersAutorMaquina(usr);
        DefaultListModel<String> data = new DefaultListModel<>();
        for (int j = 0; j < taulers.size(); ++j) {
            data.addElement(taulers.get(j));
        }
        list1.setModel(data);
    }

    public SeleccionaTauler(GestioTaulers ant, String usr, int i) {
        setContentPane(ST);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        actual = this;
        ActualitzaList(usr);
        enrereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ant.setVisible(true);
                setVisible(false);
            }
        });
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (i == 0) {
                    //ESBORRA
                    String[] opcions = {"Si", "No"};
                    int n = JOptionPane.showOptionDialog(actual,
                            "ATENCIÓ!\n" + "Estas segur que vols esborrar " + list1.getSelectedValue().toString() +"?",
                            "Esborra Tauler", JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null, opcions, opcions[0]);
                    if (n == JOptionPane.YES_OPTION) {
                        CtrlDomini.esborraTauler(list1.getSelectedValue().toString());
                        ActualitzaList(usr);
                    }
                }
                else if (i == 1) {
                    //MODIFICA
                    CrearUsuari c = new CrearUsuari(actual,usr,list1.getSelectedValue().toString());
                    setVisible(false);
                }
            }
        });
    }
    public SeleccionaTauler(PlayMenu ant, String usr, int i) {
        setContentPane(ST);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        actual = this;
        ActualitzaListAmbMaquina(usr);
        enrereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ant.setVisible(true);
                setVisible(false);
            }
        });
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (i == 2) {
                    //PARTIDA NORMAL
                    JugarUsuari ju = new JugarUsuari(actual,usr,list1.getSelectedValue().toString());
                    setVisible(false);
                } else if (i == 3) {
                    //PARTIDA MAQUINA
                }
            }
        });
    }
}
