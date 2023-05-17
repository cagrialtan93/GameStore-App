import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;

public class GroupedListPage {
    private DatabaseConnect databaseConnect = new DatabaseConnect();
    private DefaultComboBoxModel<String> model;
    private JComboBox<String> dropDownMenu = new JComboBox<>();
    private DefaultListModel<String> stringDefaultListModel = new DefaultListModel<>();
    private JList<String> jList = new JList<>(stringDefaultListModel);
    private JPanel jPanel = new JPanel();
    private JFrame frame = new JFrame();
    private JButton jButtonBack = new JButton("Back");
    private JButton jButtonQuit = new JButton("Quit");
    private JPanel jPanelForButtons = new JPanel(new FlowLayout());

    public GroupedListPage(GameStore gameStore) throws SQLException {
        jPanel.setLayout(new BorderLayout());
        jPanelForButtons.add(jButtonBack);
        jButtonBack.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
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
        jPanelForButtons.add(jButtonQuit);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 600);

        for (int i = 0; i < gameStore.getGenreLinkedLists().size(); i++) {
            dropDownMenu.addItem(gameStore.getGenreLinkedLists().get(i).getGenre());
        }


        jPanel.add(dropDownMenu, BorderLayout.NORTH);
        jPanel.add(jList, BorderLayout.CENTER);
        jPanel.add(jPanelForButtons, BorderLayout.SOUTH);
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
