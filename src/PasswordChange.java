import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PasswordChange {
    JFrame jFrame = new JFrame("Change Password");
    JLabel jLabelPassword = new JLabel("New password");
    JLabel jLabelRePassword = new JLabel("Confirm new password");
    JPasswordField jTextFieldPassword = new JPasswordField();
    JPasswordField jTextFieldRePassword = new JPasswordField();
    JPanel jPanel = new JPanel(new GridLayout(3, 2));
    JButton jButtonChange = new JButton("Change");
    JButton jButtonBack = new JButton("Back");

    public PasswordChange(DatabaseConnect databaseConnect, User user) {
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
        jButtonChange.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jTextFieldPassword.getText().equals("") || jTextFieldRePassword.getText().equals("")) {
                    JOptionPane.showMessageDialog(jFrame, "Password fields can't be empty!", "Alert", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (jTextFieldPassword.getText().equals(jTextFieldRePassword.getText())) {
                        databaseConnect.changePassword(user.getUsername(), jTextFieldPassword.getText());
                        JOptionPane.showMessageDialog(jFrame, "Success.", "Alert", JOptionPane.WARNING_MESSAGE);
                        jFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(jFrame, "Passwords don't match.", "Alert", JOptionPane.WARNING_MESSAGE);
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

        jPanel.add(jLabelPassword);
        jPanel.add(jTextFieldPassword);
        jPanel.add(jLabelRePassword);
        jPanel.add(jTextFieldRePassword);
        jPanel.add(jButtonBack);
        jPanel.add(jButtonChange);

        jFrame.add(jPanel);
        jFrame.setSize(300, 100);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
