import com.sun.source.tree.Tree;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws SQLException {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        GameStore gameStore = new GameStore();
        createGenreLists(gameStore);
        DatabaseConnect databaseConnect = new DatabaseConnect(gameStore, binarySearchTree);

        new AskingScreen(gameStore, binarySearchTree);

        ArrayList<TreeNode> treeNodes = new ArrayList<>();

//        for (TreeNode treeNode :
//                binarySearchTree.returnSimilars(binarySearchTree.getRoot(), "Dota", treeNodes)) {
//            System.out.println(treeNode.getGame().getTitle());
//        }
    }

    public static void createGenreLists(GameStore gameStore) {
        GenreLinkedList action = new GenreLinkedList("Action");
        gameStore.addGenreList(action);
        GenreLinkedList shooter = new GenreLinkedList("Shooter");
        gameStore.addGenreList(shooter);
        GenreLinkedList adventure = new GenreLinkedList("Adventure");
        gameStore.addGenreList(adventure);
        GenreLinkedList strategy = new GenreLinkedList("Strategy");
        gameStore.addGenreList(strategy);
        GenreLinkedList simulation = new GenreLinkedList("Simulation");
        gameStore.addGenreList(simulation);
        GenreLinkedList sports = new GenreLinkedList("Sports");
        gameStore.addGenreList(sports);
        GenreLinkedList racing = new GenreLinkedList("Racing");
        gameStore.addGenreList(racing);
        GenreLinkedList horror = new GenreLinkedList("Horror");
        gameStore.addGenreList(horror);
    }
}