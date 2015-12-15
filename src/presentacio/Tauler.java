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
public class Tauler extends JPanel implements MouseListener{

    private int altura;
    private int amplada;
    private JLabel tauler[][];

    private int ultim;
    private static int num;

    public static void setNum(int n){num = n;}

    public void mousePressed(MouseEvent event){}
    public void mouseExited(MouseEvent event) {}
    public void mouseReleased(MouseEvent event) {}
    public void mouseClicked(MouseEvent event) {
        int x = event.getY();
        int y = event.getX();
        int i = x*altura/getHeight();
        int j = y*amplada/getWidth();
        //COMPROVAR SI MOVIMENT ES LEGAL
        if (!CtrlDomini.getFixedAt(i,j) && !CtrlDomini.getBloqAt(i,j) && CtrlDomini.esPossible(i,j,num)){
                tauler[i][j].setText(Integer.toString(num));
                boolean b = CtrlDomini.moviment(i, j, num);
                if (b){
                    double p = CtrlDomini.getNPistes();
                    double t = CtrlDomini.getTemps();
                    Fi f = new Fi(p,t);
                }
        }


    }
    public void mouseEntered(MouseEvent event) {};

    public Tauler(String idtau){
        addMouseListener(this);
        CtrlDomini.carregaTaulerHidato(idtau);
        ultim = CtrlDomini.getUltim();
        altura = CtrlDomini.getFiles();
        amplada = CtrlDomini.getColumnes();
        ArrayList<Integer> tau = CtrlDomini.getTaulerHid(idtau);
        setLayout(new GridLayout(altura,amplada));
        setVisible(true);
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
                add(tauler[i][j]);
            }
        }
    }
}
