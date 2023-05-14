import java.awt.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws SQLException {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        GameStore gameStore = new GameStore();
        createGenreLists(gameStore);
        DatabaseConnect databaseConnect = new DatabaseConnect(gameStore, binarySearchTree);

        new GroupedListPage(gameStore);
        
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