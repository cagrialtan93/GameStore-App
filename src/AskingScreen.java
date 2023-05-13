import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.concurrent.Flow;

public class AskingScreen {
    JFrame frame = new JFrame();

    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel();

    JLabel jLabel = new JLabel("How would you like to see our games?");
    JButton jButtonList = new JButton("List");
    JButton jButtonGrouped = new JButton("Grouped by Genre");

    public AskingScreen(GameStore gameStore) {
        frame.setLayout(new GridLayout(2, 1));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 100);
        frame.setResizable(false);

        jButtonList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    new LandingPage(gameStore);
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
                    new GroupedListPage(gameStore);
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

        frame.add(jPanel1);
        frame.add(jPanel2);
        frame.show();
    }
}
