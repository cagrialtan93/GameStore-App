import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.concurrent.Flow;

public class AskingScreen {
    JFrame frame = new JFrame();

    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel(new FlowLayout());
    JLabel jLabel = new JLabel("How would you like to see our games?");
    JButton jButtonList = new JButton("List");
    JButton jButtonGrouped = new JButton("Grouped by Genre");
    JButton jButtonSearch = new JButton("Search by Title");
    JButton jButtonBackToProfile = new JButton("Back To Profile");
    JLabel jLabelWelcomeUser = new JLabel();

    public AskingScreen(GameStore gameStore, BinarySearchTree binarySearchTree, User user, DatabaseConnect databaseConnect) {
        frame.setLayout(new GridLayout(4, 1));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(600, 160);


        jLabelWelcomeUser.setHorizontalAlignment(0);
        jLabelWelcomeUser.setText("Welcome " + user.getUsername());

        jButtonList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    new LandingPage(gameStore, user, binarySearchTree, databaseConnect);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
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
        jButtonGrouped.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    new GroupedListPage(gameStore, user, databaseConnect);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
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
        jButtonSearch.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    new SearchBox(gameStore, binarySearchTree, user, databaseConnect);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
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
        jButtonBackToProfile.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                try {
                    new Profile(user, databaseConnect, gameStore, binarySearchTree);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
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

        jPanel1.add(jLabel);
        jPanel2.add(jButtonList);
        jPanel2.add(jButtonGrouped);
        jPanel2.add(jButtonSearch);
        jPanel2.add(jButtonBackToProfile);

        frame.add(jLabelWelcomeUser);
        frame.add(jPanel1);
        frame.add(jPanel2);
        frame.show();
    }
}
