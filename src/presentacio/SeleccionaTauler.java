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

    public SeleccionaTauler(GestioTaulers ant, String usr, int i) {
        setContentPane(ST);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        actual = this;
        ArrayList<String> taulers = CtrlDomini.taulersAutor(usr);
        DefaultListModel<String> data = new DefaultListModel<>();
        for (int j = 0; j < taulers.size(); ++j) {
            data.addElement(taulers.get(j));
        }
        list1.setModel(data);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        SP = new JScrollPane(list1);
        add(SP);
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
                }
                if (i == 1) {
                    //MODIFICA
                    //ModificaTauler m = new ModificaTauler(actual,);
                }
                setVisible(false);
            }
        });
    }
}
