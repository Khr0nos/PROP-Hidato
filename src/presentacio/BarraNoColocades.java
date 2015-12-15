package presentacio;

import domini.CtrlDomini;

import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

/**
 * Created by MAX on 14/12/2015.
 */
public class BarraNoColocades extends JPanel{
    private static JLabel Num;
    private JButton seg;
    private JButton ant;
    private ArrayList<Integer> t;
    private int ultim;
    private static int pos;


    public BarraNoColocades(String idtau) {
        pos = 0;
        CtrlDomini.carregaTaulerHidato(idtau);
        ultim = CtrlDomini.getUltim();
        t = new ArrayList<>();
        setLayout(new BorderLayout());
        setVisible(true);
        t = CtrlDomini.perColocar(idtau);
        Num = new JLabel();
        Num.setHorizontalAlignment(SwingConstants.CENTER);
        Num.setOpaque(true);
        Num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Num.setText(Integer.toString(t.get(pos)));
        ant = new JButton();
        ant.setHorizontalAlignment(SwingConstants.CENTER);
        ant.setText("Anterior");
        seg = new JButton();
        seg.setHorizontalAlignment(SwingConstants.CENTER);
        seg.setText("Següent");
        add(Num,BorderLayout.CENTER);
        add(ant,BorderLayout.WEST);
        add(seg,BorderLayout.EAST);
        Tauler.setNum(Integer.parseInt(Num.getText()));

        ant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pos != 0) --pos;
                Num.setText(Integer.toString(t.get(pos)));
                add(Num,BorderLayout.CENTER);
                Tauler.setNum(Integer.parseInt(Num.getText()));
            }
        });

        seg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pos != t.size()-1)++pos;
                Num.setText(Integer.toString(t.get(pos)));
                add(Num,BorderLayout.CENTER);
                Tauler.setNum(Integer.parseInt(Num.getText()));
            }
        });


    }
    public void incPos() {
        ++pos;
    }
}
