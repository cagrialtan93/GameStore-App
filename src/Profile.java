import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

public class Profile
{
    private JFrame jFrame = new JFrame();
    private JLabel jLabelUsername = new JLabel("Username");
    private JButton jButtonChangeUsername = new JButton("Change");
    private JLabel getjLabelUsername = new JLabel();
    private JLabel jLabelPassword = new JLabel("Password");
    private JButton jButtonChangePassword = new JButton("Change");
    private JLabel getjLabelPassword = new JLabel("*********");
    private JLabel jLabelEmail = new JLabel("Email");
    private JButton jButtonChangeEmail = new JButton("Change");
    private JLabel getjLabelEmail = new JLabel();
    private JLabel jLabelMyGames = new JLabel("My Games");
    private DefaultListModel defaultListModel = new DefaultListModel<>();
    private JList jList = new JList<>();
    private JScrollPane jScrollPane = new JScrollPane();
    private JButton jButtonLogout = new JButton("Logout");
    private JButton jButtonStore = new JButton("Game Store");
    private JPanel jPanelTop = new JPanel();
    private JPanel jPanelCenter = new JPanel();
    private JPanel jPanelBottom = new JPanel();

    public Profile(User user, DatabaseConnect databaseConnect, GameStore gameStore, BinarySearchTree binarySearchTree) throws SQLException {

        jFrame.setLayout(new BorderLayout());
        jPanelTop.setLayout(new GridLayout(3,4));
        jPanelCenter.setLayout(new BorderLayout());
        jPanelBottom.setLayout(new FlowLayout());

        jScrollPane = new JScrollPane(new JList<>(databaseConnect.getMyGames(user)));

        getjLabelUsername.setText(user.getUsername());
        getjLabelEmail.setText(user.getEmail());

        jPanelTop.add(jLabelUsername);
        jPanelTop.add(getjLabelUsername);
        jPanelTop.add(jButtonChangeUsername);
        jPanelTop.add(jLabelPassword);
        jPanelTop.add(getjLabelPassword);
        jPanelTop.add(jButtonChangePassword);
        jPanelTop.add(jLabelEmail);
        jPanelTop.add(getjLabelEmail);
        jPanelTop.add(jButtonChangeEmail);

        jButtonLogout.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jFrame.dispose();
                new Sign(gameStore, binarySearchTree, databaseConnect);
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
        jButtonStore.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jFrame.dispose();
                new AskingScreen(gameStore, binarySearchTree, user, databaseConnect);
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

        jPanelCenter.add(jLabelMyGames, BorderLayout.NORTH);
        jPanelCenter.add(jScrollPane, BorderLayout.CENTER);

        jPanelBottom.add(jButtonLogout);
        jPanelBottom.add(jButtonStore);

        jFrame.add(jPanelTop, BorderLayout.NORTH);
        jFrame.add(jPanelCenter, BorderLayout.CENTER);
        jFrame.add(jPanelBottom, BorderLayout.SOUTH);

        jFrame.setSize(450,400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

}
