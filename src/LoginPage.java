import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

public class LoginPage {
    JFrame jFrame = new JFrame();
    JLabel nameLabel = new JLabel("Username");
    JTextField usernameTextField = new JTextField();
    JLabel passwordLabel = new JLabel("Password");
    JTextField passwordTextField = new JTextField();
    JButton jButtonLogIn = new JButton("Login");
    JButton jButtonQuit = new JButton("Quit");

    public LoginPage(GameStore gameStore) {
        jFrame.setLayout(new GridLayout(3, 2));

        jFrame.add(nameLabel);
        jFrame.add(usernameTextField);
        jFrame.add(passwordLabel);
        jFrame.add(passwordTextField);
        jFrame.add(jButtonLogIn);
        jFrame.add(jButtonQuit);
        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(200, 120);
        jFrame.show();


        jButtonLogIn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (usernameTextField.getText().equals("admin") && passwordTextField.getText().equals("admin")) {
                    System.out.println("Hello admin");
                } else if (usernameTextField.getText().equals("cagri") && passwordTextField.getText().equals("cagri")) {
                    jFrame.dispose();
//                    try {
//                        LandingPage landingPage = new LandingPage(gameStore, );
//                    } catch (SQLException ex) {
//                        throw new RuntimeException(ex);
//                    }
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
        jButtonQuit.addMouseListener(new MouseListener() {
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
}
