import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.sql.SQLException;

public class GroupedListPage {
    private DatabaseConnect databaseConnect = new DatabaseConnect();
    private JComboBox<String> dropDownMenu;
    private String[] genreList = new String[databaseConnect.getGenreNames().size()];
    JFrame frame = new JFrame();
    public GroupedListPage(GameStore gameStore) throws SQLException {
        frame.setLayout(new GridLayout(2, 1));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 100);
        frame.setResizable(false);

        for (int i = 0; i < databaseConnect.getGenreNames().size(); i++) {
            genreList[i] = databaseConnect.getGenreNames().get(i);
        }
        dropDownMenu = new JComboBox<>(genreList);

        frame.add(dropDownMenu);

        frame.show();

    }
}
