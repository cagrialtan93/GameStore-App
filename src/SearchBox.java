import com.sun.source.tree.Tree;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchBox extends JFrame {
    private JTextField searchField = new JTextField(15);
    private JButton searchButton = new JButton("Search");
    private JButton backButton = new JButton("Back");
    private String searchItem;
    private DefaultListModel defaultListModel = new DefaultListModel<>();
    private JList jList = new JList<>(defaultListModel);
    private JScrollPane jScrollPane = new JScrollPane(jList);
    private ArrayList<String> treeNodes = new ArrayList<>();
    private DatabaseConnect databaseConnect = new DatabaseConnect();

    public String getSearchItem() {
        return searchField.getText();
    }

    public void setSearchItem(String searchItem) {
        this.searchItem = searchItem;
    }

    public SearchBox(GameStore gameStore, BinarySearchTree binarySearchTree) throws SQLException {

        setTitle("Search Box");

        add(searchField, BorderLayout.WEST);
        add(searchButton, BorderLayout.CENTER);
        add(backButton, BorderLayout.EAST);
        add(jScrollPane, BorderLayout.SOUTH);
        searchButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (false) { // databaseConnect.checkIfInDatabase(getSearchItem())
                    System.out.println("added");
                } else {
                    treeNodes.clear();
                    defaultListModel = binarySearchTree.addItemsToListModelFromArrayList(defaultListModel, binarySearchTree.returnSimilars(binarySearchTree.getRoot(), getSearchItem(), treeNodes));
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

        // Set the size of the frame and make it visible
        setSize(375, 600);

        setLocationRelativeTo(null);
        setVisible(true);
    }

}

