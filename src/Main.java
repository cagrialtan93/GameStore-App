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
        GenreLinkedList horror = new GenreLinkedList("Horror",gameStore);
        gameStore.addGenreList(horror);
        GenreLinkedList racing = new GenreLinkedList("Racing",gameStore);
        gameStore.addGenreList(racing);
        GenreLinkedList shooter = new GenreLinkedList("Shooter",gameStore);
        gameStore.addGenreList(shooter);
        GenreLinkedList simulation = new GenreLinkedList("Simulation",gameStore);
        gameStore.addGenreList(simulation);
        GenreLinkedList sports = new GenreLinkedList("Sports",gameStore);
        gameStore.addGenreList(sports);
        GenreLinkedList strategy = new GenreLinkedList("Strategy",gameStore);
        gameStore.addGenreList(strategy);
        GenreLinkedList survival = new GenreLinkedList("Survival",gameStore);
        gameStore.addGenreList(survival);
    }

    public static void starting() throws SQLException {
        GameStore gameStore = new GameStore();
        createGenreLists(gameStore);
        DatabaseConnect databaseConnect = new DatabaseConnect(gameStore, gameStore.getBinarySearchTree());
        new Sign(gameStore, gameStore.getBinarySearchTree(), databaseConnect);
    }
}