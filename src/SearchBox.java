import com.sun.source.tree.Tree;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.*;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchBox extends JFrame {
    private JTextField searchField = new JTextField(15);
    private JButton searchButton = new JButton("Search");
    private JButton backButton = new JButton("Back");
    private String searchItem;
    private DefaultListModel defaultListModel = new DefaultListModel();
    private JList<String> jList = new JList<>();
    private JScrollPane jScrollPane = new JScrollPane(jList);
    private ArrayList<String> treeNodes = new ArrayList<>();
    private DefaultListModel<String> stringDefaultListModel = null;

    public String getSearchItem() {
        return searchField.getText();
    }

    public void setSearchItem(String searchItem) {
        this.searchItem = searchItem;
    }

    public SearchBox(GameStore gameStore, BinarySearchTree binarySearchTree, User user, DatabaseConnect databaseConnect) throws SQLException {
        setTitle("Search by Title");

        add(searchField, BorderLayout.WEST);
        add(searchButton, BorderLayout.CENTER);
        add(backButton, BorderLayout.EAST);
        add(jScrollPane, BorderLayout.SOUTH);

        jScrollPane.hide();

        jList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Game game = null;
                if (e.getClickCount() == 2) {
                    String selectedItem = jList.getSelectedValue();
                    try {
                        game = databaseConnect.checkIfInDatabase(selectedItem);
                        if (game != null){
                            new GameProfile(game, user, databaseConnect);
                        } else {

                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException("Nothing");
                    }
                }

            }
        });

        searchButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (!getSearchItem().isEmpty()) {
                    treeNodes.clear();
                    stringDefaultListModel = binarySearchTree.addItemsToListModelFromArrayList(defaultListModel, binarySearchTree.returnSimilars(binarySearchTree.getRoot(), getSearchItem().substring(0, 1).toUpperCase() + getSearchItem().substring(1), treeNodes));
                    if (stringDefaultListModel.size() == 0) {
                        JOptionPane.showMessageDialog(null, "Sorry, no matches were found.");
                    } else if (getSearchItem().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Sorry, no matches were found.");
                    } else {
                        jList.setModel(stringDefaultListModel);
                    }
                } else {
                    defaultListModel.clear();
                    JOptionPane.showMessageDialog(null, "Sorry, no matches were found.");
                }
                setSize(375, 200);
                jScrollPane.show();
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
        backButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
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

        setSize(375, 60);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

