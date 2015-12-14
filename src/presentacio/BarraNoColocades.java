package presentacio;

import domini.CtrlDomini;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by MAX on 14/12/2015.
 */
public class BarraNoColocades extends JPanel implements MouseListener {
    private JLabel barra[];
    private int ultim;

    public void mouseEntered(MouseEvent ev){

    }
    public void mouseExited(MouseEvent ev){

    }
    public void mousePressed(MouseEvent ev){

    }
    public void mouseReleased(MouseEvent ev){

    }
    public void mouseClicked(MouseEvent ev) {
        int x = ev.getY();
        int i = x*ultim/400;
        int num = Integer.parseInt(barra[i].getText());
        Tauler.setNum(num);
    }

    public BarraNoColocades(String idtau){
        CtrlDomini.carregaTaulerHidato(idtau);
        ultim = CtrlDomini.getUltim();
        setLayout(new GridLayout(ultim,1));
        addMouseListener(this);
        setVisible(true);
        setSize(50,400);
        barra = new JLabel[ultim];
        for (int i = 0; i < ultim; ++i){
            barra[i] = new JLabel();
            barra[i].setHorizontalAlignment(JLabel.CENTER);
            barra[i].setOpaque(true);
            barra[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            barra[i].setText(Integer.toString(i+1));
            add(barra[i]);
        }
    }
}
