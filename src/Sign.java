import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Sign {
    JFrame jFrame = new JFrame();
    JPanel jFirstPanel = new JPanel();
    JPanel jSecondPanel = new JPanel();
    JLabel jLabel = new JLabel("Welcome!");
    JButton jButtonSignIn = new JButton("Sign In");
    JButton jButtonSignUp = new JButton("Sign Up");
    public Sign(GameStore gameStore, BinarySearchTree binarySearchTree, DatabaseConnect databaseConnect) {
        jFrame.setLayout(new GridLayout(2,1));

        jSecondPanel.setLayout(new FlowLayout());
        jButtonSignIn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new SignIn(gameStore, binarySearchTree, databaseConnect);
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
        jSecondPanel.add(jButtonSignIn);

        jSecondPanel.add(jButtonSignUp);
        jButtonSignUp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new SignUp(gameStore, binarySearchTree, databaseConnect);
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

        jLabel.setHorizontalAlignment(0);

        jFrame.add(jLabel);
        jFrame.add(jSecondPanel);

        jFrame.setSize(200,100);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

    }
}
