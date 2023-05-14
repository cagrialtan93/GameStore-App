import com.sun.source.tree.Tree;

import javax.swing.*;

public class BinarySearchTree {
    private TreeNode root;
    private int size;
    private DefaultListModel<Game> gameDefaultListModel = new DefaultListModel<>();

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public DefaultListModel<Game> getGameDefaultListModel() {
        return gameDefaultListModel;
    }

    public void insertGame(Game game) {
        TreeNode treeNodeToAdd = new TreeNode(game);
        if (root == null) {
            root = treeNodeToAdd;
        } else {
            root.insertGame(game);
        }
    }

    public DefaultListModel inOrder(TreeNode root, DefaultListModel<Game> gameDefaultListModel) {
        if (root != null) {
            inOrder(root.getLeftChild(), gameDefaultListModel);
            gameDefaultListModel.addElement(root.getGame());
            inOrder(root.getRightChild(), gameDefaultListModel);
        }
        return gameDefaultListModel;
    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.getLeftChild());
            System.out.println(root.getGame().getTitle());
            inOrder(root.getRightChild());
        }
    }

    public void searchByName(String name) {

    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
