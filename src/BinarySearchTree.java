import com.sun.source.tree.Tree;

import javax.swing.*;
import java.util.ArrayList;

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

    public TreeNode search(TreeNode root, String gameName) {
        if (root == null || root.getGame().getTitle().equals(gameName))
            return root;

        if (root.getGame().getTitle().compareTo(gameName) > 0)
            return search(root.getLeftChild(), gameName);

        return search(root.getRightChild(), gameName);
    }

    public ArrayList<String> returnSimilars(TreeNode root, String string, ArrayList<String> treeNodes) {
        if (root != null) {
            // If the node's value contains the search key, add it to the list
            if (root.getGame().getTitle().contains(string)) {
                treeNodes.add(root.getGame().getTitle());
            }

            // If the node's value is lexicographically less than the search key,
            // search the right subtree (which contains larger values)
            if (root.getGame().getTitle().compareTo(string) < 0) {
                returnSimilars(root.getRightChild(), string, treeNodes);
            }

            // If the node's value is lexicographically greater than or equal to the search key,
            // search the left subtree (which contains smaller values) and the right subtree
            // (since there may be more matches in the larger values)
            if (root.getGame().getTitle().compareTo(string) >= 0) {
                returnSimilars(root.getLeftChild(), string, treeNodes);
                returnSimilars(root.getRightChild(), string, treeNodes);
            }
        }
        return treeNodes;
    }

    public DefaultListModel<String> addItemsToListModelFromArrayList(DefaultListModel<String> defaultListModel, ArrayList<String> arrayList) {
        defaultListModel.clear();
        defaultListModel.addAll(arrayList);
        return defaultListModel;
    }


    public ArrayList<TreeNode> inOrder(TreeNode root, String string) {
        ArrayList<TreeNode> treeNodes = new ArrayList<>();

        if (root != null) {
            inOrder(root.getLeftChild(), string);
            System.out.println(root.getGame().getTitle());
            if (root.getGame().getTitle().toLowerCase().contains(string.toLowerCase())) {
                treeNodes.add(root);
            }
            inOrder(root.getRightChild(), string);
        }

        return treeNodes;
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
