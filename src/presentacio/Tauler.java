package presentacio;

import domini.CtrlDomini;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by MAX on 14/12/2015.
 */
public class Tauler extends JFrame implements  MouseListener{
    private int altura;
    private int amplada;
    private JLabel tauler[][];
    private JPanel PT;
    private int ultim;
    private static int num;

    public static void setNum(int n){
        num = n;
    }

    public void mouseEntered(MouseEvent ev){

    }
    public void mouseExited(MouseEvent ev){

    }
    public void mousePressed(MouseEvent ev){

    }
    public void mouseReleased(MouseEvent ev){

    }
    public void mouseClicked(MouseEvent ev){
        int x = ev.getY();
        int y = ev.getX();
        int i = x*altura/400;
        int j = y*amplada/400;
        tauler[i][j].setText(Integer.toString(num));
    }

    public Tauler(String idtau){
        CtrlDomini.carregaTaulerHidato(idtau);
        ultim = CtrlDomini.getUltim();
        altura = CtrlDomini.getFiles();
        amplada = CtrlDomini.getColumnes();
        ArrayList<Integer> tau = CtrlDomini.getTaulerHid(idtau);
        PT = new JPanel(new GridLayout(altura,amplada));
        setContentPane(PT);
        addMouseListener(this);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400,400);
        setLocationRelativeTo(null);
        tauler = new JLabel[altura][amplada];
        for (int i = 0; i < altura; ++i ){
            for (int j = 0; j < amplada; ++j){
                tauler[i][j] = new JLabel();
                tauler[i][j].setHorizontalAlignment(JLabel.CENTER);
                tauler[i][j].setOpaque(true);
                tauler[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                if (tau.get(i*amplada+j).equals(-1)) tauler[i][j].setText("");
                else if (tau.get(i*amplada+j).equals(0)){
                    tauler[i][j].setText("");
                    tauler[i][j].setBackground(Color.GRAY);
                    tauler[i][j].setForeground(Color.WHITE);
                }
                else{
                    tauler[i][j].setText((Integer.toString(tau.get(i*amplada+j))));
                    if (tau.get(i*amplada+j).equals(1) || (tau.get(i*amplada+j).equals(ultim))){
                        tauler[i][j].setBackground(Color.RED);
                        tauler[i][j].setForeground(Color.WHITE);
                    }
                    else{
                        tauler[i][j].setBackground(Color.BLACK);
                        tauler[i][j].setForeground(Color.WHITE);
                    }
                }
                PT.add(tauler[i][j]);
            }
        }
    }
}
