package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MAX on 01/12/2015.
 */
public class Loggin extends JFrame {
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JButton loggInButton;
    private JButton signUpButton;
    private JPanel Loggin;

    private String usr;
    private String pwd;
    private boolean loggin;

    public Loggin(){
        setContentPane(Loggin);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        loggInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usr = textField1.getText();
                pwd = passwordField1.getText();
                System.out.println(usr+" "+pwd);
                MenuPrincipal mp = new MenuPrincipal();
                loggin = true;
                setVisible(false);
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usr = textField1.getText();
                pwd = passwordField1.getText();
                System.out.println(usr+" "+pwd);
                MenuPrincipal mp = new MenuPrincipal();
                loggin = false;
                setVisible(false);
            }
        });
    }

    public String getUsr(){
        return usr;
    }

    public String getPwd(){
        return pwd;
    }
    public boolean getLoggin(){
        return loggin;
    }
}
