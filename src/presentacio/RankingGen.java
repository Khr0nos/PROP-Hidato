package presentacio;

import domini.Ranking.RankingGeneral;
import domini.Usuari.CtrlUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MAX on 06/12/2015.
 */
public class RankingGen extends JFrame {
    private JButton enrereButton;
    private JPanel RG;
    private JLabel Usuaris;
    private JLabel Partides;
    private JLabel Jocs;
    private JLabel Eljoc;

    public RankingGen (Ranking ant){
        setContentPane(RG);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        RankingGeneral rg = new RankingGeneral();
        int n = rg.getnUsuaris();
        String s = Integer.toString(n);
        Usuaris.setText(s);
        Usuaris.setVisible(true);
        n = rg.getnPartides();
        s = Integer.toString(n);
        Partides.setText(s);
        Partides.setVisible(true);
        n = rg.getnJocs();
        s = Integer.toString(n);
        Jocs.setText(s);
        Jocs.setVisible(true);
        Eljoc.setText(rg.getPopular());
        Eljoc.setVisible(true);

        enrereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ant.setVisible(true);
            }
        });
    }

}
