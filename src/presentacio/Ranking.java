package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MAX on 06/12/2015.
 */
public class Ranking extends JFrame {
    private JButton rankingGeneralButton;
    private JButton enrereButton;
    private JButton rankingPersonalButton;
    private JButton rankingPerTipusButton;
    private JPanel Ranking;
    private Ranking actual;

    public Ranking (MenuPrincipal ant, String usr){
        setContentPane(Ranking);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        actual = this;
        enrereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ant.setVisible(true);
            }
        });
        rankingGeneralButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RankingGen rg = new RankingGen(actual);
                setVisible(false);
            }
        });
        rankingPersonalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RankingPer rp = new RankingPer(actual,usr);
                setVisible(false);
            }
        });
    }
}
