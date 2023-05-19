import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        starting();
    }

    public static void createGenreLists(GameStore gameStore) {
        GenreLinkedList genreLinkedList = new GenreLinkedList("Select genre", gameStore);
        gameStore.addGenreList(genreLinkedList);
        GenreLinkedList action = new GenreLinkedList("Action",gameStore);
        gameStore.addGenreList(action);
        GenreLinkedList shooter = new GenreLinkedList("Shooter",gameStore);
        gameStore.addGenreList(shooter);
        GenreLinkedList strategy = new GenreLinkedList("Strategy",gameStore);
        gameStore.addGenreList(strategy);
        GenreLinkedList simulation = new GenreLinkedList("Simulation",gameStore);
        gameStore.addGenreList(simulation);
        GenreLinkedList sports = new GenreLinkedList("Sports",gameStore);
        gameStore.addGenreList(sports);
        GenreLinkedList racing = new GenreLinkedList("Racing",gameStore);
        gameStore.addGenreList(racing);
        GenreLinkedList horror = new GenreLinkedList("Horror",gameStore);
        gameStore.addGenreList(horror);
    }

    public static void starting() throws SQLException {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        GameStore gameStore = new GameStore();
        createGenreLists(gameStore);
        DatabaseConnect databaseConnect = new DatabaseConnect(gameStore, binarySearchTree);

        new Sign(gameStore, binarySearchTree, databaseConnect);

    }
}