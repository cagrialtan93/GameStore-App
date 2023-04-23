import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

public class AddingGamePage {
    private JFrame jFrame = new JFrame("Add Game");
    private JLabel jLabelTitle = new JLabel("Title:");
    private JLabel jLabelReleaseYear = new JLabel("Release Year");
    private JLabel jLabelGenre = new JLabel("Genre");
    private JTextField jTextFieldTitle = new JTextField();
    private JTextField jTextFieldReleaseYear = new JTextField();
    private JTextField jTextFieldGenre = new JTextField();
    private Game game = new Game();
    private DatabaseConnect databaseConnect = new DatabaseConnect();
    private JButton jButtonAdd = new JButton("Add");
    private JButton jButtonBack = new JButton("Back");
    Boolean textFieldTitle;

    GridLayout gridLayout = new GridLayout(4, 4);

    public AddingGamePage() throws SQLException {
        jFrame.setLayout(gridLayout);
        jFrame.add(jLabelTitle);
        jFrame.add(jTextFieldTitle);
        jFrame.add(jLabelGenre);
        jFrame.add(jTextFieldGenre);
        jFrame.add(jLabelReleaseYear);
        jFrame.add(jTextFieldReleaseYear);
        jFrame.add(jButtonAdd);
        jFrame.add(jButtonBack);


        jButtonAdd.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!textFieldTitle) {
                    System.out.println("Correct first");
                } else {
                    game.setTitle(jTextFieldTitle.getText());
                    game.setReleaseYear(Integer.parseInt(jTextFieldReleaseYear.getText()));
                    game.setGenre(jTextFieldGenre.getText());
                    try {
                        databaseConnect.addGame(game);
                        JOptionPane.showMessageDialog(jFrame, "Added");
                    } catch (SQLException ex) {
                        throw new RuntimeException("Not happening");
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

        //TODO write validation code for genre and release year

        jTextFieldTitle.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jTextFieldTitle.getText().matches("[\\p{L}\\d\\s:]+")) {
                    textFieldTitle = true;
                    jTextFieldTitle.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
                } else {
                    jTextFieldTitle.setBorder(BorderFactory.createLineBorder(Color.red));
                    textFieldTitle = false;
                }
            }
        });

        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(250, 125);
        jFrame.show();
    }
}
