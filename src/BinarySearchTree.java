import com.sun.source.tree.Tree;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    public DefaultListModel inOrder(TreeNode root, DefaultListModel<String> gameDefaultListModel) {
        if (root != null) {
            inOrder(root.getLeftChild(), gameDefaultListModel);
            gameDefaultListModel.addElement(root.getGame().getTitle());
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

    /*
    public ArrayList<String> returnSimilars(TreeNode root, String string, ArrayList<String> treeNodes) {
        if (root != null) {
            String[] array = (root.getGame().getTitle().toLowerCase().split(" "));
            List<String> arrayList = Arrays.asList(array);


            if (root.getGame().getTitle().compareTo(string) < 0) {
                returnSimilars(root.getRightChild(), string, treeNodes);
            }

            if (arrayList.contains(string.toLowerCase())) {
                treeNodes.add(root.getGame().getTitle());
            }

            if (root.getGame().getTitle().compareTo(string) >= 0) {
                returnSimilars(root.getLeftChild(), string, treeNodes);
                returnSimilars(root.getRightChild(), string, treeNodes);
            }
        }
        return treeNodes;
    }

     */
    public ArrayList<String> returnSimilars(TreeNode root, String string, ArrayList<String> treeNodes) {
        if (root != null) {
            String[] array = (root.getGame().getTitle().toLowerCase().split(" "));
            List<String> arrayList = Arrays.asList(array);

            returnSimilars(root.getLeftChild(), string, treeNodes);

            if (root.getGame().getTitle().compareTo(string) >= 0) {
                returnSimilars(root.getLeftChild(), string, treeNodes);
            }

            if (root.getGame().getTitle().toLowerCase().contains(string.toLowerCase())){
                if (treeNodes.contains(root.getGame().getTitle())){

                } else {
                    treeNodes.add(root.getGame().getTitle());
                }
            }

            if (arrayList.contains(string.toLowerCase())) {
                if (treeNodes.contains(root.getGame().getTitle())) {

                } else {
                    treeNodes.add(root.getGame().getTitle());
                }
            }

            if (root.getGame().getTitle().compareTo(string) >= 0) {
                returnSimilars(root.getRightChild(), string, treeNodes);
            }

            returnSimilars(root.getRightChild(), string, treeNodes);
        }
        return treeNodes;
    }


    public DefaultListModel<String> addItemsToListModelFromArrayList(DefaultListModel<String> defaultListModel, ArrayList<String> arrayList) {
        defaultListModel.clear();
        Collections.sort(arrayList);
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

    public void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.getLeftChild());
        System.out.println(treeNode.getGame().getTitle());
        inOrder(treeNode.getRightChild());
    }
}
