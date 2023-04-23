import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.sql.SQLException;

public class LandingPage {
    private GameStore gameStore;
    private Game[] games;
    private DatabaseConnect databaseConnect;
    private DefaultListModel<Game> gameDefaultListModel = new DefaultListModel<>();

    public LandingPage(GameStore gameStore) throws SQLException {
        this.gameStore = gameStore;
        JFrame jFrame = new JFrame("Online Game Store");


        JList<Game> jList = new JList<>(); // TODO get this properly


        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    if (!e.getValueIsAdjusting()) {
                        System.out.println(jList.getSelectedValue().getTitle());
                    }
                } catch (Exception error) {
                    System.out.println("Nothing has selected.");
                }
            }
        });

        jFrame.add(jList);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(400, 400);
        jFrame.show();

    }
}
