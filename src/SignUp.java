import org.w3c.dom.CDATASection;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SignUp extends JFrame {
    JFrame jFrame = new JFrame("Sign Up");
    JPanel jPanel = new JPanel();
    JLabel jLabelUsername = new JLabel("Username");
    JTextField jTextFieldUsername = new JTextField();
    JLabel jLabelPassword = new JLabel("Password");
    JPasswordField jPasswordField = new JPasswordField();
    JLabel jLabelEmail = new JLabel("Email");
    JTextField jTextFieldEmail = new JTextField();
    JButton jButtonSubmit = new JButton("Submit");
    JButton jButtonBack = new JButton("Back");
    JPanel jPanelForButtons = new JPanel();
    String stringRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public SignUp(GameStore gameStore, BinarySearchTree binarySearchTree, DatabaseConnect databaseConnect) {
        jFrame.setLayout(new BorderLayout());
        jPanel.setLayout(new GridLayout(3, 3));
        jPanelForButtons.setLayout(new FlowLayout());

        jLabelUsername.setHorizontalAlignment(0);
        jLabelPassword.setHorizontalAlignment(0);
        jLabelEmail.setHorizontalAlignment(0);

        jPanel.add(jLabelUsername);
        jPanel.add(jTextFieldUsername);
        jPanel.add(jLabelPassword);
        jPanel.add(jPasswordField);
        jPanel.add(jLabelEmail);
        jPanel.add(jTextFieldEmail);

        jPanelForButtons.add(jButtonSubmit);
        jButtonSubmit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jTextFieldUsername.getText().equals("") || jPasswordField.getText().equals("") || jTextFieldEmail.getText().equals("")) {
                    JOptionPane.showMessageDialog(jFrame, "Username or password or email can't be empty!", "Alert", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (databaseConnect.checkUsername(jTextFieldUsername.getText()) && databaseConnect.checkEmail(jTextFieldEmail.getText())) {
                        if (jTextFieldEmail.getText().matches(stringRegex)) {
                            User userToAdd = new User(jTextFieldUsername.getText(), jPasswordField.getText(), jTextFieldEmail.getText());
                            if (databaseConnect.createUser(userToAdd)) {
                                JOptionPane.showMessageDialog(jFrame, "User created.You can log in now! ", "Alert", JOptionPane.WARNING_MESSAGE);
                                jFrame.dispose();
                            }
                        } else {
                            JOptionPane.showMessageDialog(jFrame, "Email format is wrong.(example@example.com)", "Alert", JOptionPane.WARNING_MESSAGE);
                        }
                    } else if (!databaseConnect.checkUsername(jTextFieldUsername.getText()) && !databaseConnect.checkEmail(jTextFieldEmail.getText())) {
                        JOptionPane.showMessageDialog(jFrame, "Username and Email have been taken.", "Alert", JOptionPane.WARNING_MESSAGE);
                    } else if (!databaseConnect.checkUsername(jTextFieldUsername.getText()) && !jTextFieldEmail.getText().matches(stringRegex)) {
                        JOptionPane.showMessageDialog(jFrame, "Username has been taken and Email format is wrong.(example@example.com)", "Alert", JOptionPane.WARNING_MESSAGE);
                    } else if (!databaseConnect.checkUsername(jTextFieldUsername.getText())) {
                        JOptionPane.showMessageDialog(jFrame, "Username has been taken.", "Alert", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(jFrame, "Email has been taken.", "Alert", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        jButtonBack.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jFrame.dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        jPanelForButtons.add(jButtonBack);

        jFrame.add(jPanel, BorderLayout.CENTER);
        jFrame.add(jPanelForButtons, BorderLayout.SOUTH);


        jFrame.setSize(250, 150);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

    }
}
