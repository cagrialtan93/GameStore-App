import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        GameStore gameStore = new GameStore();
        createGenreLists(gameStore);
        DatabaseConnect databaseConnect = new DatabaseConnect(gameStore, binarySearchTree);

        ArrayList<TreeNode> treeNodes = new ArrayList<>();

        new Sign(gameStore, binarySearchTree, databaseConnect);
    }

    public static void createGenreLists(GameStore gameStore) { 
        GenreLinkedList action = new GenreLinkedList("Action");
        gameStore.addGenreList(action);
        GenreLinkedList shooter = new GenreLinkedList("Shooter");
        gameStore.addGenreList(shooter);
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