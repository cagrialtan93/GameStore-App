import com.sun.source.tree.Tree;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
    private DefaultListModel defaultListModel = new DefaultListModel<>();
    private JList<String> jList = new JList<>(defaultListModel);
    private JScrollPane jScrollPane = new JScrollPane(jList);
    private ArrayList<String> treeNodes = new ArrayList<>();
    private DatabaseConnect databaseConnect = new DatabaseConnect();

    public String getSearchItem() {
        return searchField.getText();
    }

    public void setSearchItem(String searchItem) {
        this.searchItem = searchItem;
    }

    public SearchBox(GameStore gameStore, BinarySearchTree binarySearchTree, User user) throws SQLException {

        setTitle("Search Box");

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
                        new GameProfile(game, user, databaseConnect);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }

            }
        });
        searchButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!getSearchItem().isEmpty()) {
                    try {
                        if (databaseConnect.checkIfInDatabase(getSearchItem()) != null) {
                            System.out.println("added");
                        } else {
                            treeNodes.clear();
                            if (searchField.getText().equals("")) {

                            } else {
                                defaultListModel = binarySearchTree.addItemsToListModelFromArrayList(defaultListModel, binarySearchTree.returnSimilars(binarySearchTree.getRoot(), getSearchItem().substring(0, 1).toUpperCase() + getSearchItem().substring(1), treeNodes));
                            }
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    defaultListModel = binarySearchTree.inOrder(binarySearchTree.getRoot(), defaultListModel);
                }
                setSize(375, 200);
                jScrollPane.show();            }

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
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        setSize(375, 60);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

