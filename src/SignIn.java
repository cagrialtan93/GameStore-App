import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

public class SignIn {
    JFrame jFrame = new JFrame("Sign In");
    JLabel nameLabel = new JLabel("Username");
    JTextField usernameTextField = new JTextField();
    JLabel passwordLabel = new JLabel("Password");
    JPasswordField passwordTextField = new JPasswordField();
    JButton jButtonLogIn = new JButton("Login");
    JButton jButtonBack = new JButton("Back");
    User user = new User();

    public SignIn(GameStore gameStore, BinarySearchTree binarySearchTree, DatabaseConnect databaseConnect) {
        nameLabel.setHorizontalAlignment(0);
        passwordLabel.setHorizontalAlignment(0);
        jFrame.setLayout(new GridLayout(3, 2));

        jFrame.add(nameLabel);
        jFrame.add(usernameTextField);
        jFrame.add(passwordLabel);
        jFrame.add(passwordTextField);
        jFrame.add(jButtonLogIn);
        jFrame.add(jButtonBack);
        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(200, 120);
        jFrame.show();

        jButtonLogIn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (databaseConnect.checkCredentials(getUsernameTextField().getText(), getPasswordTextField().getText()) != null) {
                    user = databaseConnect.checkCredentials(getUsernameTextField().getText(), getPasswordTextField().getText());
                    try {
                        new Profile(user, databaseConnect, gameStore, binarySearchTree);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    jFrame.dispose();
                } else {
                    if (getPasswordTextField().getText().equals("") || getUsernameTextField().getText().equals("")) {
                        JOptionPane.showMessageDialog(jFrame, "Username or password can't be empty!", "Alert", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(jFrame, "Wrong username or password!", "Alert", JOptionPane.WARNING_MESSAGE);
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
    }

    public JTextField getUsernameTextField() {
        return usernameTextField;
    }

    public void setUsernameTextField(JTextField usernameTextField) {
        this.usernameTextField = usernameTextField;
    }

    public JTextField getPasswordTextField() {
        return passwordTextField;
    }

    public void setPasswordTextField(JPasswordField passwordTextField) {
        this.passwordTextField = passwordTextField;
    }
}
