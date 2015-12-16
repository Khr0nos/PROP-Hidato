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

    private static int altura;
    private static int amplada;
    private static JLabel tauler[][];

    private int ultim;
    private static int num;
    private static int last;
    private static int next;
    private static boolean primerapista;

    public static void setNum(int n){
        num = n;
    }

    public static int getNext(){
        int p = BarraNoColocades.getPos(last);
        if (primerapista){
            primerapista = false;
            next = BarraNoColocades.getNum(0);
        }
        else next = BarraNoColocades.getNum(p+1);
        return next;
    }

    public static void setPista(String id){
        int PosP = CtrlDomini.getPosPista(next,id);
        int px = PosP/amplada;
        int py = PosP%amplada;
        tauler[px][py].setText(Integer.toString(next));
        boolean b = CtrlDomini.moviment(px,py,next);
        last = next;
        if (b){
            double p = CtrlDomini.getNPistes();
            double t = CtrlDomini.getTemps();
            Fi f = new Fi(p,t);
        }
        else{
           BarraNoColocades.incrementaPos();
        }
    }

    public static void resolTauler(String idtau){
        ArrayList<Integer> sol = CtrlDomini.getSolucio(idtau);
        for (int i = 0; i < altura; ++i){
            for (int j = 0; j < amplada;++j){
                if (!sol.get(i*amplada+j).equals(-1)) tauler[i][j].setText(Integer.toString(sol.get(i*amplada+j)));
            }
        }
    }
    public static void completaTauler(String usr){
        ArrayList<Integer> mod = CtrlDomini.getModificat(usr);
        for (int i = 0; i < altura; ++i){
            for (int j = 0; j < amplada;++j){
                int numero = mod.get(i*amplada+j);
                if (numero != -1 && numero != 0){
                    if (numero != CtrlDomini.getValorAt(i,j)) {
                        CtrlDomini.noFijarAt(i,j);
                        tauler[i][j].setText(Integer.toString(mod.get(i * amplada + j)));
                        CtrlDomini.moviment(i, j, mod.get(i * amplada + j));
                    }
                }
            }
        }
    }

    public void mousePressed(MouseEvent event){}
    public void mouseExited(MouseEvent event) {}
    public void mouseReleased(MouseEvent event) {}
    public void mouseClicked(MouseEvent event) {
        int x = event.getY();
        int y = event.getX();
        int i = x*altura/getHeight();
        int j = y*amplada/getWidth();
        //COMPROVAR SI MOVIMENT ES LEGAL
        if (!CtrlDomini.getFixedAt(i,j) && !CtrlDomini.getBloqAt(i,j) /*&& CtrlDomini.esPossible(i,j,num)*/){
            if (tauler[i][j].getText().equals("")) {
                last = num;
                tauler[i][j].setText(Integer.toString(num));
                boolean b = CtrlDomini.moviment(i, j, num);
                if (b) {
                    double p = CtrlDomini.getNPistes();
                    double t = CtrlDomini.getTemps();
                    Fi f = new Fi(p, t);
                } else {
                    BarraNoColocades.incrementaPos();
                }
            }
            else {
                int n = Integer.parseInt(tauler[i][j].getText());
                CtrlDomini.moviment(i,j,0);
                tauler[i][j].setText("");
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
        primerapista = true;
        //last = BarraNoColocades.getNum(0);
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
