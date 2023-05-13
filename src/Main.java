import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        GameStore gameStore = new GameStore();

        BinarySearchTree binarySearchTree = null;

        DatabaseConnect databaseConnect = new DatabaseConnect(gameStore, binarySearchTree);

        new AskingScreen(gameStore);

    }
}