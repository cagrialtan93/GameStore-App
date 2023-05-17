import javax.swing.*;
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

    private JFrame jFrame = new JFrame();
    private JPanel jPanel = new JPanel();
    private JPanel jPanelButtons = new JPanel();

    public GameProfile(Game game, User user, DatabaseConnect databaseConnect) {
        jFrame.setLayout(new BorderLayout());
        jPanel.setLayout(new GridLayout(5,2));
        jPanelButtons.setLayout(new FlowLayout());

        jPanel.add(jLabelTitle);
        getjLabelTitle.setText(game.getTitle());
        jPanel.add(getjLabelTitle);

        jPanel.add(jLabelGenre);
        getjLabelGenre.setText(game.getGenre());
        jPanel.add(getjLabelGenre);

        jPanel.add(jLabelReleaseYear);
        getjLabelReleaseYear.setText(String.valueOf(game.getReleaseYear()));
        jPanel.add(getjLabelReleaseYear);

        jPanel.add(jLabelPublisher);
        getjLabelPublisher.setText(game.getPublisher());
        jPanel.add(getjLabelPublisher);

        jPanel.add(jLabelPrice);
        getjLabelPrice.setText(String.valueOf(game.getPrice()) + " ₺");
        jPanel.add(getjLabelPrice);

        jPanelButtons.add(jButtonBack);

        jButtonBuy.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                databaseConnect.addGamesBought(user, game);
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

        jFrame.add(jPanel, BorderLayout.CENTER);
        jFrame.add(jPanelButtons, BorderLayout.SOUTH);

        jFrame.setSize(250,225);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
