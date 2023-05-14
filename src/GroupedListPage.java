import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;

public class GroupedListPage {
    private DatabaseConnect databaseConnect = new DatabaseConnect();
    private DefaultComboBoxModel<String> model;
    private JComboBox<String> dropDownMenu = new JComboBox<>();
    private DefaultListModel<String> stringDefaultListModel = new DefaultListModel<>();
    private JList<String> jList = new JList<>(stringDefaultListModel);
    private JPanel jPanel = new JPanel();

    JFrame frame = new JFrame();

    public GroupedListPage(GameStore gameStore) throws SQLException {
        jPanel.setLayout(new GridLayout(2, 1));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 600);
        frame.setResizable(false);

        for (int i = 0; i < gameStore.getGenreLinkedLists().size(); i++) {
            dropDownMenu.addItem(gameStore.getGenreLinkedLists().get(i).getGenre());
        }

        dropDownMenu.setMaximumSize(new Dimension(300,30));
        jPanel.add(dropDownMenu);
        jPanel.add(jList);
        dropDownMenu.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;

            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override

            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                stringDefaultListModel.clear();
                String selectedItem = (String) dropDownMenu.getSelectedItem();

                for (GenreLinkedList genreLinkedList :
                        gameStore.getGenreLinkedLists()) {
                    if (genreLinkedList.getGenre().equals(selectedItem)) {
                        for (int i = 0; i < genreLinkedList.linkedListToArray().length; i++) {
                            stringDefaultListModel.addElement(genreLinkedList.linkedListToArray()[i]);
                        }
                    }
                }
            }
        });


        //TODO set the default selection as 'Select genre'.

        frame.add(jPanel);
        frame.show();
    }
}
