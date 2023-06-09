import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameProfile {
    private JLabel jLabelTitle = new JLabel("Title");
    private JLabel getjLabelTitle = new JLabel();
    private JLabel jLabelGenre = new JLabel("Genre");
    private JLabel getjLabelGenre = new JLabel();
    private JLabel jLabelReleaseYear = new JLabel("Release Year");
    private JLabel getjLabelReleaseYear = new JLabel();
    private JLabel jLabelPublisher = new JLabel("Publisher");
    private JLabel getjLabelPublisher = new JLabel();
    private JLabel jLabelPrice = new JLabel("Price");
    private JLabel getjLabelPrice = new JLabel();

    private JButton jButtonBack = new JButton("Back");
    private JButton jButtonBuy = new JButton("Buy");

    private JFrame jFrame = new JFrame("Game Profile");
    private JPanel jPanel = new JPanel();
    private JPanel jPanelButtons = new JPanel();
    private JPanel jPanelSecond = new JPanel();

    public GameProfile(Game game, User user, DatabaseConnect databaseConnect) {
        jFrame.setLayout(new BorderLayout());
        jPanel.setLayout(new GridLayout(5, 1));
        jPanelSecond.setLayout(new GridLayout(5,1));
        jPanelSecond.setBorder(new EmptyBorder(0,10,0,0));
        jPanelButtons.setLayout(new FlowLayout());

        jPanel.add(jLabelTitle);
        getjLabelTitle.setText(game.getTitle());
        jPanelSecond.add(getjLabelTitle);

        jPanel.add(jLabelGenre);
        getjLabelGenre.setText(game.getGenre());
        jPanelSecond.add(getjLabelGenre);

        jPanel.add(jLabelReleaseYear);
        getjLabelReleaseYear.setText(String.valueOf(game.getReleaseYear()));
        jPanelSecond.add(getjLabelReleaseYear);

        jPanel.add(jLabelPublisher);
        getjLabelPublisher.setText(game.getPublisher());
        jPanelSecond.add(getjLabelPublisher);

        jPanel.add(jLabelPrice);
        if (game.getPrice() == 0){
            getjLabelPrice.setText("Free to Play");
        } else {
            getjLabelPrice.setText(String.valueOf(game.getPrice()) + " ₺");
        }
        jPanelSecond.add(getjLabelPrice);

        jPanelButtons.add(jButtonBack);
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

        jButtonBuy.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (databaseConnect.addGamesBought(user, game)) {
                    JOptionPane.showMessageDialog(jFrame, "Game successfully bought and added to your account.Let's play!");
                    jFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(jFrame,"You already have that game in your library.","Alert",JOptionPane.WARNING_MESSAGE);
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
        jPanelButtons.add(jButtonBuy);

        jFrame.add(jPanel, BorderLayout.WEST);
        jFrame.add(jPanelSecond, BorderLayout.CENTER);
        jFrame.add(jPanelButtons, BorderLayout.SOUTH);

        jFrame.setSize(350, 225);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
