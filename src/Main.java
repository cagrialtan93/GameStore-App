import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        GameStore gameStore = new GameStore();
        gameStore.addGenre("Action");
        gameStore.addGenre("Survival");
        gameStore.addGenre("Shooter");
        gameStore.addGenre("MMO");
        gameStore.addGenre("Adventure");

        DatabaseConnect databaseConnect = new DatabaseConnect(gameStore);

        new AddingGamePage();
    }
}