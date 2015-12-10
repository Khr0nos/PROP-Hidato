package presentacio;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 * Created by MAX on 01/12/2015.
 */
public class EntraFoto extends JFrame {
    private JPanel JP;
    private JPanelBackground JPB;
    private JLabel Titol;
    private JButton entraButton;

    public EntraFoto() {
        setContentPane(JPB);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(300,300);
        setLocationRelativeTo(null);
        JPB.setBackground("src/foto.jpg");

        entraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Loging l = new Loging();
                setVisible(false);
            }
        });
    }
}